package com.proyecto.rest.backend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.proyecto.rest.backend.dto.HorasExtrasDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "HorasExtras")
public class HorasExtras {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idHorasExtras;
    @Column
    private int cantidad;
    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date fecha;
    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date fecha_de_autorizacion;
    @Column
    private String justificacion;
    @Column
    private String estado;

    //------------------------------------------------------------

    @ManyToOne
    @JoinColumn(name = "idProyecto")
    private Proyecto proyecto;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private UserEntity user;


    //------------------------------------------------------------

    public HorasExtras(@JsonProperty("idHorasExtras")long idHorasExtras, @JsonProperty("cantidad")int cantidad,
                       @JsonProperty("fecha")Date fecha, @JsonProperty("fecha_de_autorizacion")Date fecha_de_autorizacion,
                       @JsonProperty("justificacion") String justificacion, @JsonProperty("estado")String estado){
        super();
        this.idHorasExtras = idHorasExtras;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.fecha_de_autorizacion = fecha_de_autorizacion;
        this.justificacion = justificacion;
        this.estado = estado;
    }

    public HorasExtrasDTO toDTO(){
        HorasExtrasDTO dto = new HorasExtrasDTO();
        dto.setIdHorasExtras(this.getIdHorasExtras());
        dto.setCantidad(this.getCantidad());
        dto.setFecha(this.getFecha());
        dto.setFecha_de_autorizacion(this.getFecha_de_autorizacion());
        dto.setJustificacion(this.getJustificacion());
        dto.setEstado(this.estado);

        if(this.proyecto != null){
            dto.setProyecto(this.proyecto.toDTO());
        }

        if(this.user != null){
            dto.setUser(this.user.toDTO());
        }

        return dto;
    }
}
