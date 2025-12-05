package org.example.ClinicaDelValle.repositories;

import org.example.ClinicaDelValle.model.Receta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecetaRepository extends JpaRepository<Receta,Long> {
}
