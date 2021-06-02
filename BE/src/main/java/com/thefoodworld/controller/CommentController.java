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

import java.sql.Timestamp;
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
    public ResponseEntity<List<CommentDTO>> getAllCommentsOfFood(@PathVariable("foodId") Integer foodId) {
        try {
            Food food = foodService.findFoodById(foodId);
            if (food == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<>(commentService.getAllCommentByFoodId(foodId), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        try {
            comment.setCommentTime(new Timestamp(System.currentTimeMillis()));
            return new ResponseEntity<>(commentService.createOrUpdateComment(comment), HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<Comment> updateComment(@PathVariable("commentId") Integer commentId, @RequestBody Comment comment) {
        try {
            if (commentService.getCommentById(commentId) == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }else {
                comment.setCommentTime(commentService.getCommentById(commentId).getCommentTime());
            }
            return new ResponseEntity<>(commentService.createOrUpdateComment(comment), HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> removeComment(@PathVariable("commentId") Integer commentId){
        try {
            if (commentService.getCommentById(commentId) == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            commentService.removeCommentById(commentId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
