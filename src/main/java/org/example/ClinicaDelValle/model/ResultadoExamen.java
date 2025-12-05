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
@View(members = "fecha, descripcion; orden")
@Tab(properties = "fecha, orden.tipoExamen")
public class ResultadoExamen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fecha;


    @Column(length = 2000)
    private String descripcion;

    @Lob
    private byte[] archivoPDF;

    @OneToOne
    @JoinColumn(name="orden_id")
    private OrdenExamen orden;
}
