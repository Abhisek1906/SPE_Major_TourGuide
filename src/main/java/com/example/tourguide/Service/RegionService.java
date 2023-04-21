package com.example.tourguide.Service;

import com.example.tourguide.Entity.Place;
import com.example.tourguide.Entity.Region;

import java.util.List;

public interface RegionService {
    String addRegions(List<Region> regions);

    List<Place> getAllPlaces(String regionName);
}
