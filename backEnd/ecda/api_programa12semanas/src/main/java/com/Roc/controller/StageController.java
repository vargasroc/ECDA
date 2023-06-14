package com.Roc.controller;

import com.Roc.model.Stage;
import com.Roc.repository.StageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stages")
public class StageController {
    private final StageRepository stageRepository;

    @Autowired
    public StageController(StageRepository stageRepository) {
        this.stageRepository = stageRepository;
    }

    @GetMapping
    public List<Stage> getAllStages() {
        return stageRepository.findAll();
    }

    @PostMapping
    public Stage createStage(@RequestBody Stage stage) {
        return stageRepository.save(stage);
    }

    @GetMapping("/{id}")
    public Stage getStageById(@PathVariable Long id) {
        return stageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stage not found with id: " + id));
    }

    @PutMapping("/{id}")
    public Stage updateStage(@PathVariable Long id, @RequestBody Stage updatedStage) {
        Stage existingStage = stageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stage not found with id: " + id));

        existingStage.setName(updatedStage.getName());
        existingStage.setDescription(updatedStage.getDescription());

        return stageRepository.save(existingStage);
    }

    @DeleteMapping("/{id}")
    public void deleteStage(@PathVariable Long id) {
        stageRepository.deleteById(id);
    }
}
