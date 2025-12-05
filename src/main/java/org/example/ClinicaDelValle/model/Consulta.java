package org.example.ClinicaDelValle.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Consulta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Date fecha;
    private String motivo;


    @Column(length = 2000)
    private String diagnostico;


    @Column(length = 2000)
    private String notasMedicas;


    @ManyToOne
    @JoinColumn(name="expediente_id")
    private ExpedienteDigital expediente;


    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario medico;


    @OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL)
    private List<Receta> recetas;


    @OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL)
    private List<OrdenExamen> ordenesExamen;
}
