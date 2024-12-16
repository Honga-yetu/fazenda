package com.fazendaAPI.fazenda.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Entity
public class Abates {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "animal_id", nullable = false)
    private Animal animal;

    @Column(name = "slaughter_date")
    private LocalDate slaughterDate;

    @Column(name = "slaughter_weight", precision = 8, scale = 2)
    private BigDecimal slaughterWeight;

    @Column(name = "meat_yield", precision = 5, scale = 2)
    private BigDecimal meatYield;

    @Size(max = 255)
    @Column(name = "carcass_grade")
    private String carcassGrade;

    @Size(max = 255)
    @Column(name = "destination")
    private String destination;

    @Column(name = "sale_price", precision = 10, scale = 2)
    private BigDecimal salePrice;

    @Lob
    @Column(name = "observations")
    private String observations;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getCarcassGrade() {
        return carcassGrade;
    }

    public void setCarcassGrade(String carcassGrade) {
        this.carcassGrade = carcassGrade;
    }

    public BigDecimal getMeatYield() {
        return meatYield;
    }

    public void setMeatYield(BigDecimal meatYield) {
        this.meatYield = meatYield;
    }

    public BigDecimal getSlaughterWeight() {
        return slaughterWeight;
    }

    public void setSlaughterWeight(BigDecimal slaughterWeight) {
        this.slaughterWeight = slaughterWeight;
    }

    public LocalDate getSlaughterDate() {
        return slaughterDate;
    }

    public void setSlaughterDate(LocalDate slaughterDate) {
        this.slaughterDate = slaughterDate;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
