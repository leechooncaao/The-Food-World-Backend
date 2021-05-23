package com.thefoodworld.service.comment;

import com.thefoodworld.model.Comment;
import com.thefoodworld.model.dto.CommentDTO;

import java.util.List;

public interface CommentService {
    List<CommentDTO> getAllCommentByFoodId(Integer foodId);

    Comment createOrUpdateComment(Comment comment);

    Comment getCommentById(Integer commentId);

    void removeCommentById(Integer commentId);
}
