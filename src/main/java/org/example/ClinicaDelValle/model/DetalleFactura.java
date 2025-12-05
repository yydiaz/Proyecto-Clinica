package org.example.ClinicaDelValle.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class DetalleFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private Integer cantidad;
    private Double precioUnitario;
    private Double subtotal;


    @ManyToOne
    @JoinColumn(name="factura_id")
    private Factura factura;
}
