package com.example.getmeservices.service;

import com.example.getmeservices.model.Photo;
import com.example.getmeservices.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class PhotoService {

    @Autowired
    private PhotoRepository photoRepository;


    @PostMapping
    public Photo savePhoto(Photo photo) {
        return photoRepository.save(photo);
    }

    public List<Photo> getAllPhotos() {
        return photoRepository.findAll();
    }

    public Photo updatePhoto(Photo photo) {
        return photoRepository.save(photo);
    }

    public void deletePhotos(String id) {
        photoRepository.deleteById(id);
    }

    public List<Photo> getPhotosOfAlbum(String albumId) {
        return photoRepository.findPhotosByAlbumId(albumId);
    }

    public List<Photo> getPhotoById(String id) {
        return photoRepository.findAllById(id);


    }
}
