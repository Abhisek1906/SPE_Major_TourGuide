package com.example.tourguide.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OffBeatPlaces {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    private int distance;

    private String byCarRoute;

    private String byBusRoute;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "place_id",nullable = false)
    @JsonBackReference
    private Place place;

    @OneToMany(mappedBy = "offBeatPlace")
    @JsonManagedReference
    @JsonIgnore
    private List<Activities> activitiesList;
}
