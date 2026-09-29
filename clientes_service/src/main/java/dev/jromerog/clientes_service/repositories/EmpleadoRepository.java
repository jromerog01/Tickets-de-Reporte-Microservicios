package dev.jromerog.clientes_service.repositories;

import dev.jromerog.clientes_service.entities.Empleado;
import org.springframework.data.repository.CrudRepository;

public interface EmpleadoRepository extends CrudRepository<Empleado, Integer> {

    
}
