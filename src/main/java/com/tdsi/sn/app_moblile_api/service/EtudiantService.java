package com.tdsi.sn.app_moblile_api.service;

import com.tdsi.sn.app_moblile_api.entity.Etudiant;
import com.tdsi.sn.app_moblile_api.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantService {

    @Autowired
    private EtudiantRepository etudiantRepository ;


    public List<Etudiant> listeEtudiants(){
        return  etudiantRepository.findAll() ;
    }
    public Etudiant getEtudiant(int id ){
        return  etudiantRepository.findById(id).orElse(null) ;
    }

    public  String delEtudiant(int id){
        etudiantRepository.deleteById(id);
        return  "etudent deleted" ;
    }

    public Etudiant est_un_etudiant(String numero_carte) {
        Etudiant etudiant = null;
        if (etudiantRepository.findByNumero_carte(numero_carte) != null) {
            etudiant = etudiantRepository.findByNumero_carte(numero_carte);
        }
        return etudiant;
    }
    public Etudiant updateEtudiant(Etudiant etudiant) {
        Etudiant existingEtudiant = etudiantRepository.findById(etudiant.getIdEtudiant()).orElse(null);
        //existingProduct.setSolde(20000);
        return etudiantRepository.save(existingEtudiant);
    }
    public Etudiant getEtudiantByTelephone(int telephone){
        return  etudiantRepository.findByTelephone(telephone);
    }

    public  Etudiant addStudent(Etudiant etudiant){
        return etudiantRepository.save(etudiant);
    }
}
