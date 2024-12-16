package com.fazendaAPI.fazenda.service;

import com.fazendaAPI.fazenda.model.Fazenda;
import com.fazendaAPI.fazenda.repository.FazendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FazendaService {

    @Autowired
    private FazendaRepository fazendaRepository;

    public List<Fazenda> listarFazendas() {
        return fazendaRepository.findAll(); // Certifique-se de que esse método está funcionando
    }

    public Fazenda buscarFazendaPorId(Long id) {
        try {
            return fazendaRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Fazenda não encontrada para o ID: " + id));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar fazenda: " + e.getMessage());
        }
    }

    public Fazenda salvarFazenda(Fazenda fazenda) {
        return fazendaRepository.save(fazenda);
    }

    public boolean deletarFazenda(Long id) {
        fazendaRepository.deleteById(id);
        return false;
    }
}
