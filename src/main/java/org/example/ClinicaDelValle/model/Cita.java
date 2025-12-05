package org.example.ClinicaDelValle.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.Tab;
import org.openxava.annotations.View;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@View(members = "fecha, hora, estado; paciente; medico")
@Tab(properties = "fecha, hora, estado, paciente.nombre, medico.username")
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fecha;
    private String hora;

    @Enumerated(EnumType.STRING)
    private EstadoCita estado;

    public enum EstadoCita { PENDIENTE, COMPLETADA, CANCELADA }

    @ManyToOne
    @JoinColumn(name="paciente_id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario medico;
}
