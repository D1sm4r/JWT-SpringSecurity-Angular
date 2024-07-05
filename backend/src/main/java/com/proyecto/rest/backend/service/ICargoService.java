package com.proyecto.rest.backend.service;


import com.proyecto.rest.backend.dto.CargoDTO;

import java.util.List;
import java.util.Optional;

public interface ICargoService {

    public List<CargoDTO> findAll();

    public Optional<CargoDTO> findById(long id);

    public CargoDTO save(CargoDTO cargo);

    public void delete(CargoDTO dto);
}
