package com.example.tourguide.Service;

import com.example.tourguide.Entity.Accommodation;
import com.example.tourguide.Entity.Place;
import com.example.tourguide.Repository.AccommodationRepo;
import com.example.tourguide.Repository.PlaceRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AccommodationServiceImpl implements AccommodationService{

    private final AccommodationRepo accommodationRepo;
    private final PlaceRepo placeRepo;
    @Override
    public String addAccommodation(Accommodation accommodation) {
        Accommodation accommodation1=accommodationRepo.save(accommodation);
        if(accommodation1!=null)
            return "Success!";
        else
            return "Failed to add place!";
    }

    @Override
    public List<Accommodation> getAllAccommodations(String name) {
        Place place= placeRepo.findByName(name);
        return place.getAccommodationList();
    }
}
