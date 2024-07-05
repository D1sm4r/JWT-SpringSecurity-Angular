package com.proyecto.rest.backend.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.proyecto.rest.backend.dto.ProyectoDTO;
import com.proyecto.rest.backend.service.IProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("proyecto")
public class ProyectoController {

    @Autowired
    private IProyectoService servicio;

    @ResponseBody
    @PostMapping("create")
    public ProyectoDTO agregarProyecto(@Valid @NonNull @RequestBody ProyectoDTO dto) {
        return servicio.save(dto);
    }

    @ResponseBody
    @GetMapping("findall")
    public List<ProyectoDTO> findAll() {
        return servicio.findAll();
    }

    @ResponseBody
    @GetMapping("findById/{id}")
    public ProyectoDTO findById(@PathVariable("id") int id) {
        Optional<ProyectoDTO> pDto = servicio.findById(id);
        if (pDto.isPresent()) {
            ProyectoDTO dto = pDto.get();
            return dto;
        } else {
            return null;
        }
    }

    @ResponseBody
    @PutMapping("update")
    public ProyectoDTO updateProyecto(@Valid @NonNull @RequestBody ProyectoDTO dto) {
        Optional<ProyectoDTO> oDto = servicio.findById(dto.getIdProyecto());
        if (oDto.isPresent() == true) {
            return servicio.save(dto);
        }else{
            return null;
        }
    }

    @ResponseBody
    @DeleteMapping("delete/{id}")
    public boolean deleteProyectoById(@PathVariable("id") int id) {
        Optional<ProyectoDTO> pDto = servicio.findById(id);
        if (pDto.isPresent() == true) {
            servicio.delete(pDto.get());
            return true;
        } else {
            return false;
        }
    }
}
