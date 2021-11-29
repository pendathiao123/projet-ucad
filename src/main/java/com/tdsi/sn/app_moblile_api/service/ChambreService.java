package com.tdsi.sn.app_moblile_api.service;

import com.tdsi.sn.app_moblile_api.entity.Chambre;
import com.tdsi.sn.app_moblile_api.repository.ChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChambreService {
    @Autowired
    private ChambreRepository chambreRepository;

    public List<Chambre> getChambres(){return chambreRepository.findAll();}
    public Chambre getChambre(int id){return chambreRepository.getById(id);}
}
