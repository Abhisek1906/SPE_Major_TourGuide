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

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name = "accommodation_id",nullable = false)
    private Place place;

    @OneToMany(mappedBy = "accommodation")
    @JsonManagedReference
    @JsonIgnore
    private List<AccommodationReviews> accommodationReviewsList;
}
