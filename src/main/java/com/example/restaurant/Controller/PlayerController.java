package com.example.restaurant.Controller;

import com.example.restaurant.Entity.Player;
import com.example.restaurant.Entity.Restaurant;
import com.example.restaurant.Reposistory.PlayerRepo;
import com.example.restaurant.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private PlayerRepo playerRepo;

    @Autowired
    private PlayerService playerService;

    /* Adding the player */
    @PostMapping("/addPlayer")
    public ResponseEntity<Player> savePlayer(@RequestBody Player player){
        try {
            Player player1 = playerService.savePlayer(player);
            System.out.println(player);
            return ResponseEntity.of(Optional.of(player1));

        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /* Get the Player By Name */
    @GetMapping("/getPlayer/{name}")
    public ResponseEntity<List<Player>> getPlayer(@RequestParam String firstName, @RequestParam String lastName){
        try {
          return new ResponseEntity<List<Player>>(playerRepo.findByFirstNameAndLastName(firstName,lastName),HttpStatus.OK);

        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



    /* Get the player by age */
    @GetMapping("/get/{name}/{age}")
    public ResponseEntity<List<Player>> findPlayer(@PathVariable String name, @PathVariable int age){
        try {
            List<Player> player = playerService.findPlayer(name, age);
            System.out.println(name+" "+age);
            return ResponseEntity.of(Optional.of(player));

        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    /*restaurant and player are linked */
    @GetMapping( "/{player_id}/restaurant" )
    public ResponseEntity<Restaurant> addDetails(@PathVariable("id") Long id, @PathVariable("player_id") Long player_id){
        try {
            Restaurant r = playerService.getPlayerAndRestaurantCollection(id,player_id);

            return ResponseEntity.of(Optional.of(r));

        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
