package com.tdsi.sn.app_moblile_api.service;


import com.tdsi.sn.app_moblile_api.Entity.Attente;
import com.tdsi.sn.app_moblile_api.Entity.Controlleur;
import com.tdsi.sn.app_moblile_api.Entity.Etudiant;
import com.tdsi.sn.app_moblile_api.repository.AttenteRepository;
import com.tdsi.sn.app_moblile_api.repository.ControlleurRepository;
import com.tdsi.sn.app_moblile_api.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ControllerService {

    @Autowired
    private ControlleurRepository controlleurRepository;

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    private AttenteRepository attenteRepository;

    @Autowired
    private EtudiantService etudiantService;

    @Autowired
    private AttenteService attenteService;

    public Iterable<Controlleur> getControlllers() {
        return controlleurRepository.findAll();
    }
    public Optional<Controlleur> getControlleur(int id) {return controlleurRepository.findById(id);}
    public Controlleur getControllerByNumber(String numero) {
         ArrayList<Controlleur> t = new ArrayList<>();
        getControlllers().forEach(controlleur -> {
            if (controlleur.getNumero().equals(numero)){
                t.add(controlleur);
            }
        });
        if (t.isEmpty()){
            System.out.println("massssssssssssss");
        }
        else {
            System.out.println("goood");
        }
        return t.get(0);

    }

    public int ScanControlle(String numeroControlleur, Etudiant etudiant1) {
        Etudiant etudiant = etudiantService.getEtudiant(etudiant1.getIdetudiant());
        Attente attente = new Attente();
        AtomicInteger test = new AtomicInteger();
        ArrayList<Integer> idEtudiants = new ArrayList<>();
        Iterable<Attente> lesAttentes = attenteService.getAttentes();
        lesAttentes.forEach(attente1 -> {
            if (attente1.getIdetudiant() == etudiant.getIdetudiant()) {
                idEtudiants.add(attente1.getId());
                System.out.println("test 1");
            }
        });
   System.out.println(idEtudiants);
              if (idEtudiants.size() == 0){
                  System.out.println("test 2");
                   List<Integer> listes = attenteService.getWithIdEtudiant(etudiant.getIdetudiant());
                   Controlleur c = getControllerByNumber(numeroControlleur);
                       if ((LocalTime.now().isAfter(LocalTime.of(6, 0, 0)) &&
                               (LocalTime.now().isBefore(LocalTime.of(9, 0, 0))))) {
                           if (etudiant.getSolde() > 50) {
                               etudiant.setSolde(etudiant.getSolde() - 50);
                               c.setCompteur(c.getCompteur() + 1);
                               updateController(c);
                               System.out.println("sow");
                               test.set(etudiant.getSolde());
                               etudiantService.updateEtudiant(etudiant);
                               attente.setIdetudiant(etudiant.getIdetudiant());
                               attente.setDate(Time.valueOf(LocalTime.now()));
                               attente.setScanned(true);
                               attenteService.addAttente(attente);
                           }

                       } else if ((LocalTime.now().isAfter(LocalTime.of(10, 0, 0))) && (
                               LocalTime.now().isBefore(LocalTime.of(14,0,0))
                       )
                       ) {
                           controlleurRepository.save(c);
                           if (etudiant.getSolde() > 100) {
                               etudiant.setSolde(etudiant1.getSolde() - 100);
                               c.setCompteur(c.getCompteur() + 1);
                               etudiantService.updateEtudiant(etudiant);
                               System.out.println("massamba");
                               test.set(etudiant.getSolde());
                               attente.setIdetudiant(etudiant.getIdetudiant());
                               attente.setDate(Time.valueOf(LocalTime.now()));
                               attente.setScanned(true);
                               attenteService.addAttente(attente);
                           }
                       }
                   else {
                       test.set(-100);
                       System.out.println("idEtudiants test 3");
                   }
               }
              else {
                  test.set(-1);
                  System.out.println("deja scanne");
              }


        return test.get();
    }

    public boolean verifyLogin(String numero,String password) {
        final List<Integer> t = new ArrayList<>();
        Iterable<Controlleur> liste = controlleurRepository.findAll();
        liste.forEach(controlleur -> {
            if (controlleur.getNumero().equals(numero) && controlleur.getPassword().equals(password)){
                t.add(controlleur.getIdcontrole());
            }
        });
        if (t.isEmpty()){
            return false;
        }
        else {
            return true;
        }
    }
    public Controlleur save(Controlleur controlleur) {
        return controlleurRepository.save(controlleur);
    }

    public int controlle(Etudiant e) {
        int id = e.getIdetudiant();
        Etudiant etudiant = etudiantService.getEtudiant(id);
        int mont = etudiant.getSolde();
        int test = 0;
        List<Attente> listesAttentes = new ArrayList<>();
        attenteService.getAttentes().forEach(attente -> {
            if (attente.getIdetudiant() == id) {
                listesAttentes.add(attente);
            }
        });
        if (listesAttentes.size() == 1 && listesAttentes.get(0).isScanned() == true) {
            if ((LocalTime.now().isAfter(LocalTime.of(6,0,0)) &&
                    (LocalTime.now().isBefore(LocalTime.of(9,30,0))))){
                etudiant.setSolde(etudiant.getSolde()+50);
                listesAttentes.get(0).setScanned(false);
            }
            else if ((LocalTime.now().isAfter(LocalTime.of(10,0,0))&&
                    (LocalTime.now().isBefore(LocalTime.of(14,0,0)))) ||
                    (LocalTime.now().isAfter(LocalTime.of(19,0,0))&&
                    (LocalTime.now().isBefore(LocalTime.of(21,0,0))))){
                etudiant.setSolde(etudiant.getSolde()+100);
                listesAttentes.get(0).setScanned(false);
            }
            etudiantService.updateEtudiant(etudiant);
            test = etudiant.getSolde() - mont;
        }
        else {
            System.out.println("deja scanner ok");
            test = -1;
        }
        return test;
    }
    public Controlleur updateController(Controlleur controlleur){
        Controlleur c = getControlleur(controlleur.getIdcontrole()).get();
        String prenom = controlleur.getPrenom();
        if (!prenom.equals(c.getPrenom())){
            c.setPrenom(prenom);
        }
        String nom = controlleur.getNom();
        if (!nom.equals(c.getNom())){
            c.setNom(nom);
        }
        int compteur = controlleur.getCompteur();
        if (compteur != c.getCompteur()){
            c.setCompteur(compteur);
        }
        String numero = controlleur.getNumero();
        if (!numero.equals(c.getNumero())){
            c.setNumero(numero);
        }
        String password = controlleur.getPassword();
        if (!password.equals(c.getPassword())){
            c.setPassword(password);
        }
        return c;
    }
}
