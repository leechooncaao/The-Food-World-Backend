package com.thefoodworld.repository;

import com.thefoodworld.model.Rating;
import com.thefoodworld.model.dto.RatingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {

    @Query(value = "select new com.thefoodworld.model.dto.RatingInfo(AVG(r.ratingLevel), count(r.account.accountId))\n" +
            "from Rating as r\n" +
            "where r.food.foodId = :foodId")
    List<RatingInfo> getRatingInfoByFoodId(@Param("foodId") Integer foodId);

    Rating findByFood_FoodIdAndAccount_AccountId(Integer foodId, Integer accountId);
}
