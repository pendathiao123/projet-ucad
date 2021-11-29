package com.tdsi.sn.app_moblile_api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bilan {
    private int idBilan;
    private String nom_resto;
    private String carte_etudiant;
    private LocalTime localTime;
    private String type_repas;
    private String code_controlleur;
    private int nombre_ticket = 0;
    private boolean annuleScan;
}
