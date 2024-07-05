package com.proyecto.rest.backend.entity;

import com.proyecto.rest.backend.dto.UserDTO;
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
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique = true)
    private String username;
    private String password;

    //-----------------------------------------------------------

    @Column(name = "is_enabled")
    private boolean isEnabled;
    @Column(name = "account_non_expired")
    private boolean accountNonExpired;
    @Column(name = "account_non_locked")
    private boolean accountNonLocked;
    @Column(name = "credentials_non_expired")
    private boolean credentialsNonExpired;

    //-----------------------------------------------------------

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roles = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "idCargo")
    private Cargo cargo;

    public UserDTO toDTO(){
        UserDTO dto = new UserDTO();
        dto.setId(this.getId());
        dto.setUsername(this.getUsername());
        dto.setPassword(this.getPassword());
        dto.setEnabled(this.isEnabled);
        dto.setAccountNonExpired(this.accountNonExpired);
        dto.setAccountNonLocked(this.accountNonLocked);
        dto.setCredentialsNonExpired(this.credentialsNonExpired);

        if(this.roles !=null){
            dto.setRoles(this.roles.stream()
                    .map(RoleEntity::toDTO)
                    .collect(Collectors.toSet()));
        }

        if(this.cargo != null){
            dto.setCargo(this.cargo.toDTO());
        }

        return dto;
    }

}
