package com.proyecto.rest.backend.controller;

import com.proyecto.rest.backend.dto.UserDTO;
import com.proyecto.rest.backend.entity.UserEntity;
import com.proyecto.rest.backend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService servicio;

    @ResponseBody
    @PostMapping("create")
    public UserDTO createUser(@Valid @NonNull @RequestBody UserDTO dto) {
        return servicio.save(dto);
    }

    @ResponseBody
    @GetMapping("findall")
    public List<UserDTO> findAll() {
        return servicio.findAll();
    }

    @ResponseBody
    @GetMapping("findById/{id}")
    public UserDTO findById(@PathVariable("id") int id) {
        Optional<UserDTO> uDto = servicio.findById(id);
        if (uDto.isPresent()) {
            UserDTO dto = uDto.get();
            return dto;
        } else {
            return null;
        }
    }

    @ResponseBody
    @PutMapping("update")
    public UserDTO updateUser(@Valid @NonNull @RequestBody UserEntity dto) {
        Optional<UserDTO> oDto = servicio.findById(dto.getId());
        if (oDto.isPresent() == true) {
            return servicio.save(dto.toDTO());
        }else{
            return null;
        }
    }

    @ResponseBody
    @DeleteMapping("delete/{id}")
    public boolean deleteUserById(@PathVariable("id") int id) {
        Optional<UserDTO> oDto = servicio.findById(id);
        if (oDto.isPresent() == true) {
            servicio.delete(oDto.get());
            return true;
        } else {
            return false;
        }
    }

}
