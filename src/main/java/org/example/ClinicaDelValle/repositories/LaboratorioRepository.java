package org.example.ClinicaDelValle.repositories;

import org.example.ClinicaDelValle.model.ResultadoExamen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaboratorioRepository extends JpaRepository<ResultadoExamen,Long> {
}
