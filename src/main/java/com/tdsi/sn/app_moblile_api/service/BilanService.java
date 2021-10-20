package com.tdsi.sn.app_moblile_api.service;



import com.tdsi.sn.app_moblile_api.Entity.Bilan;
import com.tdsi.sn.app_moblile_api.repository.BilanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BilanService {

    @Autowired
    private BilanRepository bilanRepository;

    public Iterable<Bilan> getBilans() {
        return bilanRepository.findAll();
    }
    public Optional<Bilan> getBilan(int id) {
        return bilanRepository.findById(id);
    }
    public Bilan createBilan(Bilan bilan) {
        return bilanRepository.save(bilan);
    }
}
