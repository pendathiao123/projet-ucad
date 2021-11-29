package com.tdsi.sn.app_moblile_api.repository;

import com.tdsi.sn.app_moblile_api.entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant,Integer> {

    Etudiant findByTelephone(int telephone);
    Etudiant findByNumero_carte(String numero_carte);
}
