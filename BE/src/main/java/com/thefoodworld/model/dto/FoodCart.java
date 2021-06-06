package com.thefoodworld.model.dto;

import com.thefoodworld.model.Food;

public class FoodCart {
    private Food food;

    private Integer foodQuantity;

    public FoodCart(Food food, Integer foodQuantity) {
        this.food = food;
        this.foodQuantity = foodQuantity;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Integer getFoodQuantity() {
        return foodQuantity;
    }

    public void setFoodQuantity(Integer foodQuantity) {
        this.foodQuantity = foodQuantity;
    }
}
