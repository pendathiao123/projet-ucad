package com.tdsi.sn.app_moblile_api.service;



import com.tdsi.sn.app_moblile_api.Entity.Restaurant;
import com.tdsi.sn.app_moblile_api.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public Iterable<Restaurant> getRestaurants(){
        return restaurantRepository.findAll();
    }
    public Optional<Restaurant> getRestaurant(int id) {
        return restaurantRepository.findById(id);
    }
}
