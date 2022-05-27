package com.example.getmeservices.resource;

import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.model.S3Object;
import com.example.getmeservices.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping("/api/files")
public class FileResource {

    @Autowired
    private FileService fileService;

    @CrossOrigin
    @PostMapping("/upload")
    public boolean upload(@RequestParam(name = "file")MultipartFile file) throws IOException {
        return fileService.upload(file);
    }
    //@PostMapping
    //public boolean upload(@RequestParam(name = "file") MultipartFile file ){
        //return  fileService.upload(file);
    //}
    @CrossOrigin
    @GetMapping("/view")
    public void view(@RequestParam(name = "key") String key, HttpServletResponse response) throws IOException {
        S3Object object= fileService.getFile(key);
        response.setContentType(object.getObjectMetadata().getContentType());
        response.getOutputStream().write(object.getObjectContent().readAllBytes());
    }
    @CrossOrigin
    @GetMapping("/download")
    public ResponseEntity<ByteArrayResource> download(@RequestParam(name = "key") String key) throws IOException {
        S3Object object = fileService.getFile(key);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(object.getObjectMetadata().getContentType()))
                .header(Headers.CONTENT_DISPOSITION, "attachment; filename=\"" + key + "\"")
                .body(new ByteArrayResource(object.getObjectContent().readAllBytes()));
    }
    @DeleteMapping
    public void delete(@RequestParam(name = "key") String key){
        fileService.deleteFile(key);
    }

}
