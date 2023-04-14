package com.example.tourguide.Repository;

import com.example.tourguide.Entity.Activities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivitiesRepo extends JpaRepository<Activities,Integer> {

}
