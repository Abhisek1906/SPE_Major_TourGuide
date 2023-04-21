package com.example.tourguide.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer regionId;

    @Column(unique = true)
    String regionName;

    @OneToMany(mappedBy = "region")
    @JsonManagedReference
    @JsonIgnore
    List<Place> placeList;
}
