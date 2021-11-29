package com.tdsi.sn.app_moblile_api.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id ;
    @Column( nullable = false )
    private String nom ;
    @Column( nullable = false )
    private String prenom ;
    @Column(name = "telephone" , unique = true ,length = 9 ,nullable = false )
    private  int telephone  ;
    @Column(name = "motPasse" , unique = true ,length = 4 ,nullable = false )
    private int motPasse ;
    private String roles;
}
