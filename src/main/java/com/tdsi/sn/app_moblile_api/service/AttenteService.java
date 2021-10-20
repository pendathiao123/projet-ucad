package com.tdsi.sn.app_moblile_api.service;

import com.tdsi.sn.app_moblile_api.Entity.Attente;
import com.tdsi.sn.app_moblile_api.repository.AttenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AttenteService {

    @Autowired
    private AttenteRepository attenteRepository;

    public Iterable<Attente> getAttentes() {return attenteRepository.findAll();}
    public Optional<Attente> getAttente(int id) {return attenteRepository.findById(id);}
    public void deleteAttente(Attente attente){
        attenteRepository.delete(attente);
    }
    public Attente addAttente(Attente attente){
        return attenteRepository.save(attente);
    }
    public void deleteWithId(int idEtudiant) {
        List<Integer> l = new ArrayList<>();
        getAttentes().forEach(attente -> {
            if (attente.getIdetudiant() == idEtudiant){
                l.add(attente.getId());
            }
        });
        attenteRepository.deleteAllById(l);
    }
    public List<Integer> getWithIdEtudiant(int id) {
        List<Integer> listes = new ArrayList<>();
        getAttentes().forEach(attente -> {
            if (attente.getIdetudiant() == id){
                listes.add(attente.getId());
            }
        });
        return listes;
    }
    public void delete() {
        attenteRepository.deleteAll();
    }
}
