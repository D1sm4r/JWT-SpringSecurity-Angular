package com.proyecto.rest.backend.entity;

import com.proyecto.rest.backend.dto.ProyectoDTO;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Proyecto")
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idProyecto;
    @Column(name = "nombre")
    private String name;

    //------------------------------------------------------------

    public ProyectoDTO toDTO() {
        ProyectoDTO dto = new ProyectoDTO();
        dto.setIdProyecto(this.getIdProyecto());
        dto.setName(this.getName());
        return dto;
    }

}
