package com.proyecto.rest.backend.entity;

import com.proyecto.rest.backend.dto.PermissionDTO;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "permissions")
public class PermissionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true ,nullable = false, updatable = false) // para no actualizar los permisos
    private String name;

    public PermissionDTO toDTO(){
        PermissionDTO dto = new PermissionDTO();
        dto.setId(this.getId());
        dto.setName(this.getName());
        return dto;
    }
}
