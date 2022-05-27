package com.example.getmeservices.repository;

import com.example.getmeservices.model.AlbumDb;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AlbumDbRepository extends MongoRepository<AlbumDb, String> {

    List<AlbumDb> findAllById(String id);



}
