package org.example.ClinicaDelValle.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.Tab;
import org.openxava.annotations.View;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@View(members = "fecha, indicacionesGenerales; consulta")
@Tab(properties = "fecha, consulta.paciente.nombre")
public class Receta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Date fecha;


    @Column(length = 2000)
    private String indicacionesGenerales;


    @ManyToOne
    @JoinColumn(name="consulta_id")
    private Consulta consulta;


    @OneToMany(mappedBy="receta", cascade = CascadeType.ALL)
    private List<MedicamentoRecetado> medicamentos;
}
