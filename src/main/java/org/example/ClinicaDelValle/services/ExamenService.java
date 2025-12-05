package org.example.ClinicaDelValle.services;

import org.example.ClinicaDelValle.model.OrdenExamen;
import org.example.ClinicaDelValle.repositories.HistoriaClinicaRepository;
import org.example.ClinicaDelValle.repositories.LaboratorioRepository;
import org.example.ClinicaDelValle.repositories.OrdenExamenRepository;
import org.example.ClinicaDelValle.repositories.ResultadoExamenRepository;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

@Service
public class ExamenService {
    @Autowired
    private OrdenExamenRepository ordenRepository;
    @Autowired
    private ResultadoExamenRepository resultadoRepository;
    @Autowired
    private LaboratorioRepository laboratorioRepository;
    @Autowired
    private HistoriaClinicaRepository historiaRepository;
    @Transactional
    public OrdenExamen registrarOrden(OrdenExamen orden) {
        if (orden.getLaboratorio() != null) {
            laboratorioRepository.findById(Long.valueOf(orden.getLaboratorio().getId()))
                    .orElseThrow(() -> new RuntimeException("Laboratorio no encontrado"));
        }
        return ordenRepository.save(orden);
    }
}
