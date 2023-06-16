package com.Roc.service;

import com.Roc.model.Actividad;
import com.Roc.model.Contenido;
import com.Roc.repository.ActividadRepository;
import com.Roc.repository.ContenidoRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class ContenidoService {

    private final ContenidoRepository contenidoRepository;

    public ContenidoService(ContenidoRepository contenidoRepository) {
        this.contenidoRepository = contenidoRepository;
    }

    public List<Contenido> obtenerTodasLosContenidos() {
        return contenidoRepository.findAll();
    }

    public Contenido obtenerContenidoPorId(Long id) {
        return contenidoRepository.findById(id).orElse(null);
    }

    public void guardarContenido(@NotNull @Valid Contenido contenido) {
        contenidoRepository.save(contenido);
    }

    public void actualizarContenido(@NotNull @Valid Contenido contenido) {
        contenidoRepository.save(contenido);
    }

    public void eliminarContenido(Long id) {
        contenidoRepository.deleteById(id);
    }


}

