package com.proyecto.rest.backend.dto;

import com.proyecto.rest.backend.entity.HorasExtras;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HorasExtrasDTO {

    private long idHorasExtras;

    private int cantidad;

    private Date fecha;

    private Date fecha_de_autorizacion;

    private String justificacion;

    private String estado;

    //---------------------------------------------------------------

    private UserDTO user;

    private ProyectoDTO proyecto;


    //---------------------------------------------------------------

    public HorasExtras toEntity(){
        HorasExtras e = new HorasExtras(idHorasExtras, cantidad, fecha, fecha_de_autorizacion
                ,justificacion, estado);
        e.setIdHorasExtras(this.getIdHorasExtras());
        e.setCantidad(this.getCantidad());
        e.setFecha(this.getFecha());
        e.setFecha_de_autorizacion(this.getFecha_de_autorizacion());
        e.setJustificacion(this.getJustificacion());
        e.setEstado(this.estado);

        if (this.proyecto != null) {
            e.setProyecto(this.proyecto.toEntity());
        }

        if(this.user != null){
            e.setUser(this.user.toEntity());
        }

        return e;
    }

}
