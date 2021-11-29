package com.tdsi.sn.app_moblile_api.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "pavillon")
public class Pavillon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nom_pavillon",nullable = false)
    private String nom;

    @Column(name = "nombre_chambre")
    private int nombre;
    /*
    @OneToMany(
            mappedBy = "pavillon",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    List<Chambre> chambres = new ArrayList<>();

     */
}
