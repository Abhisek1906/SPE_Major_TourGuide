package com.example.tourguide.Repository;

import com.example.tourguide.Entity.Foods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodsRepo extends JpaRepository<Foods,String> {
}
