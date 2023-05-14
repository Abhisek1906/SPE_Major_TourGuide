package com.example.tourguide.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int restaurantId;

    @Column(unique = true)
    private String name;

    private String address;

    private String rate;

    private String type;

    private String images;
    private int starRating;
    private String typeOfCuisines;
    private String menuLink;
    private String mapLocation;

    private String phoneNo;
    private String description;

    private String specialDiets;

    // service options
    private boolean noContactDelivery;
    private boolean takeaway;
    private boolean dineIn;

    //offerings
    private boolean unlimited;
    private boolean kidsMenu;
    private boolean veganOptions;
    private boolean vegetarianOptions;

    //amenities
    private boolean goodForKids;
    private boolean highChairs;
    private boolean toilets;
    private boolean freeWifi;


    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "place_id",nullable = false)
    @JsonBackReference
    private Place place;

    @OneToMany(mappedBy = "restaurant")
    @JsonManagedReference
    @JsonIgnore
    private List<RestaurantReviews> reviewsList;
}
