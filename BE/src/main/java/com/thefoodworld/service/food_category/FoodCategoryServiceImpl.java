package com.thefoodworld.service.food_category;

import com.thefoodworld.repository.FoodCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodCategoryServiceImpl implements FoodCategoryService{
    @Autowired
    private FoodCategoryRepository foodCategoryRepository;
}
