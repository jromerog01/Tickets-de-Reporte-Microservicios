package dev.jromerog.clientes_service.dto.unidadesOrganizacionales;

import dev.jromerog.clientes_service.entities.enums.Area;
import jakarta.validation.constraints.NotBlank;

public record AreaRequestDTO(

        @NotBlank
        String nombreArea
) {
}
