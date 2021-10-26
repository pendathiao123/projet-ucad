package com.tdsi.sn.app_moblile_api.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Random;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name = "etudiants")
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id ;
    private String nom ;
    private String prenom ;
    private  int telephone  ;
    private int motPasse ;
    private  int solde ;
    private String numero_carte ;
    private BigInteger pu;
}
