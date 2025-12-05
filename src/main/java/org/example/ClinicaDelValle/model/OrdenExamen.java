package org.example.ClinicaDelValle.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.Tab;
import org.openxava.annotations.View;

import javax.persistence.*;
import java.security.cert.Extension;
import java.util.Date;

@Entity
@Getter
@Setter
@View(members = "tipoExamen, indicaciones, fecha; consulta")
@Tab(properties = "tipoExamen, fecha, consulta.paciente.nombre")
public class OrdenExamen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String tipoExamen;


    @Column(length = 2000)
    private String indicaciones;


    private Date fecha;


    @ManyToOne
    @JoinColumn(name="consulta_id")
    private Consulta consulta;

    @OneToOne(mappedBy = "orden", cascade = CascadeType.ALL)
    private ResultadoExamen resultado;

    public Extension getLaboratorio() {
        return null;
    }
}
