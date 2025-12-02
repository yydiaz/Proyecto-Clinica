package org.example.ClinicaDelValle.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Consulta {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private Date fecha;

    private String motivo;

    private String diagnostico;

    private String notasmedicas;

    private Long idExpediente;

    private Long idUsuario;
}
