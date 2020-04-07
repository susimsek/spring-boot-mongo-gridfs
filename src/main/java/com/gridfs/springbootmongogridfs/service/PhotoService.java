package com.gridfs.springbootmongogridfs.service;

import com.gridfs.springbootmongogridfs.model.Photo;
import com.gridfs.springbootmongogridfs.repository.PhotoRepository;
import lombok.RequiredArgsConstructor;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

//PhotoServis tanımlandı
@Service
@RequiredArgsConstructor
public class PhotoService {

    //photoRepository inject edildi
    private final PhotoRepository photoRepository;
 
    public String addPhoto(String title, MultipartFile file) throws IOException {
        Photo photo = new Photo(title);//başlık atandı
        Binary binary = new Binary(BsonBinarySubType.BINARY, file.getBytes());//resim binaryye çevrildi
        photo.setImage(binary);
        photo = photoRepository.save(photo);//fotoğrf kaydedildi
        return photo.getId();//id dönüldü
    }
 
    public Photo getPhoto(String id) { 
        return photoRepository.findById(id).get(); //idsi verilen resim dönüldü
    }
}