package com.example.tourguide.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Activities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    private String details;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "OffBeat_place_id",nullable = false)
    @JsonBackReference
    private OffBeatPlaces offBeatPlace;
}
