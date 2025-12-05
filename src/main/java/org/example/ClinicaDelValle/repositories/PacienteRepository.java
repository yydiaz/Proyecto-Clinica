package org.example.ClinicaDelValle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.ClinicaDelValle.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente,Long> {
}
