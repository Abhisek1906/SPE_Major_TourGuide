package com.example.tourguide.Service;

import com.example.tourguide.Entity.Activities;
import com.example.tourguide.Entity.Foods;
import com.example.tourguide.Entity.OffBeatPlaces;
import com.example.tourguide.Entity.Place;

import java.util.List;

public interface PlaceService {
    String addPlace(Place place);

    Place getPlace(String name);

    String addOffBeatPlace(OffBeatPlaces place);

    List<OffBeatPlaces> getAllOffBeatPlaces(String name);

    String addActivityForPlace(Activities activities);

    List<Activities> getAllActivitiesInaPlace(int offBeatId);

    String addFoodForPlace(Foods foods);

    List<Foods> getAllFoodsForaPlace(String name);
}
