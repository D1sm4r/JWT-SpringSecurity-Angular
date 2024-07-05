package com.proyecto.rest.backend.service;


import com.proyecto.rest.backend.dto.ProyectoDTO;
import com.proyecto.rest.backend.entity.Proyecto;
import com.proyecto.rest.backend.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Service
public class ProyectoServiceImpl implements IProyectoService {

    @Autowired
    private ProyectoRepository beta;

    @Override
    public List<ProyectoDTO> findAll() {
        List<Proyecto> listE = (List<Proyecto>) beta.findAll();
        List<ProyectoDTO> listDto = new ArrayList<ProyectoDTO>();
        for (Proyecto e : listE) {
            listDto.add(e.toDTO());
        }
        return listDto;
    }

    @Override
    public Optional<ProyectoDTO> findById(long id) {
        Optional<Proyecto> oe = beta.findById(id);
        Proyecto e = oe.get();
        ProyectoDTO dto = e.toDTO();
        return Optional.ofNullable(dto);
    }

    @Override
    public ProyectoDTO save(ProyectoDTO proyecto) {
        Proyecto e = beta.save(proyecto.toEntity());
        return e.toDTO();
    }

    @Override
    public void delete(ProyectoDTO B) {
        beta.delete(B.toEntity());
    }
}
