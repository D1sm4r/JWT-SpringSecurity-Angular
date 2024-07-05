package com.proyecto.rest.backend.dto;

import com.proyecto.rest.backend.entity.Cargo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CargoDTO {

    private long idCargo;

    private String name;

    private long saldo;

    //------------------------------------------------------------

    public Cargo toEntity(){
        Cargo e = new Cargo(idCargo, name, saldo);
        e.setIdCargo(this.getIdCargo());
        e.setSaldo(this.getSaldo());
        e.setName(this.getName());
        return e;
    }

}
