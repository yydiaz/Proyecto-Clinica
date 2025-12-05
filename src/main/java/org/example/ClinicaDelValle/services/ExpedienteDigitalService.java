package org.example.ClinicaDelValle.services;

import org.example.ClinicaDelValle.model.AccesoExpediente;
import org.example.ClinicaDelValle.model.ExpedienteDigital;
import org.example.ClinicaDelValle.model.Paciente;
import org.example.ClinicaDelValle.model.Usuario;
import org.example.ClinicaDelValle.repositories.*;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@Service
public class ExpedienteDigitalService {
    @Autowired
    private ExpedienteDigitalRepository expedienteRepository;
    @Autowired
    private HistoriaClinicaRepository historiaRepository;
    @Autowired
    private CitaRepository citaRepository;
    @Autowired
    private ResultadoExamenRepository resultadoRepository;
    @Autowired
    private AccesoExpedienteRepository accesoRepository;
    @Transactional
    public ExpedienteDigital generarExpediente(Paciente paciente) {
        ExpedienteDigital expediente = new ExpedienteDigital();
        expediente.setPaciente(paciente);
        expediente.setFechaCreacion(java.time.LocalDate.now());
        expediente.setEstado(ExpedienteDigital.EstadoExpediente.ACTIVO);
        return expedienteRepository.save(expediente);
    }

    @Transactional(readOnly = true)
    public byte[] generarPdfConsolidado(Long expedienteId) {
        ExpedienteDigital expediente = expedienteRepository.findById(expedienteId)
                .orElseThrow(() -> new RuntimeException("Expediente no encontrado"));
        // Implementa generación de PDF aquí (ej. con iText). Por ahora, vacío.
        return new byte[0];
    }
    @Transactional
    public ExpedienteDigital actualizarExpediente(ExpedienteDigital expediente) {
        return expedienteRepository.save(expediente);
    }

    @Transactional
    public AccesoExpediente registrarAcceso(Long expedienteId, Usuario usuario, String tipoAcceso) {
        ExpedienteDigital expediente = expedienteRepository.findById(expedienteId)
                .orElseThrow(() -> new RuntimeException("Expediente no encontrado"));
        AccesoExpediente acceso = new AccesoExpediente();
        acceso.setExpediente(expediente);
        acceso.setUsuario(usuario);
        acceso.setFechaAcceso(LocalDateTime.now());
        acceso.setTipoAcceso(tipoAcceso);
        return accesoRepository.save(acceso);
    }
}
