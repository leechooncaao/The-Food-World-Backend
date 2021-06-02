package com.thefoodworld.repository;

import com.thefoodworld.model.Comment;
import com.thefoodworld.model.dto.CommentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Query(value ="select new com.thefoodworld.model.dto.CommentDTO(c.commentId, c.commentContent, c.commentImage, c.food.foodId, c.account.accountId, c.commentTime, r.ratingLevel, cus.customerAvatar, cus.customerName)\n" +
            "from Comment as c\n" +
            "JOIN Rating r ON c.food.foodId = r.food.foodId AND c.account.accountId = r.account.accountId\n" +
            "JOIN Customer cus ON c.account.accountId = cus.customerId\n" +
            "where c.food.foodId = :foodId\n" +
            "order by c.commentTime desc")
    List<CommentDTO> getListCommentByFoodId(@Param("foodId") Integer foodId);


}
