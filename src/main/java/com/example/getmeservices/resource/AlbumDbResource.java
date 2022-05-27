package com.example.getmeservices.resource;


import com.example.getmeservices.model.Album;
import com.example.getmeservices.model.AlbumDb;
import com.example.getmeservices.model.FirebaseUser;
import com.example.getmeservices.model.Photo;
import com.example.getmeservices.service.AlbumDbService;
import com.example.getmeservices.service.FirebaseService;
import com.example.getmeservices.service.PhotoService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

//this annotation applied to a class as request handler, it's used to create Restful web services using spring MVC.
@RestController
@CrossOrigin
@RequestMapping("/api/albumsDb")
public class AlbumDbResource {

    @Autowired
    private AlbumDbService albumService;

    @Autowired
    private FirebaseService firebaseService;

    @Autowired
    public PhotoService photoService;

    @CrossOrigin
    @PostMapping
    public AlbumDb saveAlbums(@RequestHeader(name ="idToken") String idToken, @RequestBody @Valid AlbumDb albumDb) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);

        if(firebaseUser!= null) {
            return albumService.saveAlbums(albumDb);
        }
        return null;
    }


    //Get all Albums
    @CrossOrigin
    @GetMapping
    public List<AlbumDb> getAllAlbums(@RequestHeader(name ="idToken") String idToken) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);

        if(firebaseUser!= null){
            return albumService.getAllAlbums();
        }
        return null;
    }

    //Get photoes by AlbumID
    @GetMapping("{albumId}/photos")
    @CrossOrigin
    public List<Photo> getPhotosOfAlbum(@PathVariable("albumId") String albumId,
                                        @RequestHeader(name = "idToken") String idToken) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if(firebaseUser!= null){
            return photoService.getPhotosOfAlbum(albumId);
        }
        return null;
    }

    //update album
    @PutMapping
    @CrossOrigin
    public AlbumDb updateAlbum(@RequestBody AlbumDb albumDb ){
        return albumService.updateAlbum(albumDb);
    }


    //update CoverPhoto
    @PutMapping("/{albumId}/coverPhoto")
    @CrossOrigin
    public AlbumDb updateCoverPhoto(@PathVariable("albumId") String albumId,
                                    @RequestParam("coverPhotoUrl") String coverPhotoUrl,
                                    @RequestHeader(name = "idToken") String idToken ) throws IOException, FirebaseAuthException {

        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        return albumService.updateCoverPhoto(coverPhotoUrl, albumId);

    }


    @GetMapping("/find-by-id")
    public List<AlbumDb> getById(@RequestParam(name = "id") String id){
        return albumService.getById(id);
    }


    @DeleteMapping
    public void deleteAlbum(@RequestParam(name= "albumId") String id){
         albumService.deleteAlbum(id);
    }



}
