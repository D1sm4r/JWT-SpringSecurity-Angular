package com.proyecto.rest.backend.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.proyecto.rest.backend.dto.HorasExtrasDTO;
import com.proyecto.rest.backend.service.IHorasExtrasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("horasextras")
public class HorasExtrasController {

    @Autowired
    private IHorasExtrasService servicio;


    @PostMapping("solicitar")
    public ResponseEntity<HorasExtrasDTO> solicitarHorasExtras(@RequestBody HorasExtrasDTO horasExtrasDTO) {
        HorasExtrasDTO result = servicio.solicitarHorasExtras(horasExtrasDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @ResponseBody
    @PostMapping("create")
    public HorasExtrasDTO agregarHE(@Valid @NonNull @RequestBody HorasExtrasDTO dto) {

        return servicio.save(dto);
    }

    @ResponseBody
    @GetMapping("findall")
    public List<HorasExtrasDTO> findAll() {

        return servicio.findAll();
    }

    @ResponseBody
    @GetMapping("findById/{id}")
    public HorasExtrasDTO findById(@PathVariable("id") int id) {
        Optional<HorasExtrasDTO> heDto = servicio.findById(id);
        if (heDto.isPresent()) {
            HorasExtrasDTO dto = heDto.get();
            return dto;
        } else {
            return null;
        }
    }

    @ResponseBody
    @PutMapping("update")
    public HorasExtrasDTO updateHorasExtras(@Valid @NonNull @RequestBody HorasExtrasDTO dto) {
        Optional<HorasExtrasDTO> oDto = servicio.findById(dto.getIdHorasExtras());
        if (oDto.isPresent() == true) {
            return servicio.save(dto);
        }else{
            return null;
        }
    }

    @ResponseBody
    @DeleteMapping("delete/{id}")
    public boolean deleteHEById(@PathVariable("id") int id) {
        Optional<HorasExtrasDTO> oDto = servicio.findById(id);
        if (oDto.isPresent() == true) {
            servicio.delete(oDto.get());
            return true;
        } else {
            return false;
        }
    }
}
