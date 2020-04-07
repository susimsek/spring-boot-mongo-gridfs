package com.gridfs.springbootmongogridfs.controller;

import com.gridfs.springbootmongogridfs.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

//rest controller tanımladık
@RestController
@RequiredArgsConstructor
///upload pathi üzerinden istek gelecek
public class FileUpload {

    //file upload servisi çağırdık
    private final FileUploadService fileUploadService;

    //MultipartFile spring webden geliyor.file alabilmek için gerekli
    @PostMapping("/api/v1/files")
    public void fileUpload(@RequestParam MultipartFile file) throws IOException {
        fileUploadService.uploadFile(file);

    }

    //dosyayı dbden alıp bodyde dönüyoruz
    @GetMapping("/api/v1/files/{id}")
    public ResponseEntity<?> getPhoto(@PathVariable String id) {
        Document document = fileUploadService.getFile(id);
        return ResponseEntity.ok(document);
    }
}
