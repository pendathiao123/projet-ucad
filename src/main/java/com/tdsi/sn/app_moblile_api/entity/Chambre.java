package com.tdsi.sn.app_moblile_api.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "chambre")
public class Chambre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idChambre;

    @Column(name = "nom_chambre",nullable = false)
    private String nom;
    @Column(name = "nombre_lit")
    private int nombre_lit;
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "idPavillon")
    private Pavillon pavillon;
    /*
    @OneToMany(
            mappedBy = "chambre",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    List<Lit> lits = new ArrayList<>();

     */
}
