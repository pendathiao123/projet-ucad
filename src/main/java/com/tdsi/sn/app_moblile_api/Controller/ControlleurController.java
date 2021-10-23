package com.tdsi.sn.app_moblile_api.Controller;

import com.tdsi.sn.app_moblile_api.Entity.Controlleur;
import com.tdsi.sn.app_moblile_api.Entity.Etudiant;
import com.tdsi.sn.app_moblile_api.Services.ControlleurService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/hello")
    public String hello(){
        return "hello massamba sowghhuiiii";
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
    public Controlleur login(@RequestBody Controlleur controlleur){
        return controlleurService.verifyLogin(controlleur.getTelephone(), controlleur.getPassword());
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
