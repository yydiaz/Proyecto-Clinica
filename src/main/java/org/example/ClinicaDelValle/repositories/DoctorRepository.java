package org.example.ClinicaDelValle.repositories;

import org.example.ClinicaDelValle.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Usuario,Long> {
}
