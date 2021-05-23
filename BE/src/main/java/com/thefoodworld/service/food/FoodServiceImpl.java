package com.thefoodworld.service.food;

import com.thefoodworld.model.Food;
import com.thefoodworld.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    private FoodRepository foodRepository;

    @Override
    public Page<Food> findAllFoods(Pageable pageable) {
        return foodRepository.findAll(pageable);
    }

    @Override
    public Page<Food> findAllFoodsByName(String foodName, Pageable pageable) {
        return foodRepository.findAllByFoodNameContaining(foodName, pageable);
    }

    @Override
    public Page<Food> findAllFoodsByCategoryId(Integer foodCategoryId, Pageable pageable) {
        return foodRepository.findAllByFoodCategory_FoodCategoryId(foodCategoryId, pageable);
    }

    @Override
    public Page<Food> findAllFoodsByCategoryIdAndFoodName(Integer foodCategoryId, String foodName, Pageable pageable) {
        return foodRepository.findAllByFoodCategory_FoodCategoryIdAndFoodNameContaining(foodCategoryId, foodName, pageable);
    }
}
