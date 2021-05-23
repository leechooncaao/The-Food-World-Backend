package com.thefoodworld.service.comment;

import com.thefoodworld.model.Comment;
import com.thefoodworld.model.dto.CommentDTO;
import com.thefoodworld.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<CommentDTO> getAllCommentByFoodId(Integer foodId) {
        return commentRepository.getListCommentByFoodId(foodId);
    }

    @Override
    public Comment createOrUpdateComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment getCommentById(Integer commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    @Override
    public void removeCommentById(Integer commentId) {
        commentRepository.deleteById(commentId);
    }


}
