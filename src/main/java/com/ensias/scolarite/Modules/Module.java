package com.ensias.scolarite.Modules;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // @GeneratedValue tells JPA to adopt a strategy for generating the primary key.
    // The four strategies are: AUTO, IDENTITY, SEQUENCE, and TABLE.
    // For Derby, it's better to use the AUTO strategy.
    private int id;

    private String nom;
    private String description;

    // Constructors
    public Module() {
    }

    public Module(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
