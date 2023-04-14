package com.example.tourguide.Service;

import com.example.tourguide.Entity.Accommodation;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AccommodationService {
    String addAccommodation(Accommodation accommodation);

    List<Accommodation> getAllAccommodations(String name);
}
