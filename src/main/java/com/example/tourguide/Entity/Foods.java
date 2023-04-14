package com.example.tourguide.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Foods {
    @Id
    private String foodName;

    private String details;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "place_id",nullable = false)
    @JsonBackReference
    private Place place;
}
