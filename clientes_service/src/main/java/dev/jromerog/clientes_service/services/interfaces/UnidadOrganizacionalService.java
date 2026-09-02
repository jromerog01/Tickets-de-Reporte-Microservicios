package dev.jromerog.clientes_service.services.interfaces;

import dev.jromerog.clientes_service.dto.unidadesOrganizacionales.*;
import dev.jromerog.clientes_service.entities.UnidadOrganizacional;

import java.util.List;

public interface UnidadOrganizacionalService {
    List<UnidadOrganizacionalResponseDTO> findAll();
    UnidadOrganizacionalResponseDTO findByIdResponse(int id);
    AreaResponseDTO saveArea (AreaRequestDTO area);
    SubAreaResponseDTO saveSubArea(SubAreaRequestDTO subarea);
    List<UnidadOrganizacionalResponseDTO> findByTipoArea(String area);


}
