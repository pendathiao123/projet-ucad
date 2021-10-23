package com.tdsi.sn.app_moblile_api.Services;

import com.tdsi.sn.app_moblile_api.Entity.Attente;
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
    private Attente getAttente(int id) {
        return attenteRepository.getById(id);
    }
    public Attente getAttenteByIdEtudiant(int id_etudiant){
        return attenteRepository.findAttenteById_etudiant(id_etudiant);
    }
}
