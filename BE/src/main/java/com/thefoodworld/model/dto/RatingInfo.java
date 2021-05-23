package com.thefoodworld.model.dto;


public class RatingInfo {
    private Double avgRating;

    private Long quantityRating;

    public RatingInfo(Double avgRating, Long quantityRating) {
        this.avgRating = avgRating;
        this.quantityRating = quantityRating;
    }

    public Double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(Double avgRating) {
        this.avgRating = avgRating;
    }

    public Long getQuantityRating() {
        return quantityRating;
    }

    public void setQuantityRating(Long quantityRating) {
        this.quantityRating = quantityRating;
    }

    @Override
    public String toString() {
        return "RatingInfo{" +
                "avgRating=" + avgRating +
                ", quantityRating=" + quantityRating +
                '}';
    }
}
