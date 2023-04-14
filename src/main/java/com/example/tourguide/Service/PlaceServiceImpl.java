package com.example.tourguide.Service;

import com.example.tourguide.Entity.Activities;
import com.example.tourguide.Entity.Foods;
import com.example.tourguide.Entity.OffBeatPlaces;
import com.example.tourguide.Entity.Place;
import com.example.tourguide.Repository.ActivitiesRepo;
import com.example.tourguide.Repository.FoodsRepo;
import com.example.tourguide.Repository.OffBeatPlacesRepo;
import com.example.tourguide.Repository.PlaceRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlaceServiceImpl implements PlaceService{
    private final PlaceRepo placeRepo;

    private final OffBeatPlacesRepo offBeatPlacesRepo;

    private final ActivitiesRepo activitiesRepo;

    private final FoodsRepo foodsRepo;
    @Override
    public String addPlace(Place place) {
        Place place1=placeRepo.save(place);
        if(place1!=null)
            return "Success!";
        else
            return "Failed to add place!";
    }

    @Override
    public Place getPlace(String name) {
        Place place=placeRepo.findByName(name);
        return place;
    }

    @Override
    public String addOffBeatPlace(OffBeatPlaces place) {
        OffBeatPlaces offBeatPlace=offBeatPlacesRepo.save(place);
        if(offBeatPlace!=null)
            return "Success!";
        else
            return "Failed to add offBeatPlace!";
    }

    @Override
    public List<OffBeatPlaces> getAllOffBeatPlaces(String name) {
        Place place= placeRepo.findByName(name);
        return place.getOffBeatPlacesList();
    }

    @Override
    public String addActivityForPlace(Activities activities) {
        Activities activities1=activitiesRepo.save(activities);
        if(activities1!=null)
            return "Success!";
        return "Failed!";
    }

    @Override
    public List<Activities> getAllActivitiesInaPlace(int offBeatId) {
        OffBeatPlaces offBeatPlace=offBeatPlacesRepo.findById(offBeatId);
        return offBeatPlace.getActivitiesList();
    }

    @Override
    public String addFoodForPlace(Foods foods) {
        Foods foods1=foodsRepo.save(foods);
        if(foods1!=null)
            return "Success!";
        return "Failed!";
    }

    @Override
    public List<Foods> getAllFoodsForaPlace(String name) {
        Place place=placeRepo.findByName(name);
        return place.getFoodsList();
    }
}
