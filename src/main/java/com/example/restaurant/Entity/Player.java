package com.example.restaurant.Entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long player_id;
    private String firstName;
    private String lastName;
    private String dob;
    private int age;
    private String primary_address;
    private String alternative_address;
    private String office_address;
    private String phone_number;
    private String email;
    private String driving_license;
    private String passport;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "restaurant_id")
//    @JsonManagedReference
@OneToMany(mappedBy = "player", cascade = CascadeType.ALL, fetch = FetchType.LAZY)

private List<Restaurant> restaurant ;
}
