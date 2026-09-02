package dev.jromerog.clientes_service.dto.unidadesOrganizacionales;

import dev.jromerog.clientes_service.entities.UnidadOrganizacional;
import dev.jromerog.clientes_service.entities.enums.TipoArea;

public record AreaResponseDTO(
        Integer idUnidad,
        UnidadOrganizacional unidadPadre,
        String area,
        TipoArea tipoArea
) {}
