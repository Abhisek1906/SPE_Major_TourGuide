package com.example.tourguide.Repository;

import com.example.tourguide.Entity.OffBeatPlaces;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OffBeatPlacesRepo extends JpaRepository<OffBeatPlaces,Integer> {
    OffBeatPlaces findById(int id);
}
