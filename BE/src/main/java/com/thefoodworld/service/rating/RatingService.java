package com.thefoodworld.service.rating;

import com.thefoodworld.model.Rating;

public interface RatingService {
    Rating addNewRating(Rating rating);

    Rating getRatingByFoodIdAndAccountId(Integer foodId, Integer accountId);

    Rating updateRating(Rating rating);
}
