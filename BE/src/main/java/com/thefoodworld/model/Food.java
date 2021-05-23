package com.thefoodworld.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")
    private Integer foodId;

    @Column(name = "food_name")
    private String foodName;

    @Column(name = "food_price")
    private Double foodPrice;

    @Column(name = "food_status")
    private Integer foodStatus;

    @ManyToOne
    @JoinColumn(name = "food_category_id", referencedColumnName = "food_category_id")
    private FoodCategory foodCategory;

    @Column(name = "food_image")
    private String foodImage;

    @Column(name = "food_time_post")
    private Date foodTimePost;

    @Column(name = "number_order")
    private Integer numberOrder;

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(Double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public Integer getFoodStatus() {
        return foodStatus;
    }

    public void setFoodStatus(Integer foodStatus) {
        this.foodStatus = foodStatus;
    }

    public FoodCategory getFoodCategory() {
        return foodCategory;
    }

    public void setFoodCategory(FoodCategory foodCategory) {
        this.foodCategory = foodCategory;
    }

    public String getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(String foodImage) {
        this.foodImage = foodImage;
    }

    public Date getFoodTimePost() {
        return foodTimePost;
    }

    public void setFoodTimePost(Date foodTimePost) {
        this.foodTimePost = foodTimePost;
    }

    public Integer getNumberOrder() {
        return numberOrder;
    }

    public void setNumberOrder(Integer numberOrder) {
        this.numberOrder = numberOrder;
    }
}
