package com.proyecto.rest.backend.service;

import com.proyecto.rest.backend.dto.ProyectoDTO;

import java.util.List;
import java.util.Optional;

public interface IProyectoService {

    public List<ProyectoDTO> findAll();

    public Optional<ProyectoDTO> findById(long id);

    public ProyectoDTO save(ProyectoDTO proyecto);

    public void delete(ProyectoDTO dto);
}
