package dev.jromerog.clientes_service.controllers;

import dev.jromerog.clientes_service.dto.unidadesOrganizacionales.AreaRequestDTO;
import dev.jromerog.clientes_service.dto.unidadesOrganizacionales.AreaResponseDTO;
import dev.jromerog.clientes_service.dto.unidadesOrganizacionales.UnidadOrganizacionalResponseDTO;
import dev.jromerog.clientes_service.entities.UnidadOrganizacional;
import dev.jromerog.clientes_service.services.interfaces.UnidadOrganizacionalService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/unidades")
@AllArgsConstructor
public class UnidadOrganizacionalController {

    private final UnidadOrganizacionalService service;

    @GetMapping
    public List<UnidadOrganizacional> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public UnidadOrganizacionalResponseDTO findById(@PathVariable int id){
        return service.findById(id);
    }

    @PostMapping
    public AreaResponseDTO saveArea(@RequestBody AreaRequestDTO area){
        return service.saveArea(area);
    }
    

}
