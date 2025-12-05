package org.example.ClinicaDelValle.services;
import org.example.ClinicaDelValle.Exceptions.CitaConflictException;
import org.example.ClinicaDelValle.model.*;
import org.example.ClinicaDelValle.repositories.CitaRepository;
import org.example.ClinicaDelValle.repositories.DoctorRepository;
import org.example.ClinicaDelValle.repositories.SalaRepository;
import org.example.ClinicaDelValle.repositories.UsuarioRepository;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class CitaService {
    @Autowired
    private CitaRepository citaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private SalaRepository salaRepository;
    public void validarConflictos(Cita cita) {
        // Corrección: Convierte Date a LocalDateTime correctamente
        LocalDateTime inicio = LocalDateTime.ofInstant(cita.getFecha().toInstant(), java.time.ZoneId.systemDefault())
                .with(java.time.LocalTime.parse(cita.getHora()));
        LocalDateTime fin = inicio.plusMinutes(30);  // Asume 30 min; agrega campo si varía
        // Conflicto con doctor
        List<Cita> citasDoctor = citaRepository.findByDoctorAndFechaHoraBetween(cita.getMedico(), inicio, fin);
        if (!citasDoctor.isEmpty() && !citasDoctor.get(0).getId().equals(cita.getId())) {
            throw new CitaConflictException("El médico tiene otra cita en ese horario.");
        }
        // Conflicto con sala (si agregas Sala a Cita)
        // List<Cita> citasSala = citaRepository.findBySalaAndFechaHoraBetween(cita.getSala(), inicio, fin);
        // if (!citasSala.isEmpty()) throw new CitaConflictException("La sala está ocupada.");
    }

    public boolean verificarDisponibilidadDoctor(Usuario medico, LocalDateTime inicio, LocalDateTime fin) {
        List<Cita> citas = citaRepository.findByDoctorAndFechaHoraBetween(medico, inicio, fin);
        return citas.isEmpty();
    }

    public boolean verificarDisponibilidadSala(Sala sala, LocalDateTime inicio, LocalDateTime fin) {
        // Similar a doctor, si tienes Sala en Cita
        return true;  // Placeholder
    }

    @Transactional
    public Cita cambiarEstado(Long citaId, Cita.EstadoCita nuevoEstado) {
        Cita cita = citaRepository.findById(citaId)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));
        cita.setEstado(nuevoEstado);
        return citaRepository.save(cita);
    }

    @Transactional
    public Cita agendarCita(Cita cita) {
        validarConflictos(cita);
        cita.setEstado(Cita.EstadoCita.PENDIENTE);
        return citaRepository.save(cita);
    }
}
