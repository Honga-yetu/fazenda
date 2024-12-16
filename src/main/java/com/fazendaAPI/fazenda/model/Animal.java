package com.fazendaAPI.fazenda.model;


import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "animals")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O nome do animal é obrigatório")
    @Column(nullable = false, length = 255)
    private String name;

    @NotNull(message = "A espécie é obrigatória")
    @Column(nullable = false, length = 255)
    private String species;

    @Column(nullable = false, length = 255)
    private String breed;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "identification_number", nullable = false, unique = true, length = 255)
    private String identificationNumber;

    @Column(nullable = false, length = 255)
    private String color;

    @Column(name = "current_pasture", nullable = false, length = 255)
    private String currentPasture;

    @ManyToOne
    @JoinColumn(name = "fazenda_id", nullable = false)
    private Fazenda fazenda;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

    public enum Gender {
        Macho, Femea
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCurrentPasture() {
        return currentPasture;
    }

    public void setCurrentPasture(String currentPasture) {
        this.currentPasture = currentPasture;
    }

    public Fazenda getFazenda() {
        return fazenda;
    }

    public void setFazenda(Fazenda fazenda) {
        this.fazenda = fazenda;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @JsonProperty("idade")
    public int getIdade(){
        return Period.between(this.birthDate, LocalDate.now()).getYears();
    }

    @JsonProperty("pertenceAFazenda")
    public boolean pertenceAFazenda(Long fazendaId) {
        return this.fazenda != null && this.fazenda.getId().equals(fazendaId);
    }

    @JsonProperty("diasDeVida")
    public long getDiasDeVida() {
        return java.time.temporal.ChronoUnit.DAYS.between(this.birthDate, LocalDate.now());
    }

    public boolean mesmaEspecie(Animal outroAnimal) {
        return this.species.equalsIgnoreCase(outroAnimal.getSpecies());
    }

}
