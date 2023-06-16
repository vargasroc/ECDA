package com.Roc.controller;

import com.Roc.model.Actividad;
import com.Roc.service.ActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/actividades")
public class ActividadesController {

    private ActividadService actividadService;

    @Autowired
   public ActividadesController(ActividadService actividadService) {
        this.actividadService = actividadService;
    }

    @GetMapping
    public ResponseEntity<List<Actividad>> obtenerActividades() {
        List<Actividad> actividades = actividadService.obtenerTodasLasActividades(); // Obtener todas las actividades desde el servicio

        if (actividades.isEmpty()) {
            return ResponseEntity.noContent().build(); // Devolver una respuesta sin contenido si no hay actividades
        } else {
            return ResponseEntity.ok(actividades); // Devolver las actividades en la respuesta 200 OK
        }
    }

    @GetMapping("/random")
    public ResponseEntity<List<Actividad>> obtenerActividadesRandom() {
        List<Actividad> actividades = actividadService.obtenerActividadesRandom(5); // Llama al servicio para obtener 5 actividades aleatorias
        return ResponseEntity.ok(actividades);
    }


}

