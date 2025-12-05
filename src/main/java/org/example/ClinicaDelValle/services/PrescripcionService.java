package org.example.ClinicaDelValle.services;

import org.example.ClinicaDelValle.model.*;
import org.example.ClinicaDelValle.repositories.MedicamentoRepository;
import org.example.ClinicaDelValle.repositories.RecetaRepository;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

@Service
public class PrescripcionService {
    @Autowired
    private RecetaRepository recetaRepository;  // Solo este
    @Autowired
    private MedicamentoRepository medicamentoRepository;  // Y este
    /**
     * Genera prescripción, valida stock y descuenta automáticamente.
     */
    @Transactional
    public Receta generarPrescripcion(Receta receta) {
        for (MedicamentoRecetado med : receta.getMedicamentos()) {
            // Asume que MedicamentoRecetado tiene un campo 'medicamento' o busca por nombre
            Medicamento m = (Medicamento) medicamentoRepository.findByNombre(med.getNombre())  // Agrega este método al repo si no lo tienes
                    .orElseThrow(() -> new RuntimeException("Medicamento no encontrado."));
            if (m.getStock() == null || m.getStock() <= 0) {
                throw new RuntimeException("Stock insuficiente para " + m.getNombre());
            }
            // Descuenta stock (ej. 1 unidad por prescripción; calcula según dosis/frecuencia)
            m.setStock(m.getStock() - 1);
            medicamentoRepository.save(m);
        }
        receta.setFecha(java.sql.Date.valueOf(java.time.LocalDate.now()));
        return recetaRepository.save(receta);
    }
}
