package com.fazendaAPI.fazenda.service;

import com.fazendaAPI.fazenda.model.Animal;
import com.fazendaAPI.fazenda.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public List<Animal> listarAnimais() {
        return animalRepository.findAll();
    }

    public Animal buscarAnimalPorId(Long id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal não encontrado para o ID: " + id));
    }

    public Animal salvarAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    public void deletarAnimal(Long id) {
        animalRepository.deleteById(id);
    }

    public Page<Animal> listarAnimaisComFiltros(String name, String species, Pageable pageable) {
        return animalRepository.findByNameContainingAndSpeciesContaining(name, species, pageable);
    }

    public Map<String, Long> getTotalAnimalsBySpecies(Long farmId) {
        List<Object[]> results = animalRepository.findTotalAnimalsBySpecies(farmId);
        return results.stream()
                .collect(Collectors.toMap(r -> (String) r[0], r -> (Long) r[1]));
    }
}
