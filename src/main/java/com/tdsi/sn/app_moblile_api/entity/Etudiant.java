package com.tdsi.sn.app_moblile_api.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "etudiant")
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private  int idEtudiant ;
    @Column( nullable = false )
    private String nom ;
    @Column( nullable = false )
    private String prenom ;
    @Column(name = "telephone" , unique = true ,length = 9 ,nullable = false )
    private  int telephone  ;
    @Column(name = "motPasse" , unique = true ,length = 4 ,nullable = false )
    private int motPasse ;
    private  int solde ;
    @Column(name = "numero_carte" , unique = true ,length = 9 , nullable = false )
    private String numero_carte ;
    /*
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "idResto")
    private Restaurant restaurant;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "idLit")
    private Lit lit;

     */

}
