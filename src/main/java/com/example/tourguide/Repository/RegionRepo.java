package com.example.tourguide.Repository;

import com.example.tourguide.Entity.Place;
import com.example.tourguide.Entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepo extends JpaRepository<Region,Integer> {
    Region findByRegionName(String name);
}
