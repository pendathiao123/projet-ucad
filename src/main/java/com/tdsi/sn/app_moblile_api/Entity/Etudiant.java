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
    @Column(name = "telephone" , unique = true ,length = 9 ,nullable = false ) 
    private  int telephone  ;
    private int motPasse ;
    private  int solde ;
    @Column(name = "numero_carte" , unique = true ,length = 9 , nullable = false ) 
    private String numero_carte ;
}
