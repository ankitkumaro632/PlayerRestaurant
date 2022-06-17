package com.example.restaurant.Service;

import com.example.restaurant.Entity.Player;
import com.example.restaurant.Entity.Restaurant;
import com.example.restaurant.Reposistory.PlayerRepo;
import com.example.restaurant.Reposistory.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepo playerRepo;

    @Autowired
    private RestaurantRepo restaurantRepo;

    public Player savePlayer(Player player){
        return playerRepo.save(player);
    }

    public List<Player> getPlayer(String firstName,String lastName){
        return playerRepo.findByFirstNameAndLastName(firstName,lastName);
    }

    public List<Player> findPlayer(String name,int age){
        return playerRepo.findByRestaurantNameAndAgeGreaterThanEqual(name,age);
    }


    /*fetch the collection player and restaurant*/
    public Restaurant getPlayerAndRestaurantCollection(Long id, Long player_id) {
        Player player=playerRepo.getById(player_id);
        Restaurant restaurant1=new Restaurant();
        restaurant1.setPlayer(player);
        return restaurantRepo.save(restaurant1);
    }

}
