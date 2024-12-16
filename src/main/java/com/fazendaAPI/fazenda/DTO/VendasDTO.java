package com.fazendaAPI.fazenda.DTO;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class VendasDTO {

    @NotNull
    private Long fazenda_id;

    @NotNull
    private Long cliente_id;

    @NotNull
    private Long animal_id;

    @NotNull
    private LocalDate invoiceDate;

    private String invoiceType;

    public VendasDTO(Long fazendaId) {
        setFazenda_id(fazendaId);
    }

    public Long getFazenda_id() {
        return fazenda_id;
    }

    public void setFazenda_id(Long fazenda_id) {
        this.fazenda_id = fazenda_id;
    }

    public Long getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Long cliente_id) {
        this.cliente_id = cliente_id;
    }

    public Long getAnimal_id() {
        return animal_id;
    }

    public void setAnimal_id(Long animal_id) {
        this.animal_id = animal_id;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }
}
