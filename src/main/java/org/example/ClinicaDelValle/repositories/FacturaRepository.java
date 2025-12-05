package org.example.ClinicaDelValle.repositories;

import org.example.ClinicaDelValle.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura,Long> {
}
