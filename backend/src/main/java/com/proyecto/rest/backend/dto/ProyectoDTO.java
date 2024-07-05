package com.proyecto.rest.backend.dto;

import com.proyecto.rest.backend.entity.Proyecto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProyectoDTO {

    private long idProyecto;

    private String name;

    //------------------------------------------------------------

    public Proyecto toEntity(){

        Proyecto e = new Proyecto(idProyecto, name);
        e.setIdProyecto(this.getIdProyecto());
        e.setName(this.getName());
        return e;
    }
}
