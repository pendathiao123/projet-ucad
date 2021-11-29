package com.tdsi.sn.app_moblile_api.repository;

import com.tdsi.sn.app_moblile_api.entity.Bilan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BilanRepository extends JpaRepository<Bilan,Integer> {

    Bilan findByCarte_etudiant(String carte_etudiant);
    List<Bilan> findByCode_controlleur(String code_Controller);
}
