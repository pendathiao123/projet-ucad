package com.tdsi.sn.app_moblile_api.Repository;

import com.tdsi.sn.app_moblile_api.Entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoEtudiant extends JpaRepository<Etudiant,Integer> {
}
