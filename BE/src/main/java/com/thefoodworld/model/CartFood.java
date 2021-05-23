package com.thefoodworld.model;

import javax.persistence.*;

@Entity
@Table(name = "cart_food")
public class CartFood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_food_id")
    private Integer cartFoodId;

    @ManyToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "food_id", referencedColumnName = "food_id")
    private Food food;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "note")
    private String note;

    public Integer getCartFoodId() {
        return cartFoodId;
    }

    public void setCartFoodId(Integer cartFoodId) {
        this.cartFoodId = cartFoodId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
