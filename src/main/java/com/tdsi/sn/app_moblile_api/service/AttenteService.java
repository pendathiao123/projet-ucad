package com.tdsi.sn.app_moblile_api.service;

import com.tdsi.sn.app_moblile_api.entity.Attente;
import com.tdsi.sn.app_moblile_api.entity.Etudiant;
import com.tdsi.sn.app_moblile_api.repository.AttenteRepository;
import com.tdsi.sn.app_moblile_api.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttenteService {

    @Autowired
    private AttenteRepository attenteRepository;

    @Autowired
    private EtudiantRepository etudiantRepository;

    public List<Attente> getAttentes(){return attenteRepository.findAll();}
    public Attente getAttente(int id){return attenteRepository.getById(id);}
    public Attente addAttente(Attente attente){return attenteRepository.save(attente);}
    public boolean etudiant_est_dans_attente(String carte_etudiant){
        Etudiant etudiant = etudiantRepository.findByNumero_carte(carte_etudiant);
        Attente attente = attenteRepository.getWithIdEtudiant(etudiant.getIdEtudiant());
        return  attenteRepository.existsById(attente.getId());
    }
}
