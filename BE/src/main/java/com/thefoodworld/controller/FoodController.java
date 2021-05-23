package com.thefoodworld.controller;

import com.thefoodworld.model.Food;
import com.thefoodworld.service.food.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/foods")
public class FoodController {
    @Autowired
    private FoodService foodService;

    // convert direction param from Frontend to Backend
    private Sort.Direction getSortDirection(String direction) {
        if (direction.equals("asc")) {
            return Sort.Direction.ASC;
        } else if (direction.equals("desc")) {
            return Sort.Direction.DESC;
        }

        return Sort.Direction.ASC;
    }

    @GetMapping("")
    public ResponseEntity<Map<String, Object>> getAllFoodsPage(@RequestParam(required = false) String foodName,
                                                               @RequestParam(defaultValue = "0") int page,
                                                               @RequestParam(defaultValue = "25") int size,
                                                               @RequestParam(required = false, defaultValue = "foodId,asc") String[] sortCriteria) {

        try {
            Pageable paging;
            Page<Food> pageFoods;

            if (sortCriteria == null) {
                paging = PageRequest.of(page, size);
            } else {
                List<Order> orders = new ArrayList<>();
                orders.add(new Order(getSortDirection(sortCriteria[1]), sortCriteria[0]));
                paging = PageRequest.of(page, size, Sort.by(orders));
            }

            if (foodName == null) {
                // get all list of foods with pagination
                pageFoods = foodService.findAllFoods(paging);
            } else {
                // get all list of foods by foodName with pagination
                pageFoods = foodService.findAllFoodsByName(foodName, paging);
            }

            List<Food> foods = pageFoods.getContent();

            if(foods.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            Map<String, Object> response = new HashMap<>();
            response.put("foods", foods);
            response.put("currentPage", pageFoods.getNumber());
            response.put("totalItems", pageFoods.getTotalElements());
            response.put("totalPages", pageFoods.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);

        }catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
