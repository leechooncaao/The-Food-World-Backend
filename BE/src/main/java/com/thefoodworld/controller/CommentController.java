package com.thefoodworld.controller;

import com.thefoodworld.model.Comment;
import com.thefoodworld.model.Food;
import com.thefoodworld.model.dto.CommentDTO;
import com.thefoodworld.service.comment.CommentService;
import com.thefoodworld.service.food.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private FoodService foodService;

    @GetMapping("/{foodId}")
    public ResponseEntity<List<CommentDTO>> getAllCommentsOfFood(@PathVariable("foodId") Integer foodId){
        try{
            Food food = foodService.findFoodById(foodId);
            if(food == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<>(commentService.getAllCommentByFoodId(foodId), HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
