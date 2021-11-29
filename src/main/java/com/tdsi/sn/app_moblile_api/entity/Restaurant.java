package com.tdsi.sn.app_moblile_api.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idresto;
    @Column(name = "nom_resto",nullable = false)
    private String nom;

    @Column(nullable = false)
    private int code;
    @OneToMany(
            mappedBy = "restaurant",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    List<Controlleur> etudiants = new ArrayList<>();
/*
    @OneToMany(
            mappedBy = "restaurant",
            cascade = CascadeType.ALL,
            orphanRemoval = true
            )
    List<Etudiant> etudiants = new ArrayList<>();

    @ManyToMany(
            mappedBy = "restaurants",
            cascade = CascadeType.ALL
    )
    private List<Controlleur> controlleurs = new ArrayList<>();

 */

}
