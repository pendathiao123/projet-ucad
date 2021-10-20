package com.tdsi.sn.app_moblile_api.controlleur;



import com.tdsi.sn.app_moblile_api.Entity.Restaurant;
import com.tdsi.sn.app_moblile_api.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public Iterable<Restaurant> restos() {
        return restaurantService.getRestaurants();
    }
    @GetMapping("/restaurant/{id}")
    public Optional<Restaurant> getResto(@PathVariable("id") int id) {
        return restaurantService.getRestaurant(id);
    }
}
