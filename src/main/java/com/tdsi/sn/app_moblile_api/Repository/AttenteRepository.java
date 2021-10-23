package com.tdsi.sn.app_moblile_api.Repository;

import com.tdsi.sn.app_moblile_api.Entity.Attente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AttenteRepository extends JpaRepository<Attente,Integer> {
    @Query("from Attente u where u.id_etudiant=?1")
    Attente findAttenteById_etudiant(int id_etudiant);
}
