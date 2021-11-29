package com.tdsi.sn.app_moblile_api.repository;

import com.tdsi.sn.app_moblile_api.entity.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre,Integer> {
}
