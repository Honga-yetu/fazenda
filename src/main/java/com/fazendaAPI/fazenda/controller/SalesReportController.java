package com.fazendaAPI.fazenda.controller;

import com.fazendaAPI.fazenda.repository.VendasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/sales/reports")
public class SalesReportController {

    @Autowired
    private VendasRepository saleRepository;

    // Relatório: Total de vendas por período
    @GetMapping("/total-by-period")
    public ResponseEntity<Long> getTotalSalesByPeriod(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        long totalSales = saleRepository.countSalesByPeriod(startDate, endDate);
        return ResponseEntity.ok(totalSales);
    }

    // Relatório: Vendas por tipo de fatura
    @GetMapping("/by-invoice-type")
    public ResponseEntity<List<Object[]>> getSalesByInvoiceType() {
        List<Object[]> salesByType = saleRepository.countSalesByInvoiceType();
        return ResponseEntity.ok(salesByType);
    }

    // Relatório: Total de vendas por fazenda
    @GetMapping("/by-farm")
    public ResponseEntity<List<Object[]>> getSalesByFarm() {
        List<Object[]> salesByFarm = saleRepository.countSalesByFarm();
        return ResponseEntity.ok(salesByFarm);
    }
}
