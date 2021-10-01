package com.tdsi.sn.app_moblile_api.Controller;

import com.tdsi.sn.app_moblile_api.Entity.Etudiant;
import com.tdsi.sn.app_moblile_api.Services.EtudiantServices;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:19006")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EtudiantController {


    @Autowired
    private EtudiantServices etudiantServices ;


    @GetMapping("/etudiant")
    public String getEtudiants(){
       // List<Etudiant>  liste  = etudiantServices.listeEtudiants() ;
        return "very goood " ;
    }
    @PostMapping("/etudiant")
    public Etudiant addEtudiant( @RequestBody Etudiant etudiant){
        return etudiantServices.addEtudiant(etudiant);
    }
    @GetMapping("/")
    public String hello(){
        return "Hello from Api Spring 22" ;
    }
    @PutMapping("/etudiant")
    public Etudiant updateEtudiant( @RequestBody Etudiant etudiant){

        return etudiantServices.updateEtudiant(etudiant) ;
    }
    @DeleteMapping("etudiant/{id}")
    public String delEtudiant(@PathVariable int id){
        return  etudiantServices.delEtudiant(id) ;
    }

    @PutMapping ("transfert/{donneur}/{receveur}/{montant}")
    public String transferer (@PathVariable int donneur ,@PathVariable int receveur , @PathVariable int montant){
        Etudiant etudiant_donneur =  etudiantServices.getEtudiantByTelephone(donneur);
        Etudiant etudiant_receveur =  etudiantServices.getEtudiantByTelephone(receveur);

        if(etudiant_donneur.getSolde()>montant){
            etudiant_receveur.setSolde(etudiant_receveur.getSolde()+montant);
            etudiant_donneur.setSolde(etudiant_donneur.getSolde()-montant);
            etudiantServices.updateEtudiant(etudiant_receveur);
            etudiantServices.updateEtudiant(etudiant_receveur) ;
            return "good" ;
        }
        return "bad";
    }
    @PostMapping("authentication")
    public Etudiant authentication(@RequestBody Etudiant etudiant){
        Etudiant etudiantAuth = etudiantServices.getEtudiantByTelephone(etudiant.getTelephone());
        Etudiant etudiantUnknown = new Etudiant() ;
        etudiantUnknown.setNom("unknown");
        etudiantUnknown.setPrenom("unknown");
        if(etudiantAuth !=null) {
            if (etudiantAuth.getMotPasse() == etudiant.getMotPasse()) {
                return etudiantAuth;
            }
        }
        return etudiantUnknown ;
    }

    @PostMapping ("oneEtudiant")
    public  Etudiant getOneEtudiantByTelephone(@RequestBody Etudiant etudiant){
        int telephone = etudiant.getTelephone() ;
        return etudiantServices.getEtudiantByTelephone(telephone) ;
    }
}
