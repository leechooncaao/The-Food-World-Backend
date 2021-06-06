package com.thefoodworld.model.dto;

import com.thefoodworld.model.OrderBill;

import java.util.List;

public class OrderDTO {
    private OrderBill order;

    private List<FoodCart> listFoodCarts;

    public OrderDTO(OrderBill order, List<FoodCart> listFoodCarts) {
        this.order = order;
        this.listFoodCarts = listFoodCarts;
    }

    public OrderBill getOrder() {
        return order;
    }

    public void setOrder(OrderBill order) {
        this.order = order;
    }

    public List<FoodCart> getListFoodCarts() {
        return listFoodCarts;
    }

    public void setListFoodCarts(List<FoodCart> listFoodCarts) {
        this.listFoodCarts = listFoodCarts;
    }
}
