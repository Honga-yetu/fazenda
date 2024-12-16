package com.fazendaAPI.fazenda.controller;

import com.fazendaAPI.fazenda.model.Vendas;
import com.fazendaAPI.fazenda.repository.VendasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vendas")
public class SalesController {

    @Autowired
    private VendasRepository saleRepository;

    // Listar todas as vendas
    @GetMapping
    public List<Vendas> getAllSales() {
        return saleRepository.findAll();
    }

    @GetMapping("/filtered")
    public List<Vendas> getFilteredSales(
            @RequestParam(required = false) Long fazendaId,
            @RequestParam(required = false) String invoiceType) {
        if (fazendaId != null && invoiceType != null) {
            return saleRepository.findByFazendaIdAndInvoiceType(fazendaId, invoiceType);
        } else if (fazendaId != null) {
            return saleRepository.findByFazendaId(fazendaId);
        } else if (invoiceType != null) {
            return saleRepository.findByInvoiceType(invoiceType);
        } else {
            return saleRepository.findAll();
        }
    }

    // Buscar uma venda pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Vendas> getSaleById(@PathVariable Long id) {
        Optional<Vendas> sale = saleRepository.findById(id);
        return sale.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Criar uma nova venda
    @PostMapping
    public Vendas createSale(@RequestBody Vendas sale) {
        return saleRepository.save(sale);
    }

    // Atualizar uma venda existente
    @PutMapping("/{id}")
    public ResponseEntity<Vendas> updateSale(@PathVariable Long id, @RequestBody Vendas saleDetails) {
        return saleRepository.findById(id)
                .map(existingSale -> {
                    existingSale.setInvoiceNo(saleDetails.getInvoiceNo());
                    existingSale.setHash(saleDetails.getHash());
                    existingSale.setHashControl(saleDetails.getHashControl());
                    existingSale.setPeriod(saleDetails.getPeriod());
                    existingSale.setInvoiceDate(saleDetails.getInvoiceDate());
                    existingSale.setInvoiceDateEnd(saleDetails.getInvoiceDateEnd());
                    existingSale.setInvoiceType(saleDetails.getInvoiceType());
                    Vendas updatedSale = saleRepository.save(existingSale);
                    return ResponseEntity.ok(updatedSale);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Deletar uma venda pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSale(@PathVariable Long id) {
        return saleRepository.findById(id)
                .map(sale -> {
                    saleRepository.delete(sale);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

