package com.tdsi.sn.app_moblile_api.service;

import com.tdsi.sn.app_moblile_api.entity.Bilan;
import com.tdsi.sn.app_moblile_api.repository.BilanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BilanService {

    @Autowired
    private BilanRepository bilanRepository;

    public List<Bilan> getBilans(){return bilanRepository.findAll();}
    public Bilan getBilan(int id){return bilanRepository.getById(id);}
    public Bilan create(Bilan bilan){return bilanRepository.save(bilan);}
    public Bilan updateBilan(Bilan bilan) {
        Bilan existingBilan = bilanRepository.findById(bilan.getIdBilan()).orElse(null);
        //existingProduct.setSolde(20000);
        return bilanRepository.save(existingBilan);
    }
    public Bilan getBilanByCarteEtudiant(String carte_etudiant) {
        return bilanRepository.findByCarte_etudiant(carte_etudiant);
    }
    public int nombre_ticket_scanner(String code_controlleur) {
        return bilanRepository.findByCode_controlleur(code_controlleur).size();
    }

}
