package com.thefoodworld.service.order_bill;

import com.thefoodworld.model.OrderBill;
import com.thefoodworld.model.OrderFood;
import com.thefoodworld.model.dto.FoodCart;
import com.thefoodworld.model.dto.OrderDTO;
import com.thefoodworld.repository.OrderBillRepository;
import com.thefoodworld.repository.OrderFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderBillServiceImpl implements OrderBillService{
    @Autowired
    private OrderBillRepository orderBillRepository;

    @Autowired
    private OrderFoodRepository orderFoodRepository;


    @Override
    public OrderBill createOrder(OrderDTO orderDTO) {
        OrderBill newOrder = orderBillRepository.save(orderDTO.getOrder());

        List<OrderFood> orderFoodList = new ArrayList<>();
        for(FoodCart foodCart: orderDTO.getListFoodCarts()){
            orderFoodList.add(new OrderFood(newOrder, foodCart.getFood(), foodCart.getFoodQuantity()));
        }

        orderFoodRepository.saveAll(orderFoodList);

        return newOrder;
    }
}
