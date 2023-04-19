package com.example.tourguide.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.type.descriptor.jdbc.NVarcharJdbcType;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,unique = true)
    private String name;

    @Column(nullable = false)
    private String history;

    @Column(nullable = false)
    private String culture;

    @Column(nullable = false)
    private String customs;

    @OneToMany(mappedBy = "place")
    @JsonManagedReference
    @JsonIgnore
    private List<Accommodation> accommodationList;

    @OneToMany(mappedBy = "place")
    @JsonManagedReference
    @JsonIgnore
    private List<OffBeatPlaces> offBeatPlacesList;

    @OneToMany(mappedBy = "place")
    @JsonManagedReference
    @JsonIgnore
    private List<Foods> foodsList;

    @OneToMany(mappedBy = "place")
    @JsonManagedReference
    @JsonIgnore
    private List<Restaurant> restaurantList;

}
