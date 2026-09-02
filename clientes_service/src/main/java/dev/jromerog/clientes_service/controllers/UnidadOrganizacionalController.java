package dev.jromerog.clientes_service.controllers;

import dev.jromerog.clientes_service.dto.unidadesOrganizacionales.*;
import dev.jromerog.clientes_service.entities.UnidadOrganizacional;
import dev.jromerog.clientes_service.services.interfaces.UnidadOrganizacionalService;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/unidades")
@AllArgsConstructor
public class UnidadOrganizacionalController {

    private final UnidadOrganizacionalService service;

    @GetMapping
    public List<UnidadOrganizacionalResponseDTO> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public UnidadOrganizacionalResponseDTO findById(@PathVariable int id){
        return service.findByIdResponse(id);
    }

    @PostMapping("/area")
    public AreaResponseDTO saveArea(@RequestBody AreaRequestDTO area){
        return service.saveArea(area);
    }

    @PostMapping("/subarea")
    public SubAreaResponseDTO saveSubArea(@RequestBody SubAreaRequestDTO subarea){
        return service.saveSubArea(subarea);
    }

    @GetMapping(params = "tipoArea")
    public List<UnidadOrganizacionalResponseDTO> findByTipoArea(@RequestParam @NotBlank String tipoArea){
        return service.findByTipoArea(tipoArea);
    }


}
