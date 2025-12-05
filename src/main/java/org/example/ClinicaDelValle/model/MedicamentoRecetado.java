package org.example.ClinicaDelValle.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class MedicamentoRecetado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String dosis;
    private String frecuencia;
    private Integer duracion;

    @ManyToOne
    @JoinColumn(name="receta_id")
    private Receta receta;
}
