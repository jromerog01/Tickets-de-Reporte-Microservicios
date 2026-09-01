package dev.jromerog.clientes_service.entities;

import dev.jromerog.clientes_service.entities.enums.Rol;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "empleados")
@Data
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Integer idEmpleado;

    @ManyToOne
    @JoinColumn(name = "id_unidad", nullable = false)
    @NotNull
    private UnidadOrganizacional unidad;

    @ManyToOne
    @JoinColumn(name = "id_jefe", nullable = true)
    private Empleado jefe;

    @NotBlank
    private String nombre;

    @NotBlank
    private String apellido;

    @NotBlank
    @Column(unique = true)
    private String username;

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Rol rol;

    @NotNull
    private boolean disponibilidad;

    private boolean activo;






}
