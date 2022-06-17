package com.example.restaurant.Entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "restaurant")
public class Restaurant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String contact_number;

    private String hoursOfOperation;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JsonBackReference
//    @JoinColumn(name = "player_id")
@ManyToOne
    private Player player;



}
