package com.fazendaAPI.fazenda.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Entity
public class Comportamentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "animal_id", nullable = false)
    private Animal animal;

    @Size(max = 255)
    @Column(name = "temperament")
    private String temperament;

    @Size(max = 255)
    @Column(name = "herd_behavior")
    private String herdBehavior;

    @Size(max = 255)
    @Column(name = "handling_ease")
    private String handlingEase;

    @Lob
    @Column(name = "performance_history")
    private String performanceHistory;

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

    public String getPerformanceHistory() {
        return performanceHistory;
    }

    public void setPerformanceHistory(String performanceHistory) {
        this.performanceHistory = performanceHistory;
    }

    public String getHandlingEase() {
        return handlingEase;
    }

    public void setHandlingEase(String handlingEase) {
        this.handlingEase = handlingEase;
    }

    public String getHerdBehavior() {
        return herdBehavior;
    }

    public void setHerdBehavior(String herdBehavior) {
        this.herdBehavior = herdBehavior;
    }

    public String getTemperament() {
        return temperament;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
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
