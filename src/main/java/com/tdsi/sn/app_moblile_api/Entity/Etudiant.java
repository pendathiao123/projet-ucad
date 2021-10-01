package com.tdsi.sn.app_moblile_api.Entity;

import javax.persistence.*;

@Entity
@Table(name = "etudiants")
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id ;
    private  String nom ;
    private String prenom ;
}
