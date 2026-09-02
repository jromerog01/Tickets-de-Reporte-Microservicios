package dev.jromerog.clientes_service.dto.unidadesOrganizacionales;

import dev.jromerog.clientes_service.entities.UnidadOrganizacional;
import dev.jromerog.clientes_service.entities.enums.TipoArea;

public record UnidadOrganizacionalResponseDTO(
        Integer idUnidad,
        String areaPadre,
        String area,
        TipoArea tipoArea
) {
}
