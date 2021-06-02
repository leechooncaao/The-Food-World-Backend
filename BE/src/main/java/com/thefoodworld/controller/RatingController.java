package com.thefoodworld.controller;

import com.thefoodworld.model.Rating;
import com.thefoodworld.model.dto.RatingInfo;
import com.thefoodworld.service.account.AccountService;
import com.thefoodworld.service.food.FoodService;
import com.thefoodworld.service.rating.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/rating")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @Autowired
    private FoodService foodService;

    @Autowired
    private AccountService accountService;

    @PostMapping("")
    public ResponseEntity<Rating> addOrUpdateRating(@RequestBody Rating rating) {
        try {
            return new ResponseEntity<>(ratingService.addOrUpdateRating(rating), HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("")
    public ResponseEntity<Rating> getRating(@RequestParam Integer foodId, @RequestParam Integer accountId) {
        try {
            if (foodService.findFoodById(foodId) == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            if (accountService.findAccountById(accountId) == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<>(ratingService.getRatingByFoodIdAndAccountId(foodId, accountId), HttpStatus.OK);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{foodId}")
    public ResponseEntity<RatingInfo> getRatingInfo(@PathVariable("foodId") Integer foodId){
        try{
            if (foodService.findFoodById(foodId) == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<>(ratingService.getRatingInfoByFoodId(foodId), HttpStatus.OK);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
