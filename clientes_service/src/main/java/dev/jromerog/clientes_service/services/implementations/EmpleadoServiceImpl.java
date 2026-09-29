package dev.jromerog.clientes_service.services.implementations;

import com.fasterxml.jackson.annotation.OptBoolean;
import dev.jromerog.clientes_service.dto.empelados.EmpleadoResponseDTO;
import dev.jromerog.clientes_service.entities.Empleado;
import dev.jromerog.clientes_service.exceptions.IdInvalidoException;
import dev.jromerog.clientes_service.repositories.EmpleadoRepository;
import dev.jromerog.clientes_service.services.interfaces.EmpleadoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmpleadoServiceImpl implements EmpleadoService {

    private EmpleadoRepository repository;

    public EmpleadoResponseDTO findById(int id){
        Optional<Empleado> empleado = repository.findById(id);

        if (empleado.isPresent()){
            Empleado e =empleado.get();
            return new EmpleadoResponseDTO(
                    e.getUnidadOrganizacional().getArea(),
                    e.getNombre(),
                    e.getApellido(),
                    e.getJefe().getNombre() + e.getApellido(),
                    e.getRol(),
                    e.isDisponibilidad()

            );
        }
        throw new IdInvalidoException("No hay ningun empleado con el id ingresado");
    }

    public List<EmpleadoResponseDTO> findAll(){
        List<Empleado> empleados = (List<Empleado>) repository.findAll();
        List<EmpleadoResponseDTO> empleadosDTO = new ArrayList<>();

        for (Empleado e : empleados){
            empleadosDTO.add(new EmpleadoResponseDTO(
                    e.getUnidadOrganizacional().getArea(),
                    e.getNombre(),
                    e.getApellido(),
                    e.getJefe().getNombre() + e.getApellido(),
                    e.getRol(),
                    e.isDisponibilidad()

            ));
        }

        return empleadosDTO;
    }



}
