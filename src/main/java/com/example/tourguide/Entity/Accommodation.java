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
public class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String type;
    @Column(unique = true)
    private String name;
    private String address;

    @Column(nullable = false)
    private String number;
    private String rate;

    private String images;

    private String mapLocation;

    private int starRating;



    private String description;

    private boolean parking;
    private boolean internet;
    private boolean pool;
    private boolean fitnessCenter;
    private boolean bar;
    private boolean taxiService;

    private boolean bathRobes;
    private boolean airConditioning;
    private boolean additionalBathroom;
    private boolean desk;
    private boolean dinningArea;
    private boolean cable;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name = "accommodation_id",nullable = false)
    private Place place;

    @OneToMany(mappedBy = "accommodation")
    @JsonManagedReference
    @JsonIgnore
    private List<AccommodationReviews> accommodationReviewsList;
}
