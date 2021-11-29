package com.tdsi.sn.app_moblile_api.repository;

import com.tdsi.sn.app_moblile_api.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {

    Restaurant findByNom(String nom);
}
