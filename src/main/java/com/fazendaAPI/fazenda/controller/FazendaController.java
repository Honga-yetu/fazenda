package com.fazendaAPI.fazenda.controller;

import com.fazendaAPI.fazenda.model.Fazenda;
import com.fazendaAPI.fazenda.service.FazendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fazendas")
public class FazendaController {

    @Autowired
    private FazendaService fazendaService;

    //Listar todas as fazendas
    @GetMapping
    public ResponseEntity<List<Fazenda>> listarFazendas() {
        List<Fazenda> fazendas = fazendaService.listarFazendas();
        return ResponseEntity.ok(fazendas);
    }

    // Buscar fazenda por ID
    @GetMapping("/show/{id}")
    public ResponseEntity<?> buscarFazendaPorId(@PathVariable Long id) {
        try {
            Fazenda fazenda = fazendaService.buscarFazendaPorId(id);
            if (fazenda.getNome() == null || fazenda.getLocalizacao() == null) {
                return ResponseEntity.badRequest().body("Dados incompletos para a fazenda com ID: " + id);
            }
            return ResponseEntity.ok(fazenda);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro: " + e.getMessage());
        }
    }

    // Criar uma nova fazenda
    @PostMapping
    public ResponseEntity<Fazenda> criarFazenda(@RequestBody Fazenda fazenda) {
        Fazenda novaFazenda = fazendaService.salvarFazenda(fazenda);
        return ResponseEntity.ok(novaFazenda);
    }

    // Atualizar fazenda existente
    @PutMapping("/{id}")
    public ResponseEntity<Fazenda> atualizarFazenda(@PathVariable Long id, @RequestBody Fazenda fazendaAtualizada) {
        Fazenda fazenda = fazendaService.buscarFazendaPorId(id);
        if (fazenda != null) {
            fazenda.setNome(fazendaAtualizada.getNome());
            fazenda.setLocalizacao(fazendaAtualizada.getLocalizacao());
            fazenda.setLat(fazendaAtualizada.getLat());
            fazenda.setLon(fazendaAtualizada.getLon());
            fazenda.setProvincia(fazendaAtualizada.getProvincia());
            fazenda.setUpdatedAt(fazendaAtualizada.getUpdatedAt());

            Fazenda fazendaSalva = fazendaService.salvarFazenda(fazenda);
            return ResponseEntity.ok(fazendaSalva);
        }
        return ResponseEntity.notFound().build();
    }

    // Deletar uma fazenda
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFazenda(@PathVariable Long id) {
        boolean deletado = fazendaService.deletarFazenda(id);
        if (deletado) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
