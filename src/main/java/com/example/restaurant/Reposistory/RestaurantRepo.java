package com.example.restaurant.Reposistory;

import com.example.restaurant.Entity.Player;
import com.example.restaurant.Entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant,Long> {
    List<Restaurant> findByName(String name);




}
