package com.thefoodworld.repository;

import com.thefoodworld.model.CartFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartFoodRepository extends JpaRepository<CartFood, Integer> {
}
