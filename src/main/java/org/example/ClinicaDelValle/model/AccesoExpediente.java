package org.example.ClinicaDelValle.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.Tab;
import org.openxava.annotations.View;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@View(members = "fechaAcceso, tipoAcceso; expediente; usuario")
@Tab(properties = "fechaAcceso, tipoAcceso, expediente.paciente.nombre, usuario.username")
public class AccesoExpediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fechaAcceso;
    private String tipoAcceso; // ej. "LECTURA", "ESCRITURA"
    @ManyToOne
    @JoinColumn(name="expediente_id")
    private ExpedienteDigital expediente;
    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;
}
