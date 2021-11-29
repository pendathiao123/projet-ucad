package com.tdsi.sn.app_moblile_api.service;

import com.tdsi.sn.app_moblile_api.entity.Restaurant;
import com.tdsi.sn.app_moblile_api.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<Restaurant> getRestos(){return restaurantRepository.findAll();}
    public Restaurant getResto(int id){return restaurantRepository.getById(id);}
}
