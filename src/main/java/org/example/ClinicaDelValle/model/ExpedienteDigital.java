package org.example.ClinicaDelValle.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.Tab;
import org.openxava.annotations.View;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@View(members = "fechaCreacion, estado; paciente")
@Tab(properties = "fechaCreacion, estado, paciente.nombre")
public class ExpedienteDigital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fechaCreacion;

    @Enumerated(EnumType.STRING)
    private EstadoExpediente estado;

    public void setFechaCreacion(LocalDate now) {
    }

    public enum EstadoExpediente { ACTIVO, ARCHIVADO }


    @OneToOne
    @JoinColumn(name="paciente_id")
    private Paciente paciente;


    @OneToMany(mappedBy = "expediente", cascade = CascadeType.ALL)
    private List<Consulta> consultas;


    @OneToMany(mappedBy = "expediente", cascade = CascadeType.ALL)
    private List<HistoriaClinica> historial;

    @OneToMany(mappedBy = "expediente", cascade = CascadeType.ALL)
    private List<ArchivoAdjunto> adjuntos;
}
