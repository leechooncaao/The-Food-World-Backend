package com.thefoodworld.service.food;

import com.thefoodworld.model.Food;
import com.thefoodworld.model.dto.FoodDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FoodService {
    Page<Food> findAllFoods (Pageable pageable);

    Page<Food> findAllFoodsByName(String foodName, Pageable pageable);

    Page<Food> findAllFoodsByCategoryId(Integer foodCategoryId, Pageable pageable);

    Page<Food> findAllFoodsByCategoryIdAndFoodName(Integer foodCategoryId, String foodName, Pageable pageable);

    FoodDTO findDetailFoodById(Integer foodId);

    Food findFoodById(Integer foodId);

}
