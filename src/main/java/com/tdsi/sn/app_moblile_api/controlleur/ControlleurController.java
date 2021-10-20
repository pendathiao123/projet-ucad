package com.tdsi.sn.app_moblile_api.controlleur;



import com.tdsi.sn.app_moblile_api.Entity.Controler;
import com.tdsi.sn.app_moblile_api.Entity.Controlleur;
import com.tdsi.sn.app_moblile_api.Entity.Etudiant;
import com.tdsi.sn.app_moblile_api.Entity.User;
import com.tdsi.sn.app_moblile_api.service.ControllerService;
import com.tdsi.sn.app_moblile_api.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:19002")
public class ControlleurController {

    @Autowired
    private ControllerService controllerService;


    @Autowired
    private EtudiantService etudiantService;

    @GetMapping("/controleurs")
    public Iterable<Controlleur> getControlleurs(){
        return controllerService.getControlllers();
    }
    @GetMapping("/controlleur/{id}")
    public Optional<Controlleur> getControlleur(@PathVariable("id") int id) {
        return controllerService.getControlleur(id);
    }
    @GetMapping("/controller/{numero}")
    public Controlleur getControl(@PathVariable("numero") String numero) {
        return controllerService.getControllerByNumber(numero);
    }
    @PutMapping("/control/{numero}")
    public int scan(@PathVariable("numero") String numero,@RequestBody Etudiant etudiant) {
        return controllerService.ScanControlle(numero,etudiant);
    }
    @PutMapping("/controlleur/login")
    public boolean controlle(@RequestBody User user) {
        return controllerService.verifyLogin(user.getNumero(), user.getPassword());
    }
    @PutMapping("/controlleur")
    public Controlleur save(@RequestBody Controlleur controlleur) {
        return controllerService.save(controlleur);
    }

    @PutMapping("/controlle/annule")
    public int getControll(@RequestBody Controler controler){
        String numeroControler = controler.getNumero1();
        int id = controler.getId();
        Etudiant e = etudiantService.getEtudiant(id);
       Controlleur c = controllerService.getControllerByNumber(numeroControler);
       c.setCompteur(c.getCompteur() - 1);
       controllerService.updateController(c);
       return controllerService.controlle(e);
    }
    @GetMapping("/compteur/{numero}")
    public int myCompteur(@PathVariable("numero") String numero){
        Controlleur controlleur = controllerService.getControllerByNumber(numero);
        return controlleur.getCompteur();
    }

}


