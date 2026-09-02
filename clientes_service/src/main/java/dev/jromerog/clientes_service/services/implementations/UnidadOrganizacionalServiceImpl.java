package dev.jromerog.clientes_service.services.implementations;

import dev.jromerog.clientes_service.dto.unidadesOrganizacionales.*;
import dev.jromerog.clientes_service.entities.UnidadOrganizacional;
import dev.jromerog.clientes_service.entities.enums.TipoArea;
import dev.jromerog.clientes_service.exceptions.AreaInvalidaException;
import dev.jromerog.clientes_service.exceptions.IdInvalidoException;
import dev.jromerog.clientes_service.repositories.UnidadOrganizacionalRepository;
import dev.jromerog.clientes_service.services.interfaces.UnidadOrganizacionalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UnidadOrganizacionalServiceImpl implements UnidadOrganizacionalService {

    private final UnidadOrganizacionalRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<UnidadOrganizacionalResponseDTO> findAll() {
        List<UnidadOrganizacional> lista = (List<UnidadOrganizacional>) repository.findAll();
        List<UnidadOrganizacionalResponseDTO> response = new ArrayList<>();

        for (UnidadOrganizacional u : lista){
            response.add(new UnidadOrganizacionalResponseDTO(
                    u.getIdUnidad(),
                    u.getUnidadPadre() == null ? null : u.getUnidadPadre().getArea(),
                    u.getArea(),
                    u.getTipoArea()
            ));
        }

        return response;

    }

    @Override
    @Transactional(readOnly = true)
    public UnidadOrganizacionalResponseDTO findByIdResponse(int id) {
        Optional<UnidadOrganizacional> optional = repository.findById(id);

        if(optional.isPresent()){
            UnidadOrganizacional unidad = optional.get();
                return new UnidadOrganizacionalResponseDTO(
                        unidad.getIdUnidad(),
                        optional.get().getUnidadPadre() == null ? null : unidad.getUnidadPadre().getArea(),
                        unidad.getArea(),
                        unidad.getTipoArea());
        }

        throw new IdInvalidoException("No hay ninguna unidad con el id ingresado");
    }

    private UnidadOrganizacional findById(int id) throws IdInvalidoException{
        return repository.findById(id).orElseThrow();
    }

    @Override
    public List<UnidadOrganizacionalResponseDTO> findByTipoArea(String area) {
        String areaNormalizada = area.toLowerCase();

        List<UnidadOrganizacional> filtradas;
        if(areaNormalizada.equals("area")){
            filtradas = repository.findByTipoArea(TipoArea.AREA);
        } else if (areaNormalizada.equals("subarea")) {
            filtradas = repository.findByTipoArea(TipoArea.SUBAREA);
        } else {
            throw new AreaInvalidaException("el tipo de area solicitada no existe");
        }

        List<UnidadOrganizacionalResponseDTO> mapeadas = new ArrayList<>();
        for(UnidadOrganizacional u : filtradas){
            mapeadas.add(new UnidadOrganizacionalResponseDTO(
                    u.getIdUnidad(),
                    u.getUnidadPadre() == null ? null : u.getUnidadPadre().getArea(),
                    u.getArea(),
                    u.getTipoArea()
            ));
        }

        return mapeadas;
    }

    @Override
    @Transactional
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

    @Override
    @Transactional
    public SubAreaResponseDTO saveSubArea(SubAreaRequestDTO subarea) {

        for (UnidadOrganizacionalResponseDTO u : findByTipoArea(TipoArea.SUBAREA.name())){
            if(subarea.idUnidadPadre().equals(u.idUnidad())){
                throw new IdInvalidoException("Una subarea no puede tener de padre a otra subarea," +
                        " necesariamente debe ser una area");
            }
        }
        
        UnidadOrganizacional unidad = repository.save(UnidadOrganizacional.builder()
                .unidadPadre(findById(subarea.idUnidadPadre()))
                .area(subarea.nombreArea())
                .tipoArea(TipoArea.SUBAREA)
                .build()
        );

        return new SubAreaResponseDTO(
                unidad.getIdUnidad(),
                unidad.getUnidadPadre().getArea(),
                unidad.getArea(),
                unidad.getTipoArea()
        );
    }


}
