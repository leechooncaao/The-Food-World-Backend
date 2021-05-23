package com.thefoodworld.service.order_food;

import com.thefoodworld.repository.OrderFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderFoodServiceImpl implements OrderFoodService{
    @Autowired
    private OrderFoodRepository orderFoodRepository;
}
