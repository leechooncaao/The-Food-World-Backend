package com.thefoodworld.service.rating;

import com.thefoodworld.model.Rating;
import com.thefoodworld.model.dto.RatingInfo;

public interface RatingService {
    Rating addOrUpdateRating(Rating rating);

    Rating getRatingByFoodIdAndAccountId(Integer foodId, Integer accountId);

    RatingInfo getRatingInfoByFoodId(Integer foodId);
}
