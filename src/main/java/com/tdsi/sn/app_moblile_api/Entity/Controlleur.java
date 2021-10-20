package com.tdsi.sn.app_moblile_api.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "controlleur")
public class Controlleur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcontrole;

    private String prenom;
    private String nom;
    private String numero;
    private String password;
    private int compteur;
}
