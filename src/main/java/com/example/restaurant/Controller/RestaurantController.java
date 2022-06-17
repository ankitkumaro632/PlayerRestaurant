package com.example.restaurant.Controller;

import com.example.restaurant.Entity.Restaurant;
import com.example.restaurant.Reposistory.RestaurantRepo;
import com.example.restaurant.Service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    private RestaurantRepo restaurantRepo;

    @Autowired
    private RestaurantService restaurantServices;

    /* add the restaurant details */
    @PostMapping( "/addDetails" )
    public ResponseEntity<Restaurant> addDetails(@RequestBody Restaurant restaurant){
        try {
            Restaurant r = restaurantServices.save_restaurant(restaurant);
            System.out.println(restaurant);
            return ResponseEntity.of(Optional.of(r));

        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /* get the restaurant details by name */
    @GetMapping("/getDetail/{name}")
    public ResponseEntity<List<Restaurant>> findRestaurant(@RequestParam String name){
        try {
            return new ResponseEntity<List<Restaurant>>(restaurantRepo.findByName(name),HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }


}
