package com.tdsi.sn.app_moblile_api.repository;


import org.springframework.stereotype.Repository;

@Repository
public interface TraitementRepository {

    public void depot(String numero, int montant);
    public int retrait(String numero, int montant);
    public void transfert(String numero ,String numerodest,int montant);
}
