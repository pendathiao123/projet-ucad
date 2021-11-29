package com.tdsi.sn.app_moblile_api.repository;

import com.tdsi.sn.app_moblile_api.entity.Attente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttenteRepository extends JpaRepository<Attente,Integer> {
    Attente getWithIdEtudiant(int idEtudiant);

}
