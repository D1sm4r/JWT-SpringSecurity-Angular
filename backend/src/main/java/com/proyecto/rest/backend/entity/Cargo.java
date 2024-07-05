package com.proyecto.rest.backend.entity;


import com.proyecto.rest.backend.dto.CargoDTO;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Cargo")
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idCargo;
    @Column(name = "nombre")
    private String name;
    @Column(name = "saldo")
    private long saldo;

    //------------------------------------------------------------

    public CargoDTO toDTO() {
        CargoDTO dto = new CargoDTO();
        dto.setIdCargo(this.getIdCargo());
        dto.setName(this.getName());
        dto.setSaldo(this.getSaldo());
        return dto;
    }

}
