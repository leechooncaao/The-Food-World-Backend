package com.thefoodworld.repository;

import com.thefoodworld.model.Food;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {
    Page<Food> findAllByFoodNameContaining(String foodName, Pageable pageable);
}
