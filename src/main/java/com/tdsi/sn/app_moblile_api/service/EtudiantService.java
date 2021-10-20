package com.tdsi.sn.app_moblile_api.service;




import com.tdsi.sn.app_moblile_api.Entity.Etudiant;
import com.tdsi.sn.app_moblile_api.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService {
    @Autowired
    private EtudiantRepository etudiantRepository;


    public Iterable<Etudiant> getEtudiants(){
        return etudiantRepository.findAll();
    }
    public Etudiant getEtudiant(int id) {
        return etudiantRepository.findById(id).get();
    }
    public Etudiant createEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }
    public void deleteEtudiant(int id) {
        etudiantRepository.deleteById(id);
    }
    /*
    public Etudiant getEtudiantByNumber(String numero) {
        final ArrayList<Etudiant> t = new ArrayList<>();
        getEtudiants().forEach(etudiant -> {
            if (etudiant.getNumero().equals(numero)){
                 t.add(etudiant);
            }
        });
        return t.get(0);
    }

    public boolean verifyLogin(String numero,String password) {
        final List<Integer> t = new ArrayList<>();
        Iterable<Etudiant> liste = etudiantRepository.findAll();
        liste.forEach(etudiant -> {
            if (etudiant.getNumero().equals(numero) && etudiant.getPassword().equals(password)){
                t.add(etudiant.getIdetudiant());
            }
        });
        if (t.isEmpty()){
            return false;
        }
        else {
            return true;
        }
    }

 */


    public Etudiant getEtudiantByTelephone(int numero){
        return  etudiantRepository.findByTelephone(numero);
    }
    /*
    public Etudiant updateEtudiant(Etudiant etudiant){
        Etudiant e = etudiantRepository.findById(etudiant.getIdetudiant()).get();

        String prenom = etudiant.getPrenom();
        if (!e.getPrenom().equals(prenom)){
            e.setPrenom(prenom);
        }
        String nom = etudiant.getNom();
        if (!e.getNom().equals(nom)){
            e.setNom(nom);
        }
        int solde = etudiant.getSolde();
        if (e.getSolde() != solde){
            e.setSolde(solde);
        }
        String carte = etudiant.getCarte();
        if (!e.getCarte().equals(carte)){
            e.setCarte(carte);
        }
        String numero = etudiant.getNumero();
        if (!e.getNumero().equals(numero)){
            e.setNumero(numero);
        }
        String password = etudiant.getPassword();
        if (!e.getPassword().equals(password)){
            e.setPassword(password);
        }
        etudiantRepository.save(e);
        return e;

    }*/
}
