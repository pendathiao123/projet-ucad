package com.tdsi.sn.app_moblile_api.Controller;

import com.tdsi.sn.app_moblile_api.Entity.Attente;
import com.tdsi.sn.app_moblile_api.Repository.AttenteRepository;
import com.tdsi.sn.app_moblile_api.Services.AttenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AttenteController {


    @Autowired
    private AttenteService attenteService;

    @GetMapping("/attentes")
    public Iterable<Attente> getAttentes(){
        return attenteService.getAttentes();
    }
    @GetMapping("/attente/{id}")
    public Attente getAttente(@PathVariable("id") int id){
        return attenteService.getAttente(id);
    }
    @PostMapping("/attente/update")
    public Attente update(@RequestBody Attente attente){
        return attenteService.updateAttente(attente);
    }
}
