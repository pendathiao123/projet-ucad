package com.tdsi.sn.app_moblile_api.repository;


import com.tdsi.sn.app_moblile_api.Entity.Controlleur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ControlleurRepository extends CrudRepository<Controlleur,Integer> {
}
