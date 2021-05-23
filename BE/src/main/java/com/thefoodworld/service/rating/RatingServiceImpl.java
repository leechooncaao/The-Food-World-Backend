package com.thefoodworld.service.rating;

import com.thefoodworld.model.Rating;
import com.thefoodworld.repository.AccountRepository;
import com.thefoodworld.repository.FoodRepository;
import com.thefoodworld.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RatingServiceImpl implements RatingService{
    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private AccountRepository accountRepository;


    @Override
    public Rating addNewRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public Rating getRatingByFoodIdAndAccountId(Integer foodId, Integer accountId) {
        return ratingRepository.findByFood_FoodIdAndAccount_AccountId(foodId, accountId);
    }

    @Override
    public Rating updateRating(Rating rating) {
        return ratingRepository.save(rating);
    }
}
