package dev.jromerog.clientes_service.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "historial_contrasenas")
@Data
public class Contrasena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contrasena")
    private Integer idContrasena;

    @JoinColumn(name = "id_empleado")
    @ManyToOne
    @NotNull
    private Empleado empleado;

    @NotBlank
    @Size(min = 8)
    private String contrasena;

    private boolean activa;

    @Column(name = "fecha_creacion")
    @NotNull
    private LocalDateTime fechaCreacion;

    @PrePersist
    public void setFechaCreacion(){
        this.fechaCreacion = LocalDateTime.now();
    }


}
