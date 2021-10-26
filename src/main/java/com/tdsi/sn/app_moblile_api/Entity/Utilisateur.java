package com.tdsi.sn.app_moblile_api.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur {

    private String nom ;
    private String prenom ;
    private  int telephone  ;
    private int motPasse ;
    private  int solde ;
    private String numero_carte ;
}
