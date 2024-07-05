package com.proyecto.rest.backend.dto;


import com.proyecto.rest.backend.entity.RoleEntity;
import com.proyecto.rest.backend.entity.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {

    private long id;
    private String roleName;
    private Set<PermissionDTO> permissionList = new HashSet<>();

    public RoleEntity toEntity(){
        RoleEntity e = new RoleEntity();
        e.setId(this.getId());
        e.setRoleEnum(RoleEnum.valueOf(this.roleName.toUpperCase()));

        if(this.permissionList != null){
            e.setPermissionList(this.permissionList.stream()
                    .map(PermissionDTO::toEntity)
                    .collect(Collectors.toSet()));
        }

        return e;
    }

}
