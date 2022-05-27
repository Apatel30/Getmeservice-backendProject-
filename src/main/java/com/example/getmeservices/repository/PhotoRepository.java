package com.example.getmeservices.repository;




import com.example.getmeservices.model.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PhotoRepository extends MongoRepository<Photo, String> {

    List<Photo> findAllById(String id);

    List<Photo> findPhotosByAlbumId(String albumId);
}
