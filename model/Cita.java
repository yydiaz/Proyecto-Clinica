package org.example.ClinicaDelValle.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.DateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Getter
@Setter
public class Cita {
    @Id
    @GeneratedValue
    private Long id;

    private Date fecha;

    private LocalTime hora;

    private String estado;

    private Long idPaciente;

    private Long idUsuario;

}
