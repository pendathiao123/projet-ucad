package com.tdsi.sn.app_moblile_api.Services;

import com.tdsi.sn.app_moblile_api.Entity.Etudiant;
import com.tdsi.sn.app_moblile_api.Entity.Utilisateur;
import com.tdsi.sn.app_moblile_api.Repository.RepoEtudiant;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Random;

@Data
@Service
public class EtudiantServices {

    @Autowired
    private RepoEtudiant etudiantRepository ;

    @Autowired
    private Verification verification;

    public List<Etudiant> listeEtudiants(){
        return  etudiantRepository.findAll() ;
    }
    public  Etudiant getEtudiant(int id ){
        return  etudiantRepository.findById(id).orElse(null) ;
    }

    public  String delEtudiant(int id){
        etudiantRepository.deleteById(id);
        return  "etudent deleted" ;
    }
    public Etudiant addEtudiant(Utilisateur utilisateur){
        Etudiant etudiant = new Etudiant();
        etudiant.setPrenom(utilisateur.getPrenom());
        etudiant.setNom(utilisateur.getNom());
        etudiant.setMotPasse(utilisateur.getMotPasse());
        etudiant.setSolde(utilisateur.getSolde());
        etudiant.setNumero_carte(utilisateur.getNumero_carte());
        etudiant.setTelephone(utilisateur.getTelephone());
        etudiant.setPu(verification.getPus(etudiant.getMotPasse(),etudiant.getTelephone()).toString());
        return  etudiantRepository.save(etudiant) ;
    }
    public Etudiant updateEtudiant(Etudiant etudiant) {
        Etudiant existingEtudiant = etudiantRepository.findById(etudiant.getId()).orElse(null);
        //existingProduct.setSolde(20000);

        return etudiantRepository.save(existingEtudiant);
    }

    public Etudiant getEtudiantByTelephone(int telephone){
        return  etudiantRepository.findByTelephone(telephone);
    }


}
