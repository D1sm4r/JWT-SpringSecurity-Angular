package com.proyecto.rest.backend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.proyecto.rest.backend.dto.NotificacionDTO;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Notificacion")
public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idNotificacion;
    @Column
    private String mensaje;

    //------------------------------------------------------------

    @ManyToOne
    @JoinColumn(name = "idUser")
    private UserEntity user;

    //------------------------------------------------------------

    public Notificacion(@JsonProperty("idNotificacion")long idNotificacion, @JsonProperty("mensaje")String mensaje){
        super();
        this.idNotificacion = idNotificacion;
        this.mensaje = mensaje;
    }

    public NotificacionDTO toDTO(){

        NotificacionDTO dto = new NotificacionDTO();
        dto.setIdNotificacion(this.getIdNotificacion());
        dto.setMensaje(this.getMensaje());

        if(this.user != null) {
            dto.setUser(this.user.toDTO());
        }

        return dto;
    }

}
