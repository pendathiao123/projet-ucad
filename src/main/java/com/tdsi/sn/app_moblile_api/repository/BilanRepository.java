package com.tdsi.sn.app_moblile_api.repository;

import com.tdsi.sn.app_moblile_api.Entity.Bilan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BilanRepository extends CrudRepository<Bilan,Integer> {
}
