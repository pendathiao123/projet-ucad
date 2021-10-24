package com.tdsi.sn.app_moblile_api.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transfert {

    private int donneur;
    private int receveur;
    private int montant;
}
