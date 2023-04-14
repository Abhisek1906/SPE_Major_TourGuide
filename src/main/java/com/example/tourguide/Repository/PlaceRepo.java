package com.example.tourguide.Repository;

import com.example.tourguide.Entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlaceRepo extends JpaRepository<Place,Integer> {

    Place findByName(String name);
}
