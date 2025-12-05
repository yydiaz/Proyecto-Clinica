package org.example.ClinicaDelValle.repositories;

import org.example.ClinicaDelValle.model.ExpedienteDigital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExpedienteDigitalRepository extends JpaRepository<ExpedienteDigital,Long> {
    Optional<ExpedienteDigital> findByPacienteId(Long pacienteId);
}
