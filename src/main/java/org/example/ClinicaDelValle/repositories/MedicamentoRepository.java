package org.example.ClinicaDelValle.repositories;

import org.example.ClinicaDelValle.model.Medicamento;
import org.example.ClinicaDelValle.model.MedicamentoRecetado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {
    Optional<Object> findByNombre(String nombre);
}
