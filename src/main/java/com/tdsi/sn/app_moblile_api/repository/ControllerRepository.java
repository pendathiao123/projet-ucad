package com.tdsi.sn.app_moblile_api.repository;

import com.tdsi.sn.app_moblile_api.entity.Controlleur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ControllerRepository extends JpaRepository<Controlleur,Integer> {
    Controlleur findByTelephone(int telephone);

    Controlleur findByPrenom(String s);
}
