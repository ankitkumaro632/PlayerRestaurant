package com.example.restaurant.Reposistory;

import com.example.restaurant.Entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepo extends JpaRepository<Player,Long> {
    List<Player> findByFirstNameAndLastName(String firstName, String lastName);

    List<Player> findByRestaurantNameAndAgeGreaterThanEqual(String name , int age);

}
