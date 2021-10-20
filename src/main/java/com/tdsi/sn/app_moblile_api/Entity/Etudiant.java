package com.tdsi.sn.app_moblile_api.Entity;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data
@Table(name = "etudiant")
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idetudiant;

    private String prenom;
    private String nom;
    private int solde;
    private int numero;
    private String carte;
    private String password;


}
