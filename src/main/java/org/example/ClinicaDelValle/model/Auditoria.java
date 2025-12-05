package org.example.ClinicaDelValle.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Auditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fecha;
    private String accion;
    private String entidadAfectada;
    private Long idRegistroAfectado;

    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;
}
