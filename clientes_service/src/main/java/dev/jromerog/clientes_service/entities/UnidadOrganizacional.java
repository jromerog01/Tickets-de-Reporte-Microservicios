package dev.jromerog.clientes_service.entities;

import dev.jromerog.clientes_service.entities.enums.Area;
import dev.jromerog.clientes_service.entities.enums.TipoArea;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "unidades_organizacionales")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UnidadOrganizacional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_unidad")
    private Integer idUnidad;

    @ManyToOne
    @JoinColumn(name = "id_unidad_padre", nullable = true)
    private UnidadOrganizacional unidadPadre;

    @NotBlank
    private String area;

    @Column(name = "tipo_area")
    @Enumerated(EnumType.STRING)
    @NotNull
    private TipoArea tipoArea;



}
