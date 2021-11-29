package com.tdsi.sn.app_moblile_api.entity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "lit")
public class Lit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLit;

    @Column(name = "nom_lit",nullable = false)
    private String nom;
    /*
    @OneToMany(
            mappedBy = "lit",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    List<Etudiant> etudiants = new ArrayList<>();
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "idChambre")
    private Chambre chambre;

     */

}
