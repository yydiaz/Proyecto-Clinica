package org.example.ClinicaDelValle.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.openxava.annotations.Tab;
import org.openxava.annotations.View;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@View(members = "nombre, apellido; fechaNacimiento, direccion, telefono, correo")
@Tab(properties = "nombre, apellido, fechaNacimiento, telefono")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Required
    private String nombre;


    @Required
    private String apellido;


    private Date fechaNacimiento;
    private String direccion;
    private String telefono;
    private String correo;


    @OneToOne(mappedBy = "paciente", cascade = CascadeType.ALL)
    private ExpedienteDigital expediente;

}
