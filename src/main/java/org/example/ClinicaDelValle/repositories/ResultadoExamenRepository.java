package org.example.ClinicaDelValle.repositories;

import org.example.ClinicaDelValle.model.ResultadoExamen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ResultadoExamenRepository extends JpaRepository<ResultadoExamen,Long> {
    @Query("SELECT r FROM ResultadoExamen r WHERE r.orden.consulta.expediente.id = :expedienteId")
    List<ResultadoExamen> findByExpedienteId(Long expedienteId);
}
