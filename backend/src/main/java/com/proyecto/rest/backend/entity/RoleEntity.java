package com.proyecto.rest.backend.entity;

import com.proyecto.rest.backend.dto.RoleDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;
import java.util.stream.Collectors;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="role_name")
    @Enumerated(EnumType.STRING)
    private RoleEnum roleEnum;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "role_permissions", joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private Set<PermissionEntity> permissionList = new HashSet<>();


    public RoleDTO toDTO() {
        RoleDTO dto = new RoleDTO();
        dto.setId(this.getId());
        dto.setRoleName(this.roleEnum.name());

        if(this.permissionList != null) {
            dto.setPermissionList(this.permissionList.stream()
                    .map(PermissionEntity::toDTO)
                    .collect(Collectors.toSet()));
        }

        return dto;
    }

}
