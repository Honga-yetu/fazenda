package com.fazendaAPI.fazenda.repository;

import com.fazendaAPI.fazenda.model.Animal;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    @Query("SELECT a.species, COUNT(a) FROM Animal a WHERE a.fazenda.id = :farmId GROUP BY a.species")
    List<Object[]> findTotalAnimalsBySpecies(@Param("farmId") Long farmId);

    @Query("SELECT AVG(DATEDIFF(CURRENT_DATE, a.birthDate)) / 365 FROM Animal a WHERE a.fazenda.id = :farmId")
    Double findAverageAge(@Param("farmId") Long farmId);

    // Filtro por nome e espécie
    Page<Animal> findByNameContainingAndSpeciesContaining(String name, String species, Pageable pageable);

    // Outros filtros podem ser adicionados conforme necessário
    Page<Animal> findByGender(Animal.Gender gender, Pageable pageable);
}
