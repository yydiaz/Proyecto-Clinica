package org.example.ClinicaDelValle.repositories;

import org.example.ClinicaDelValle.model.Cita;
import org.example.ClinicaDelValle.model.Sala;
import org.example.ClinicaDelValle.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface CitaRepository extends JpaRepository<Cita,Long> {
    @Query("SELECT c FROM Cita c WHERE c.medico = :medico AND c.fecha BETWEEN :inicio AND :fin")
    List<Cita> findByDoctorAndFechaHoraBetween(Usuario medico, LocalDateTime inicio, LocalDateTime fin);
    @Query("SELECT c FROM Cita c WHERE c.sala = :sala AND c.fecha BETWEEN :inicio AND :fin")
    List<Cita> findBySalaAndFechaHoraBetween(Sala sala, LocalDateTime inicio, LocalDateTime fin);
    @Query("SELECT c FROM Cita c WHERE c.paciente.expediente.id = :expedienteId")
    List<Cita> findByExpedienteId(Long expedienteId);
}
