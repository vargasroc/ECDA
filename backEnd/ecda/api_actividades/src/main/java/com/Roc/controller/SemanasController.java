package com.Roc.controller;

import com.Roc.model.Semana;
import com.Roc.service.SemanaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/semanas")
public class SemanasController {

    private final SemanaService semanaService; // Inyecta tu servicio de semanas aquí

    public SemanasController(SemanaService semanaService) {
        this.semanaService = semanaService;
    }

    @GetMapping
    public ResponseEntity<List<Semana>> obtenerTodasLasSemanas() {
        List<Semana> semanas = semanaService.obtenerTodasLasSemanas();

        if (semanas.isEmpty()) {
            return ResponseEntity.noContent().build(); // Devolver una respuesta sin contenido si no hay semanas
        } else {
            return ResponseEntity.ok(semanas); // Devolver las semanas en la respuesta 200 OK
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Semana> obtenerSemanaPorId(@PathVariable Long id) {
        Semana semana = semanaService.obtenerSemanaPorId(id);

        if (semana != null) {
            return ResponseEntity.ok(semana);
        } else {
            return ResponseEntity.notFound().build(); // Devolver una respuesta 404 Not Found si no se encuentra la semana
        }
    }


}


