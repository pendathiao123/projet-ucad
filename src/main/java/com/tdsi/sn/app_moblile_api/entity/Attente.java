package com.tdsi.sn.app_moblile_api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int idetudiant;
    private Time date;
    private String nom_resto;
    private boolean scanned;

    public Attente(int idetudiant, Time valueOf,String nom_resto) {
    }
}
