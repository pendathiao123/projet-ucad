package com.tdsi.sn.app_moblile_api.controlleur;



import com.tdsi.sn.app_moblile_api.Entity.Etudiant;
import com.tdsi.sn.app_moblile_api.Entity.User;
import com.tdsi.sn.app_moblile_api.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:19002")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;


    @GetMapping("/etudiants")
    public Iterable<Etudiant> getEtudiants() {return etudiantService.getEtudiants();}

    @GetMapping("/etudiant/{id}")
    public Etudiant getEtudiant(@PathVariable("id") int id) {
        return etudiantService.getEtudiant(id);
    }
    @GetMapping("/get/{numero}")
    public Etudiant get(@PathVariable("numero") String numero){
        return etudiantService.getEtudiantByNumber(numero);
    }
    @PostMapping("etudiant")
    public Etudiant save(@RequestBody Etudiant etudiant) {

        return etudiantService.createEtudiant(etudiant);
    }
    @PostMapping("/login")
    public Etudiant inscrire(@RequestBody Etudiant user) {
        Etudiant etudiant = etudiantService.getEtudiantByTelephone( user.getNumero() );
        return etudiant ;
    }
    @GetMapping("/")
    public String hello(){
        return "hello" ;
    }


}
