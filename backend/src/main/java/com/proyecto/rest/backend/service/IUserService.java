package com.proyecto.rest.backend.service;

import com.proyecto.rest.backend.dto.UserDTO;

import java.util.List;
import java.util.Optional;


public interface IUserService {

    public List<UserDTO> findAll();

    public Optional<UserDTO> findById(long id);

    public UserDTO save(UserDTO user);

    public void delete(UserDTO dto);
}
