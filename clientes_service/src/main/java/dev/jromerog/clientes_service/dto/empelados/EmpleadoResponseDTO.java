package dev.jromerog.clientes_service.dto.empelados;

import dev.jromerog.clientes_service.entities.UnidadOrganizacional;
import dev.jromerog.clientes_service.entities.enums.Rol;

public record EmpleadoResponseDTO (
    String nombreArea,
    String nombre,
    String apellido,
    String nombreJefe,
    Rol rol,
    boolean disponibilidad
){

}
