package com.proyecto.rest.backend.service;


import com.proyecto.rest.backend.dto.NotificacionDTO;

import java.util.List;
import java.util.Optional;

public interface INotificacionService {

    public List<NotificacionDTO> findAll();

    public Optional<NotificacionDTO> findById(long id);

    public NotificacionDTO save(NotificacionDTO notificacion);

    public void delete(NotificacionDTO dto);

    List<NotificacionDTO> findByUserId(Long userId);
}
