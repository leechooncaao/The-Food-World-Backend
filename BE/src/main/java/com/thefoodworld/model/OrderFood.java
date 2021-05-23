package com.thefoodworld.model;

import javax.persistence.*;

@Entity
@Table(name = "order_food")
public class OrderFood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_food_id")
    private Integer orderFoodId;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    private OrderBill orderBill;

    @ManyToOne
    @JoinColumn(name = "cart_food_id", referencedColumnName = "cart_food_id")
    private CartFood cartFood;

    public Integer getOrderFoodId() {
        return orderFoodId;
    }

    public void setOrderFoodId(Integer orderFoodId) {
        this.orderFoodId = orderFoodId;
    }

    public OrderBill getOrderBill() {
        return orderBill;
    }

    public void setOrderBill(OrderBill orderBill) {
        this.orderBill = orderBill;
    }

    public CartFood getCartFood() {
        return cartFood;
    }

    public void setCartFood(CartFood cartFood) {
        this.cartFood = cartFood;
    }
}
