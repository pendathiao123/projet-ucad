package com.tdsi.sn.app_moblile_api.repository;


import com.tdsi.sn.app_moblile_api.Entity.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant,Integer> {
}
