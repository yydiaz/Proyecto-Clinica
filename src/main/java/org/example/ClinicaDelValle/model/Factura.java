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
@View(members = "fecha, total, estadoPago; paciente")
@Tab(properties = "fecha, total, estadoPago, paciente.nombre")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fecha;
    private Double total;

    private Boolean estadoPago;

    @ManyToOne
    @JoinColumn(name="paciente_id")
    private Paciente paciente;

    @OneToMany(mappedBy="factura", cascade = CascadeType.ALL)
    private List<DetalleFactura> detalles;
}
