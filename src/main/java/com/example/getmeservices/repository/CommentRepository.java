package com.example.getmeservices.repository;


import com.example.getmeservices.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommentRepository extends MongoRepository<Comment, String> {

    List<Comment> findAllById(String id);

    List<Comment> findAllByPhotoId(String photoId);
}
