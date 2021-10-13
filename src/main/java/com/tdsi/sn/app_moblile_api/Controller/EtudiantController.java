package com.tdsi.sn.app_moblile_api.Controller;
import com.paydunya.neptune.*;
import com.tdsi.sn.app_moblile_api.Entity.Etudiant;
import com.tdsi.sn.app_moblile_api.Services.EtudiantServices;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@EnableAutoConfiguration
@CrossOrigin(origins = "https://10.153.199.187:3000")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EtudiantController {

    @Autowired
    private EtudiantServices etudiantServices ;


    @GetMapping("paydunya")
    public String    payementPaydunya(){
        //Setup

        PaydunyaSetup setup = new PaydunyaSetup();
        setup.setMasterKey("JdXnJOs0-4RXg-YNAF-BDQu-jZxzduBEnsS5");
        setup.setPrivateKey("test_private_ektGD8m72KBgA1yvh7qOLSq0Q8f");
        setup.setPublicKey("test_public_KatdMbJcqZ5gYjCCQp1CC472T3L");
        setup.setToken("ts7lvJUpbBiSuUhgd52q");
        setup.setMode("test");

        //Store
        PaydunyaCheckoutStore store = new PaydunyaCheckoutStore();
        store.setName("ucad_coins"); // Seul le nom est requis
        store.setTagline("App fooor ucad");
        store.setPhoneNumber("775860894");
        store.setPostalAddress("Dakar Plateau - Etablissement kheweul");
        store.setCallbackUrl("https://springapiucad.herokuapp.com/payCallback");
        //store.setWebsiteUrl("http://www.chez-sandra.sn");
       // store.setLogoUrl("http://www.chez-sandra.sn/logo.png");

        PaydunyaCheckoutInvoice invoice = new PaydunyaCheckoutInvoice(setup, store);
        invoice.addItem("tickets", 3, 1000, 3000, "Chaussures");
        invoice.setTotalAmount(30000);
        invoice.create();
        if (invoice.create()) {
            System.out.println(invoice.getStatus());
            System.out.println(invoice.getResponseText());
            System.out.println(invoice.getInvoiceUrl());
        } else {
            System.out.println(invoice.getResponseText());
            System.out.println(invoice.getResponseCode());
        }
   return  invoice.getResponseText();
    }


    @GetMapping("/etudiant")
    public List<Etudiant> getEtudiants(){

        return  etudiantServices.listeEtudiants() ;
    }
    @PostMapping("payCallback")
    public  String callback(){
        return  "Hello Callback" ;
    }
    @PostMapping("/etudiant")
    public Etudiant addEtudiant( @RequestBody Etudiant etudiant){
        return etudiantServices.addEtudiant(etudiant) ;
    }
    @GetMapping("/")
    public String hello(){
        System.out.println("je suis Println");
        return "Hello from Api Spring" ;
    }
    @PutMapping("/etudiant")
    public Etudiant updateEtudiant( @RequestBody Etudiant etudiant){

        return etudiantServices.updateEtudiant(etudiant) ;
    }
    @DeleteMapping("etudiant/{id}")
    public String delEtudiant(@PathVariable int id){
        return  etudiantServices.delEtudiant(id) ;
    }

    @GetMapping("etudiant/{id}")
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
        return etudiantUnknown ;
    }

    @PostMapping ("oneEtudiant")
    public  Etudiant getOneEtudiantByTelephone(@RequestBody Etudiant etudiant){
        int telephone = etudiant.getTelephone() ;
        return etudiantServices.getEtudiantByTelephone(telephone) ;
    }

}
