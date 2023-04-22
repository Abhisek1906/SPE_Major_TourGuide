package com.example.tourguide.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AccommodationReviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accommodationReviewId;

    private String review;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "accommodation_id",nullable = false)
    @JsonBackReference
    private Accommodation accommodation;
}
