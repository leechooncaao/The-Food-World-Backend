package com.thefoodworld.service.comment;

import com.thefoodworld.model.Comment;
import com.thefoodworld.model.dto.CommentDTO;
import com.thefoodworld.repository.CommentRepository;
import com.thefoodworld.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public List<CommentDTO> getAllCommentByFoodId(Integer foodId) {
        return commentRepository.getListCommentByFoodId(foodId);
    }
}
