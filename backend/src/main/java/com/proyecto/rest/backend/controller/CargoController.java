package com.proyecto.rest.backend.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.proyecto.rest.backend.dto.CargoDTO;
import com.proyecto.rest.backend.service.ICargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("cargo")
public class CargoController {

    @Autowired
    private ICargoService servicio;

    @ResponseBody
    @PostMapping("create")
    public CargoDTO agregarCargo(@Valid @NonNull @RequestBody CargoDTO dto) {
        return servicio.save(dto);
    }

    @ResponseBody
    @GetMapping("findall")
    public List<CargoDTO> findAll() {
        return servicio.findAll();
    }

    @ResponseBody
    @GetMapping("findById/{id}")
    public CargoDTO findById(@PathVariable("id") int id) {
        Optional<CargoDTO> eDto = servicio.findById(id);
        if (eDto.isPresent()) {
            CargoDTO dto = eDto.get();
            return dto;
        } else {
            return null;
        }
    }

    @ResponseBody
    @PutMapping("update")
    public CargoDTO updateCargo(@Valid @NonNull @RequestBody CargoDTO dto) {
        Optional<CargoDTO> oDto = servicio.findById(dto.getIdCargo());
        if (oDto.isPresent() == true) {
            return servicio.save(dto);
        }else{
            return null;
        }
    }

    @ResponseBody
    @DeleteMapping("delete/{id}")
    public boolean deleteCargoById(@PathVariable("id") int id) {
        Optional<CargoDTO> eDto = servicio.findById(id);
        if (eDto.isPresent() == true) {
            servicio.delete(eDto.get());
            return true;
        } else {
            return false;
        }
    }
}
