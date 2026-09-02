package dev.jromerog.clientes_service.services.implementations;

import dev.jromerog.clientes_service.dto.unidadesOrganizacionales.AreaRequestDTO;
import dev.jromerog.clientes_service.dto.unidadesOrganizacionales.AreaResponseDTO;
import dev.jromerog.clientes_service.dto.unidadesOrganizacionales.UnidadOrganizacionalResponseDTO;
import dev.jromerog.clientes_service.entities.UnidadOrganizacional;
import dev.jromerog.clientes_service.entities.enums.TipoArea;
import dev.jromerog.clientes_service.exceptions.IdInvalidoException;
import dev.jromerog.clientes_service.repositories.UnidadOrganizacionalRepository;
import dev.jromerog.clientes_service.services.interfaces.UnidadOrganizacionalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UnidadOrganizacionalServiceImpl implements UnidadOrganizacionalService {

    private final UnidadOrganizacionalRepository repository;

    @Override
    public List<UnidadOrganizacional> findAll() {
        return (List<UnidadOrganizacional>) repository.findAll();
    }

    @Override
    public UnidadOrganizacionalResponseDTO findById(int id) {
        Optional<UnidadOrganizacional> optional = repository.findById(id);

        if(optional.isPresent()){
            if (optional.get().getUnidadPadre() == null){
                UnidadOrganizacional unidad = optional.get();
                return new UnidadOrganizacionalResponseDTO(
                        unidad.getIdUnidad(),
                        null,
                        unidad.getArea(),
                        unidad.getTipoArea());
            } else {
                // cuando implemente las subareas
            }
        }

        throw new IdInvalidoException("No hay ninguna unidad con el id ingresado");
    }

    @Override
    public AreaResponseDTO saveArea (AreaRequestDTO area) {
        UnidadOrganizacional unidad = repository.save(UnidadOrganizacional.builder()
                .unidadPadre(null)
                .area(area.nombreArea())
                .tipoArea(TipoArea.AREA)
                .build());

        return new AreaResponseDTO(
                unidad.getIdUnidad(),
                unidad.getUnidadPadre(),
                unidad.getArea(),
                unidad.getTipoArea()
        );


    }


}
