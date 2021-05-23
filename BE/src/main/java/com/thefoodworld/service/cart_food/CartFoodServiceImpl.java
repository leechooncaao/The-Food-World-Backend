package com.thefoodworld.service.cart_food;

import com.thefoodworld.repository.CartFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartFoodServiceImpl implements CartFoodService{
    @Autowired
    private CartFoodRepository cartFoodRepository;
}
