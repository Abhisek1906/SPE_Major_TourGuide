package com.example.tourguide.Service;

import com.example.tourguide.Entity.Place;
import com.example.tourguide.Entity.Region;
import com.example.tourguide.Repository.RegionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService{

    private final RegionRepo regionRepo;
    @Override
    public String addRegions(List<Region> regions) {
        List<Region> regionList=regionRepo.saveAll(regions);
        return "Regions Added";
    }

    @Override
    public List<Place> getAllPlaces(String regionName) {
        Region region=regionRepo.findByRegionName(regionName);
        return region.getPlaceList();
    }
}
