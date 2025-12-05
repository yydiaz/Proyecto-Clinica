package org.example.ClinicaDelValle.services;

import org.example.ClinicaDelValle.model.Cita;
import org.example.ClinicaDelValle.model.ExpedienteDigital;
import org.example.ClinicaDelValle.model.HistoriaClinica;
import org.example.ClinicaDelValle.repositories.CitaRepository;
import org.example.ClinicaDelValle.repositories.ExpedienteDigitalRepository;
import org.example.ClinicaDelValle.repositories.HistoriaClinicaRepository;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

@Service
public class HistoriaClinicaServices {
    @Autowired
    private HistoriaClinicaRepository historiaRepository;
    @Autowired
    private ExpedienteDigitalRepository expedienteRepository;
    @Autowired
    private CitaRepository citaRepository;
    @Transactional
    public HistoriaClinica crearRegistroClinico(Long pacienteId, HistoriaClinica registro) {
        ExpedienteDigital expediente = expedienteRepository.findByPacienteId(pacienteId)
                .orElseThrow(() -> new RuntimeException("Expediente no encontrado"));
        registro.setExpediente(expediente);
        return historiaRepository.save(registro);
    }

    @Transactional
    public HistoriaClinica vincularConCita(Long citaId, HistoriaClinica registro) {
        Cita cita = citaRepository.findById(citaId)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada"));
        ExpedienteDigital expediente = cita.getPaciente().getExpediente();
        if (expediente == null) throw new RuntimeException("Paciente sin expediente");
        registro.setExpediente(expediente);
        registro.setFecha(cita.getFecha());
        return historiaRepository.save(registro);
    }

    @Transactional
    public HistoriaClinica actualizarDiagnostico(Long idHistorial, String diagnostico, String tratamiento) {
        HistoriaClinica hist = historiaRepository.findById(idHistorial)
                .orElseThrow(() -> new RuntimeException("Historial no encontrado"));
        hist.setDescripcion(diagnostico + "\nTratamiento: " + tratamiento);
        return historiaRepository.save(hist);
    }
}
