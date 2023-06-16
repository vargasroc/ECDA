package com.Roc.service;

import com.Roc.model.Semana;
import com.Roc.repository.SemanaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SemanaService {

    private final SemanaRepository semanaRepository;

    public SemanaService(SemanaRepository semanaRepository) {
        this.semanaRepository = semanaRepository;
    }

    public List<Semana> obtenerTodasLasSemanas() {
        return semanaRepository.findAll();
    }

    public Semana obtenerSemanaPorId(Long id) {
        return semanaRepository.findById(id).orElse(null);
    }

    public void guardarSemana(Semana semana) {
        semanaRepository.save(semana);
    }

    public void actualizarSemana(Semana semana) {
        semanaRepository.save(semana);
    }

    public void eliminarSemana(Long id) {
        semanaRepository.deleteById(id);
    }

    // Otros métodos según tus necesidades
}



