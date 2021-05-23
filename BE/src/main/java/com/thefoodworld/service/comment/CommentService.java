package com.thefoodworld.service.comment;

import com.thefoodworld.model.dto.CommentDTO;

import java.util.List;

public interface CommentService {
    List<CommentDTO> getAllCommentByFoodId(Integer foodId);
}
