package com.tdsi.sn.app_moblile_api.service;

import com.tdsi.sn.app_moblile_api.entity.Attente;
import com.tdsi.sn.app_moblile_api.entity.Bilan;
import com.tdsi.sn.app_moblile_api.entity.Controlleur;
import com.tdsi.sn.app_moblile_api.entity.Etudiant;
import com.tdsi.sn.app_moblile_api.repository.AttenteRepository;
import com.tdsi.sn.app_moblile_api.repository.ControllerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ControllerService {

    @Autowired
    private ControllerRepository controllerRepository;

    @Autowired
    private EtudiantService etudiantService;

    @Autowired
    private AttenteService attenteService;

    @Autowired
    private BilanService bilanService;

    @Autowired
    private AttenteRepository attenteRepository;

    public List<Controlleur> getControlleurs(){return controllerRepository.findAll();}
    public Controlleur getControlleur(int id){return controllerRepository.getById(id);}
    public Controlleur create(Controlleur controlleur){return controllerRepository.save(controlleur);}
    public Controlleur updateControlleur(Controlleur controlleur){
        Controlleur c = getControlleur(controlleur.getIdControle());
        return c;
    }
    public Controlleur getControllerByNumber(int numero){
        return controllerRepository.findByTelephone(numero);
    }


    public int annule_scan_controlle(Etudiant e) {
        int id = e.getIdEtudiant();
        Etudiant etudiant = etudiantService.getEtudiant(id);
        Bilan bilan = bilanService.getBilanByCarteEtudiant(etudiant.getNumero_carte());

        int mont = etudiant.getSolde();
        int test = 0;
        List<Attente> listesAttentes = new ArrayList<>();
        attenteService.getAttentes().forEach(attente -> {
            if (attente.getIdetudiant() == id) {
                listesAttentes.add(attente);
            }
        });
        if (attenteService.etudiant_est_dans_attente(etudiant.getNumero_carte())&& listesAttentes.get(0).isScanned() == true) {
            if ((LocalTime.now().isAfter(LocalTime.of(6,0,0)) &&
                    (LocalTime.now().isBefore(LocalTime.of(9,30,0))))){
                bilan.setAnnuleScan(true);
                bilanService.updateBilan(bilan);
                etudiant.setSolde(etudiant.getSolde()+50);
                listesAttentes.get(0).setScanned(false);
            }
            else if ((LocalTime.now().isAfter(LocalTime.of(10,0,0))&&
                    (LocalTime.now().isBefore(LocalTime.of(14,0,0)))) ||
                    (LocalTime.now().isAfter(LocalTime.of(19,0,0))&&
                    (LocalTime.now().isBefore(LocalTime.of(21,0,0))))){
                bilan.setAnnuleScan(true);
                bilanService.updateBilan(bilan);
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
     // cette fonction prend en paramtre le numero du controlleur(controlleur) et l'etudiant
    public int Scan_controlle_etudiant(int numeroControlleur, Etudiant etudiant1) {
        // on recupere l'etudiant dans la base de donnée
        String numero_carte = etudiant1.getNumero_carte();
        Etudiant etudiant = etudiantService.getEtudiant(etudiant1.getIdEtudiant());
        AtomicInteger test = new AtomicInteger();
        if (etudiantService.est_un_etudiant(numero_carte) != null){
            // on crée une attente
            Attente attente = new Attente();
            // on verifie si l'etudiant est deja entré (est dans la table attente)
            if (!attenteService.etudiant_est_dans_attente(etudiant.getNumero_carte())){
                // si oui on recupere le controlleur
                Controlleur c = getControllerByNumber(numeroControlleur);
                if ((LocalTime.now().isAfter(LocalTime.of(6, 0, 0)) &&
                        (LocalTime.now().isBefore(LocalTime.of(9, 0, 0))))) {
                    if (etudiant.getSolde() > 50) {
                        etudiant.setSolde(etudiant.getSolde() - 50);
                        test.set(etudiant.getSolde());
                        etudiantService.updateEtudiant(etudiant);
                        // creation attente
                        attente.setNom_resto(c.getRestaurant().getNom());
                        attente.setIdetudiant(etudiant.getIdEtudiant());
                        attente.setDate(Time.valueOf(LocalTime.now()));
                        attente.setScanned(true);
                        attenteService.addAttente(attente);
                        // fin
                        // creation bilan
                        Bilan bilan = new Bilan();
                        bilan.setCarte_etudiant(etudiant.getNumero_carte());
                        bilan.setCode_controlleur(c.getCode());
                        bilan.setNom_resto(c.getRestaurant().getNom());
                        bilan.setAnnuleScan(false);
                        bilan.setType_repas("petit dej");
                        bilan.setLocalTime(LocalTime.now());
                        bilan.setNombre_ticket(bilan.getNombre_ticket()+1);
                        bilanService.create(bilan);
                        // fin
                    }

                } else if ((LocalTime.now().isAfter(LocalTime.of(10, 0, 0))) && (
                        LocalTime.now().isBefore(LocalTime.of(14,0,0))
                )
                ) {

                    controllerRepository.save(c);
                    if (etudiant.getSolde() > 100) {
                        etudiant.setSolde(etudiant1.getSolde() - 100);
                        etudiantService.updateEtudiant(etudiant);
                        System.out.println("massamba");
                        test.set(etudiant.getSolde());
                        // creation attente
                        attente.setNom_resto(c.getRestaurant().getNom());
                        attente.setIdetudiant(etudiant.getIdEtudiant());
                        attente.setDate(Time.valueOf(LocalTime.now()));
                        attente.setScanned(true);
                        attenteService.addAttente(attente);
                        // fin Attente
                        // creation bilan
                        Bilan bilan = new Bilan();
                        bilan.setCarte_etudiant(etudiant.getNumero_carte());
                        bilan.setCode_controlleur(c.getCode());
                        bilan.setNom_resto(c.getRestaurant().getNom());
                        bilan.setAnnuleScan(false);
                        bilan.setType_repas("repas");
                        bilan.setLocalTime(LocalTime.now());
                        bilan.setNombre_ticket(bilan.getNombre_ticket()+1);
                        bilanService.create(bilan);
                        // fin
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


        }
        return test.get();
    }

}
