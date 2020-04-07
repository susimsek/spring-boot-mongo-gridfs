package com.gridfs.springbootmongogridfs.service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service//Servis tanımladık
@RequiredArgsConstructor
public class FileUploadService {

    //GridFsTemplate sınıfını çağırdık
    //Dosyamızın byte halini tutuyoruz
    private final GridFsTemplate gridFsTemplate;

    //apiden gelen MultipartFile yi ilettik
    public void uploadFile(MultipartFile file) throws IOException {
        DBObject dbObject = new BasicDBObject();//map gibi değer atayabilitoruz
        dbObject.put("fileName",file.getOriginalFilename());
        dbObject.put("contentType",file.getContentType());
        dbObject.put("size",file.getSize());
        dbObject.put("userId","12345");
        //file.getInputStream() yüklenen datanın byte datasını verir
        //dbobjectdeki verileri dbye gönderdik
        //filenameyide gönderdik
        ObjectId id= gridFsTemplate.store(file.getInputStream(),file.getOriginalFilename(),dbObject);//kaydedilen dosyanın idsini dönderir
        System.out.println(id.toString());//idyi tetminale yazdırdık
    }
}
