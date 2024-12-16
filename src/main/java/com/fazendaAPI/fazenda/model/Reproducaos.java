package com.fazendaAPI.fazenda.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;
import java.time.LocalDate;

@Entity
public class Reproducaos {
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
    @Column(name = "reproductive_status")
    private String reproductiveStatus;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "total_births", nullable = false)
    private Integer totalBirths;

    @Column(name = "last_insemination_date")
    private LocalDate lastInseminationDate;

    @Column(name = "pregnancy_diagnosis_date")
    private LocalDate pregnancyDiagnosisDate;

    @Column(name = "expected_birth_date")
    private LocalDate expectedBirthDate;

    @Column(name = "offspring_per_birth")
    private Integer offspringPerBirth;

    @Column(name = "fertility_index")
    private Integer fertilityIndex;

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

    public Integer getFertilityIndex() {
        return fertilityIndex;
    }

    public void setFertilityIndex(Integer fertilityIndex) {
        this.fertilityIndex = fertilityIndex;
    }

    public Integer getOffspringPerBirth() {
        return offspringPerBirth;
    }

    public void setOffspringPerBirth(Integer offspringPerBirth) {
        this.offspringPerBirth = offspringPerBirth;
    }

    public LocalDate getExpectedBirthDate() {
        return expectedBirthDate;
    }

    public void setExpectedBirthDate(LocalDate expectedBirthDate) {
        this.expectedBirthDate = expectedBirthDate;
    }

    public LocalDate getPregnancyDiagnosisDate() {
        return pregnancyDiagnosisDate;
    }

    public void setPregnancyDiagnosisDate(LocalDate pregnancyDiagnosisDate) {
        this.pregnancyDiagnosisDate = pregnancyDiagnosisDate;
    }

    public LocalDate getLastInseminationDate() {
        return lastInseminationDate;
    }

    public void setLastInseminationDate(LocalDate lastInseminationDate) {
        this.lastInseminationDate = lastInseminationDate;
    }

    public Integer getTotalBirths() {
        return totalBirths;
    }

    public void setTotalBirths(Integer totalBirths) {
        this.totalBirths = totalBirths;
    }

    public String getReproductiveStatus() {
        return reproductiveStatus;
    }

    public void setReproductiveStatus(String reproductiveStatus) {
        this.reproductiveStatus = reproductiveStatus;
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
