package dev.jromerog.clientes_service.services.interfaces;

import dev.jromerog.clientes_service.dto.unidadesOrganizacionales.AreaRequestDTO;
import dev.jromerog.clientes_service.dto.unidadesOrganizacionales.AreaResponseDTO;
import dev.jromerog.clientes_service.dto.unidadesOrganizacionales.UnidadOrganizacionalResponseDTO;
import dev.jromerog.clientes_service.entities.UnidadOrganizacional;

import java.util.List;

public interface UnidadOrganizacionalService {
    List<UnidadOrganizacional> findAll();
    UnidadOrganizacionalResponseDTO findById(int id);
    AreaResponseDTO saveArea (AreaRequestDTO area);

}
