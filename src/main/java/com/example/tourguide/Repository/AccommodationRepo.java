package com.example.tourguide.Repository;

import com.example.tourguide.Entity.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationRepo extends JpaRepository<Accommodation,Integer> {
    Accommodation findByName(String name);
}
