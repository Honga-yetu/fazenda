package com.fazendaAPI.fazenda.repository;

import com.fazendaAPI.fazenda.model.Fazenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FazendaRepository extends JpaRepository<Fazenda, Long> {
}

