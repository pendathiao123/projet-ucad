package com.tdsi.sn.app_moblile_api.Controller;
import com.tdsi.sn.app_moblile_api.Entity.Etudiant;
import com.tdsi.sn.app_moblile_api.Services.EtudiantServices;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@RestController
@EnableAutoConfiguration
@CrossOrigin(origins = "http://localhost:3000")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EtudiantController {

    @Autowired
    private EtudiantServices etudiantServices ;

    @GetMapping("/etudiant")
    public List<Etudiant> getEtudiants(){

        return  etudiantServices.listeEtudiants() ;
    }

    @GetMapping("/")
    public String hello(){
        System.out.println("je suis Println");
        return "Hello from Api Spring boot 222" ;
    }
    @PutMapping("/etudiant")
    public Etudiant updateEtudiant( @RequestBody Etudiant etudiant){

        return etudiantServices.updateEtudiant(etudiant) ;
    }
    @DeleteMapping("etudiant/{id}")
    public String delEtudiant(@PathVariable int id){
        return  etudiantServices.delEtudiant(id) ;
    }

    @GetMapping("/etudiant/{id}")
    public Etudiant getOneEtudiant(@PathVariable int id){
        return  etudiantServices.getEtudiant(id) ;
    }
    @PutMapping ("transfert/{donneur}/{receveur}/{montant}")
    public String transferer (@PathVariable int donneur ,@PathVariable int receveur , @PathVariable int montant){
        Etudiant etudiant_donneur =  etudiantServices.getEtudiantByTelephone(donneur);
        Etudiant etudiant_receveur =  etudiantServices.getEtudiantByTelephone(receveur);

        if(etudiant_donneur.getSolde()>montant){
            etudiant_receveur.setSolde(etudiant_receveur.getSolde()+montant);
            etudiant_donneur.setSolde(etudiant_donneur.getSolde()-montant);
            etudiantServices.updateEtudiant(etudiant_donneur);
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
        return null ;
    }

    @PostMapping ("oneEtudiant")
    public  Etudiant getOneEtudiantByTelephone(@RequestBody Etudiant etudiant){
        int telephone = etudiant.getTelephone() ;
          if(etudiantServices.getEtudiantByTelephone(telephone)!=null) {
              return etudiantServices.getEtudiantByTelephone(telephone);
          }else
              return null ;
    }

    @PostMapping("paySuccess")
    public String   Success(){
        Etudiant etudiant = etudiantServices.getEtudiant(1);
        etudiant.setSolde(2000000);
        etudiantServices.updateEtudiant(etudiant);
        return "good";
    }
   

}
