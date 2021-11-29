package com.tdsi.sn.app_moblile_api.service;

import com.tdsi.sn.app_moblile_api.entity.Pavillon;
import com.tdsi.sn.app_moblile_api.repository.PavillonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PavillonService {
    @Autowired
    private PavillonRepository pavillonRepository;

    public List<Pavillon> getPavillons(){return pavillonRepository.findAll();}
    public Pavillon getPavillons(int id){return pavillonRepository.getById(id);}
    public int delete(Pavillon pavillon){pavillonRepository.delete(pavillon); return 1;}
}
