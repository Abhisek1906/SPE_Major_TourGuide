package com.example.tourguide.Repository;

import com.example.tourguide.Entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepo extends JpaRepository<Restaurant,Integer> {

    Restaurant findByName(String name);
}
