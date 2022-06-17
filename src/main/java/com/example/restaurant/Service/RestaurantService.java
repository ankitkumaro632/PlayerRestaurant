package com.example.restaurant.Service;

import com.example.restaurant.Entity.Player;
import com.example.restaurant.Entity.Restaurant;
import com.example.restaurant.Reposistory.PlayerRepo;
import com.example.restaurant.Reposistory.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepo restaurantRepo;

    /*Save the restaurant details in the database */
    public Restaurant save_restaurant(Restaurant restaurant) {
        return restaurantRepo.save(restaurant);
    }

    /*find the restaurant details by name*/
    public List<Restaurant> get_restaurant(String name) {
        return restaurantRepo.findByName(name);
    }


}
