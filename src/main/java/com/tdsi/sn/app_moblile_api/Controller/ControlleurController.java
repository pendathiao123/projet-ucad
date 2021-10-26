package com.tdsi.sn.app_moblile_api.Controller;

import com.tdsi.sn.app_moblile_api.Entity.Controlleur;
import com.tdsi.sn.app_moblile_api.Entity.Etudiant;
import com.tdsi.sn.app_moblile_api.Entity.Login;
import com.tdsi.sn.app_moblile_api.Services.ControlleurService;
import com.tdsi.sn.app_moblile_api.Services.Verification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@EnableAutoConfiguration
@CrossOrigin(origins = "http://localhost:3000")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ControlleurController {

    @Autowired
    private ControlleurService controlleurService;

    @Autowired
    private EtudiantController etudiantController;

    @Autowired
    private Verification verification;

    @GetMapping("/hello")
    public String hello(){
        return "hello massamba sowghhuiiii zsss fffff sssssssssssssss";
    }

    @GetMapping("/controlleurs")
    public Iterable<Controlleur> getControls(){
        return controlleurService.getControlleurs();
    }
    @GetMapping("/controleur/{id}")
    public Controlleur get(@PathVariable("id") int id){
        return controlleurService.getControlleur(id);
    }
    @PostMapping("/controlleur")
    public Controlleur add(@RequestBody Controlleur controlleur){
        return controlleurService.save(controlleur);
    }
    @PostMapping("/controlleur/update")
    public Controlleur update(@RequestBody Controlleur controlleur){
        return controlleurService.updateControlleur(controlleur);
    }
    @PostMapping("/controlleur/login")
    public Controlleur login(@RequestBody Login log){
        return controlleurService.verifyLogin(log.getTelephone(), log.getPassword());
    }
    @GetMapping("/get/public")
    public String get(){
        return verification.getPublic().toString();
    }

    @PostMapping("/controlleur/scanner")
    public Etudiant scanner(@RequestBody Etudiant etudiant){
        return controlleurService.scanCOntrolleur(etudiant);
    }
    @PostMapping("/controlleur/annule")
    public Etudiant annule(@RequestBody Etudiant etudiant){
        return controlleurService.annuleScan(etudiant);
    }
}
