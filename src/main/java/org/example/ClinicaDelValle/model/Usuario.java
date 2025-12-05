package org.example.ClinicaDelValle.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Required
    private String username;

    @Required
    private String password;


    @Required
    @Enumerated(EnumType.STRING)
    private Rol rol;


    public enum Rol { ADMIN, MEDICO, ENFERMERA, RECEPCIONISTA }
}
