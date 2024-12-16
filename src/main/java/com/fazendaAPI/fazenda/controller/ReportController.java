package com.fazendaAPI.fazenda.controller;

import com.fazendaAPI.fazenda.service.AnimalService;
import com.fazendaAPI.fazenda.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/reports")
public class ReportController {
    @Autowired
    private AnimalService animalService;
    private ClienteService clienteService;

    @GetMapping("/total-by-species/{farmId}")
    public ResponseEntity<Map<String, Long>> getTotalBySpecies(@PathVariable Long farmId) {
        return ResponseEntity.ok(animalService.getTotalAnimalsBySpecies(farmId));
    }
}
