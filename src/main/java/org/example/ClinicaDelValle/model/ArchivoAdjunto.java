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
@View(members = "tipo, ruta, descripcion, fechaSubida; expediente")  // Agrega si no lo tienes
@Tab(properties = "tipo, descripcion, fechaSubida, expediente.paciente.nombre")
public class ArchivoAdjunto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;
    private String ruta;
    private String descripcion;
    private Date fechaSubida;


    @ManyToOne
    @JoinColumn(name="expediente_id")
    private ExpedienteDigital expediente;
}
