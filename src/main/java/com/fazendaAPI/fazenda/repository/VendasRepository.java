package com.fazendaAPI.fazenda.repository;

import com.fazendaAPI.fazenda.model.Vendas;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface VendasRepository extends JpaRepository<Vendas, Long> {

    // Total de vendas em um período específico
    @Query("SELECT COUNT(s) FROM Vendas s WHERE s.invoiceDate BETWEEN :startDate AND :endDate")
    long countSalesByPeriod(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    // Vendas por tipo de fatura
    @Query("SELECT s.invoiceType, COUNT(s) FROM Vendas s GROUP BY s.invoiceType")
    List<Object[]> countSalesByInvoiceType();

    // Total de vendas por fazenda
    @Query("SELECT s.fazenda.id, COUNT(s) FROM Vendas s GROUP BY s.fazenda.id")
    List<Object[]> countSalesByFarm();

    List<Vendas> findByFazendaIdAndInvoiceType(Long fazendaId, String invoiceType);

    List<Vendas> findByFazendaId(Long fazendaId);

    List<Vendas> findByInvoiceType(String invoiceType);
}
