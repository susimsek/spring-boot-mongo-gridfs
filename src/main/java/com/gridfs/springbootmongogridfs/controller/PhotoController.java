package com.gridfs.springbootmongogridfs.controller;

import com.gridfs.springbootmongogridfs.service.PhotoService;
import com.gridfs.springbootmongogridfs.shared.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class PhotoController {

    //photo servis çağrıldı
    private final PhotoService photoService;


    @PostMapping("/api/v1/photos")
    public ResponseEntity<?> addPhoto(@RequestParam("title") String title,
                           @RequestParam("image") MultipartFile image) throws IOException {
        String id = photoService.addPhoto(title, image);
        GenericResponse response= new GenericResponse("photo uploaded : " +id);//mesaj dönüldü
        return ResponseEntity.status(HttpStatus.CREATED).body(response);//201 statusu ile bilgilendirme mesajı dönüldü
    }


}
