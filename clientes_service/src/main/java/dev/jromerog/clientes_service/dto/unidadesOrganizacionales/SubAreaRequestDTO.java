package dev.jromerog.clientes_service.dto.unidadesOrganizacionales;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SubAreaRequestDTO(

        @NotNull
        Integer idUnidadPadre,

        @NotBlank
        String nombreArea

) {
}
