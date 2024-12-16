package com.fazendaAPI.fazenda.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
public class Producaos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "animal_id", nullable = false)
    private Animal animal;

    @Column(name = "milk_production_daily", precision = 8, scale = 2)
    private BigDecimal milkProductionDaily;

    @Column(name = "milk_production_cycle", precision = 8, scale = 2)
    private BigDecimal milkProductionCycle;

    @Column(name = "milk_composition", precision = 8, scale = 2)
    private BigDecimal milkComposition;

    @Column(name = "carcass_weight", precision = 8, scale = 2)
    private BigDecimal carcassWeight;

    @Column(name = "growth_rate", precision = 5, scale = 2)
    private BigDecimal growthRate;

    @Column(name = "fattening_period", precision = 5, scale = 2)
    private BigDecimal fatteningPeriod;

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

    public BigDecimal getFatteningPeriod() {
        return fatteningPeriod;
    }

    public void setFatteningPeriod(BigDecimal fatteningPeriod) {
        this.fatteningPeriod = fatteningPeriod;
    }

    public BigDecimal getGrowthRate() {
        return growthRate;
    }

    public void setGrowthRate(BigDecimal growthRate) {
        this.growthRate = growthRate;
    }

    public BigDecimal getCarcassWeight() {
        return carcassWeight;
    }

    public void setCarcassWeight(BigDecimal carcassWeight) {
        this.carcassWeight = carcassWeight;
    }

    public BigDecimal getMilkComposition() {
        return milkComposition;
    }

    public void setMilkComposition(BigDecimal milkComposition) {
        this.milkComposition = milkComposition;
    }

    public BigDecimal getMilkProductionCycle() {
        return milkProductionCycle;
    }

    public void setMilkProductionCycle(BigDecimal milkProductionCycle) {
        this.milkProductionCycle = milkProductionCycle;
    }

    public BigDecimal getMilkProductionDaily() {
        return milkProductionDaily;
    }

    public void setMilkProductionDaily(BigDecimal milkProductionDaily) {
        this.milkProductionDaily = milkProductionDaily;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
