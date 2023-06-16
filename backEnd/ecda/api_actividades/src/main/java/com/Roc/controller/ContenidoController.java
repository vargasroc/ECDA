package com.Roc.controller;

import com.Roc.model.Actividad;
import com.Roc.model.Contenido;
import com.Roc.model.Semana;
import com.Roc.service.ActividadService;
import com.Roc.service.ContenidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/contenidos")
public class ContenidoController {

    private ContenidoService contenidoService;  // Inyecta tu servicio de actividades aquí

    public ContenidoController(ActividadService actividadService) {
        this.contenidoService = contenidoService;
    }

    @GetMapping
    public ResponseEntity<List<Contenido>> obtenerActividades() {
        List<Contenido> contenidos = contenidoService.obtenerTodasLosContenidos(); // Obtener todas las actividades desde el servicio

        if (contenidos.isEmpty()) {
            return ResponseEntity.noContent().build(); // Devolver una respuesta sin contenido si no hay actividades
        } else {
            return ResponseEntity.ok(contenidos); // Devolver las actividades en la respuesta 200 OK
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contenido> obtenerContenidoPorId(@PathVariable Long id) {
        Contenido contenido = contenidoService.obtenerContenidoPorId(id);

        if (contenido != null) {
            return ResponseEntity.ok(contenido);
        } else {
            return ResponseEntity.notFound().build(); // Devolver una respuesta 404 Not Found si no se encuentra el contenido
        }
    }

}