package com.proyecto.rest.backend.service;


import com.proyecto.rest.backend.dto.HorasExtrasDTO;
import com.proyecto.rest.backend.entity.HorasExtras;
import com.proyecto.rest.backend.entity.Proyecto;
import com.proyecto.rest.backend.entity.UserEntity;
import com.proyecto.rest.backend.repository.HorasExtrasRepository;
import com.proyecto.rest.backend.repository.ProyectoRepository;
import com.proyecto.rest.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Service
public class HorasExtrasServiceImpl implements IHorasExtrasService {

    @Autowired
    private HorasExtrasRepository beta;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProyectoRepository proyectoRepository;

    @Override
    public HorasExtrasDTO solicitarHorasExtras(HorasExtrasDTO horasExtrasDTO) {
        UserEntity user = userRepository.findById(horasExtrasDTO.getUser().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Trabajador no encontrado"));

        Proyecto proyecto = proyectoRepository.findById(horasExtrasDTO.getProyecto().getIdProyecto())
                .orElseThrow(() -> new ResourceNotFoundException("Proyecto no encontrado"));

        HorasExtras horasExtras = new HorasExtras();
        horasExtras.setCantidad(horasExtrasDTO.getCantidad());
        horasExtras.setFecha(horasExtrasDTO.getFecha());
        horasExtras.setJustificacion(horasExtrasDTO.getJustificacion());
        horasExtras.setEstado("PENDIENTE");
        horasExtras.setUser(user);
        horasExtras.setProyecto(proyecto);

        beta.save(horasExtras);

        return horasExtras.toDTO();
    }


    @Override
    public List<HorasExtrasDTO> findAll() {
        List<HorasExtras> listE = (List<HorasExtras>) beta.findAll();
        List<HorasExtrasDTO> listDTO = new ArrayList<HorasExtrasDTO>();
        for (HorasExtras e : listE) {
            HorasExtrasDTO HorasExtrasDTO = e.toDTO();

            Proyecto Proyecto = e.getProyecto();
            if (Proyecto != null) {
                HorasExtrasDTO.setProyecto(Proyecto.toDTO());
            }

            UserEntity UserEntity = e.getUser();
            if (UserEntity != null) {
                HorasExtrasDTO.setUser(UserEntity.toDTO());
            }

            listDTO.add(HorasExtrasDTO);
        }
        return listDTO;
    }

    @Override
    public Optional<HorasExtrasDTO> findById(long id) {
        Optional<HorasExtras> oe = beta.findById(id);
        HorasExtras e = oe.get();
        HorasExtrasDTO dto = e.toDTO();
        return Optional.ofNullable(dto);
    }

    @Override
    public HorasExtrasDTO save(HorasExtrasDTO horasExtras) {
        HorasExtras e = beta.save(horasExtras.toEntity());
        return e.toDTO();
    }

    @Override
    public void delete(HorasExtrasDTO B) {
        beta.delete(B.toEntity());
    }

}
