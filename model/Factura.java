package org.example.ClinicaDelValle.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
public class Factura {
    @Id
    @GeneratedValue
    private Long id;

    private Date fecha;

    private Float total;

    private String estadoPago;

    private Long idPaciente;

}
