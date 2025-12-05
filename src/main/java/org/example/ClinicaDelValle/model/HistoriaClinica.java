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
@View(members = "tipo, descripcion, fecha; expediente")
@Tab(properties = "tipo, fecha, expediente.paciente.nombre")
public class HistoriaClinica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String tipo; // Diagnóstico, Tratamiento previo, etc.


    @Column(length = 2000)
    private String descripcion;


    private Date fecha;


    @ManyToOne
    @JoinColumn(name="expediente_id")
    private ExpedienteDigital expediente;

}
