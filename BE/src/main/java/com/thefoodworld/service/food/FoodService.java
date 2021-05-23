package com.thefoodworld.service.food;

import com.thefoodworld.model.Food;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FoodService {
    Page<Food> findAllFoods (Pageable pageable);

    Page<Food> findAllFoodsByName(String foodName, Pageable pageable);

}
