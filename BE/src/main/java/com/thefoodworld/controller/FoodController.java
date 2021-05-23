package com.thefoodworld.controller;

import com.thefoodworld.model.Food;
import com.thefoodworld.model.dto.FoodDTO;
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
                                                               @RequestParam(required = false) Integer categoryId,
                                                               @RequestParam(defaultValue = "0") int page,
                                                               @RequestParam(defaultValue = "25") int size,
                                                               @RequestParam(defaultValue = "foodId,asc") String[] sortCriteria) {

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
                if (categoryId == null) {
                    pageFoods = foodService.findAllFoods(paging);
                } else {
                    pageFoods = foodService.findAllFoodsByCategoryId(categoryId, paging);
                }
            } else {
                if (categoryId == null) {
                    pageFoods = foodService.findAllFoodsByName(foodName, paging);
                } else {
                    pageFoods = foodService.findAllFoodsByCategoryIdAndFoodName(categoryId, foodName, paging);
                }
            }

            List<Food> foods = pageFoods.getContent();

            if (foods.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            Map<String, Object> response = new HashMap<>();
            response.put("foods", foods);
            response.put("currentPage", pageFoods.getNumber());
            response.put("totalItems", pageFoods.getTotalElements());
            response.put("totalPages", pageFoods.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{foodId}")
    public ResponseEntity<FoodDTO> getFoodById(@PathVariable("foodId") Integer foodId){
        try{
            Food foodFromDb = foodService.findFoodById(foodId);
            if(foodFromDb == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(foodService.findDetailFoodById(foodId), HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
