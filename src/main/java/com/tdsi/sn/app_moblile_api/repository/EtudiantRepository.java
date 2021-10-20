package com.tdsi.sn.app_moblile_api.repository;

import com.tdsi.sn.app_moblile_api.Entity.Etudiant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends CrudRepository<Etudiant,Integer> {
    @Query("from Etudiant u where u.numero=?1")
    Etudiant findByTelephone(int numero);
}
