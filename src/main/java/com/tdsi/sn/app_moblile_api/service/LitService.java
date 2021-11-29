package com.tdsi.sn.app_moblile_api.service;

import com.tdsi.sn.app_moblile_api.entity.Lit;
import com.tdsi.sn.app_moblile_api.repository.LitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LitService {

    @Autowired
    private LitRepository litRepository;

    public List<Lit> getLits(){return litRepository.findAll();}
    public Lit getLit(int id){return litRepository.getById(id);}
}
