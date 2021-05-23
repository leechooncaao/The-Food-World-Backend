package com.thefoodworld.model.dto;

import com.thefoodworld.model.Food;

public class FoodDTO {
    private Food food;

    private RatingInfo ratingInfo;

    public FoodDTO(Food food, RatingInfo ratingInfo) {
        this.food = food;
        this.ratingInfo = ratingInfo;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public RatingInfo getRatingInfo() {
        return ratingInfo;
    }

    public void setRatingInfo(RatingInfo ratingInfo) {
        this.ratingInfo = ratingInfo;
    }
}
