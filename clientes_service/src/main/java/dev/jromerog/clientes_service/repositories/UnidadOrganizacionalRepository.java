package dev.jromerog.clientes_service.repositories;

import dev.jromerog.clientes_service.entities.UnidadOrganizacional;
import dev.jromerog.clientes_service.entities.enums.TipoArea;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface  UnidadOrganizacionalRepository extends CrudRepository<UnidadOrganizacional, Integer> {

    List<UnidadOrganizacional> findByTipoArea(TipoArea tipoArea);


}


