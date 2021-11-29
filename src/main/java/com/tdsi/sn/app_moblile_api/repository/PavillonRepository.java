package com.tdsi.sn.app_moblile_api.repository;

import com.tdsi.sn.app_moblile_api.entity.Pavillon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PavillonRepository extends JpaRepository<Pavillon,Integer> {
}
