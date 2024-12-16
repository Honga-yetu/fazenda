package com.fazendaAPI.fazenda.controller;

import com.fazendaAPI.fazenda.model.Animal;
import com.fazendaAPI.fazenda.service.AnimalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animais")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    // Listar por Filtros
    public Page<Animal> listarAnimaisComFiltros(
            @RequestParam(defaultValue = "") String name,
            @RequestParam(defaultValue = "") String species,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return animalService.listarAnimaisComFiltros(name, species, pageable);
    }
    // Listar todos os animais
    @GetMapping
    public ResponseEntity<List<Animal>> listarAnimais() {
        List<Animal> animais = animalService.listarAnimais();
        return ResponseEntity.ok(animais);
    }

    // Buscar animal por ID
    @GetMapping("/{id}")
    public ResponseEntity<Animal> buscarAnimalPorId(@PathVariable Long id) {
        Animal animal = animalService.buscarAnimalPorId(id);
        return ResponseEntity.ok(animal);
    }

    // Criar um novo animal
    @PostMapping("/animals")
    public ResponseEntity<Animal> criarAnimal(@Valid @RequestBody Animal animal) {
        Animal novoAnimal = animalService.salvarAnimal(animal);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAnimal);
    }

    // Atualizar um animal existente
    @PutMapping("/{id}")
    public ResponseEntity<Animal> atualizarAnimal(@PathVariable Long id, @RequestBody Animal animalAtualizado) {
        Animal animal = animalService.buscarAnimalPorId(id);
        animal.setName(animalAtualizado.getName());
        animal.setSpecies(animalAtualizado.getSpecies());
        animal.setBirthDate(animalAtualizado.getBirthDate());
        animal.setFazenda(animalAtualizado.getFazenda()); // Assumindo que há uma relação com `Fazenda`

        Animal animalSalvo = animalService.salvarAnimal(animal);
        return ResponseEntity.ok(animalSalvo);
    }

    // Deletar um animal
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAnimal(@PathVariable Long id) {
        animalService.deletarAnimal(id);
        return ResponseEntity.noContent().build();
    }
}

