package com.tdsi.sn.app_moblile_api.Services;

import com.tdsi.sn.app_moblile_api.Entity.Attente;
import com.tdsi.sn.app_moblile_api.Entity.Controlleur;
import com.tdsi.sn.app_moblile_api.Repository.AttenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttenteService {
    @Autowired
    private AttenteRepository attenteRepository;

    public List<Attente> getAttentes(){
        return attenteRepository.findAll();
    }
    public Attente getAttente(int id) {
        return attenteRepository.getById(id);
    }
    public Attente getAttenteByIdEtudiant(int id_etudiant){
        return attenteRepository.findAttenteById_etudiant(id_etudiant);
    }
    public Attente updateAttente(Attente attente){
        Attente existingAttente = attenteRepository.findById(attente.getId()).orElse(null);
        return attenteRepository.save(existingAttente);
    }
    public Attente create(Attente attente) {
        return attenteRepository.save(attente);
    }
}
