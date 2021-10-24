package com.tdsi.sn.app_moblile_api.Services;

import com.tdsi.sn.app_moblile_api.Entity.Attente;
import com.tdsi.sn.app_moblile_api.Entity.Controlleur;
import com.tdsi.sn.app_moblile_api.Entity.Etudiant;
import com.tdsi.sn.app_moblile_api.Repository.AttenteRepository;
import com.tdsi.sn.app_moblile_api.Repository.ControlleurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class ControlleurService {

    @Autowired
    private ControlleurRepository controllerRepository;

    @Autowired
    private EtudiantServices etudiantServices;

    @Autowired
    private AttenteRepository attenteRepository;


    public Iterable<Controlleur> getControlleurs(){
        return controllerRepository.findAll();
    }
    public Controlleur getControlleur(int id){
        return controllerRepository.findById(id).get();
    }
    public Controlleur getCOntrolerByTelephone(String telephone){
        return controllerRepository.findByTelephone(telephone);
    }
    public Controlleur verifyLogin(String telephone,String password){
        Controlleur c = controllerRepository.findByTelephone(telephone);
        if (c.getPassword().equals(password)) {
            return c;
        }
        else {
            return null;
        }
    }
    public Etudiant scanCOntrolleur(Etudiant e){
        Controlleur c = controllerRepository.findByTelephone("765007296");
            Attente attente = attenteRepository.findAttenteById_etudiant(e.getId());
            if (attente.equals(null)){
                Attente attente1 = new Attente();
                attente1.setDate(LocalDateTime.now());
                attente1.setId_etudiant(e.getId());
                if ((LocalTime.now().isAfter(LocalTime.of(6,0,0)))) {
                    attente1.setType_repas("petit dej");
                    if (e.getSolde() >= 50){
                        e.setSolde(e.getSolde() - 50);
                        updateEtudiant(e);
                    }
                    else {
                        System.out.println("solde insuffisant");
                    }
                }
            }
        return updateEtudiant(e);
    }
    public Etudiant updateEtudiant(Etudiant etudiant){
        Etudiant etudiant1 = etudiantServices.getEtudiant(etudiant.getId());
        return etudiantServices.updateEtudiant(etudiant1);
    }
    public Controlleur updateControlleur(Controlleur controlleur){
        Controlleur existingController = controllerRepository.findById(controlleur.getId()).orElse(null);
        return controllerRepository.save(existingController);
    }
    public Etudiant annuleScan(Etudiant etudiant){
        Attente attente = attenteRepository.findAttenteById_etudiant(etudiant.getId());
        if (!etudiant.equals(null)){
            if (LocalTime.now().getMinute() - attente.getDate().getMinute() == 0){
                if ((LocalTime.now().isAfter(LocalTime.of(6,0,0)) && (
                        LocalTime.now().isBefore(LocalTime.of(9,0,0))
                ))){
                    etudiant.setSolde(etudiant.getSolde()+50);
                }
                else if (((LocalTime.now().isAfter(LocalTime.of(11,0,0)) &&
                        (LocalTime.now().isBefore(LocalTime.of(14,0,0))) || (
                        (LocalTime.now().isAfter(LocalTime.of(19,0,0)) && (
                                LocalTime.now().isBefore(LocalTime.of(21,0,0))
                        ))
                )))){
                    etudiant.setSolde(etudiant.getSolde()+100);
                }
            }
        }
        return updateEtudiant(etudiant);
    }
    public Controlleur save(Controlleur controlleur){
        return controllerRepository.save(controlleur);
    }
}
