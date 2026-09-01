package dev.jromerog.clientes_service.entities;

import dev.jromerog.clientes_service.entities.enums.Area;
import dev.jromerog.clientes_service.entities.enums.TipoArea;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "unidades_organizacionales")
@Data
public class UnidadOrganizacional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_unidad")
    private Integer idUnidad;

    @ManyToOne
    @JoinColumn(name = "id_unidad_padre", nullable = true)
    private UnidadOrganizacional unidadPadre;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Area area;

    @Column(name = "tipo_area")
    @Enumerated(EnumType.STRING)
    @NotNull
    private TipoArea tipoArea;



}
