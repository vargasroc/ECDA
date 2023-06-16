package com.Roc.service;

import com.Roc.model.Actividad;
import com.Roc.repository.ActividadRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class ActividadService {

    private final ActividadRepository actividadRepository;

    public ActividadService(ActividadRepository actividadRepository) {
        this.actividadRepository = actividadRepository;
    }

    public List<Actividad> obtenerTodasLasActividades() {
        return actividadRepository.findAll();
    }

    public Actividad obtenerActividadPorId(Long id) {
        return actividadRepository.findById(id).orElse(null);
    }

    public void guardarActividad(@NotNull @Valid Actividad actividad) {
        actividadRepository.save(actividad);
    }

    public void actualizarActividad(@NotNull @Valid Actividad actividad) {
        actividadRepository.save(actividad);
    }

    public void eliminarActividad(Long id) {
        actividadRepository.deleteById(id);
    }

    public List<Actividad> obtenerActividadesRandom(int cantidad) {

        return null;
    }
}
