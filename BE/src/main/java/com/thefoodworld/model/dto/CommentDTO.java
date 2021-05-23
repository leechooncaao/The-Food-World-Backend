package com.thefoodworld.model.dto;

import java.sql.Timestamp;
import java.util.Date;

public class CommentDTO {
    private int commentId;

    private String commentContent;

    private String commentImage;

    private int foodId;

    private int accountId;

    private Date commentTime;

    private int ratingLevel;

    public CommentDTO(int commentId, String commentContent, String commentImage, int foodId, int accountId, Date commentTime, int ratingLevel) {
        this.commentId = commentId;
        this.commentContent = commentContent;
        this.commentImage = commentImage;
        this.foodId = foodId;
        this.accountId = accountId;
        this.commentTime = commentTime;
        this.ratingLevel = ratingLevel;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getCommentImage() {
        return commentImage;
    }

    public void setCommentImage(String commentImage) {
        this.commentImage = commentImage;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public int getRatingLevel() {
        return ratingLevel;
    }

    public void setRatingLevel(int ratingLevel) {
        this.ratingLevel = ratingLevel;
    }
}
