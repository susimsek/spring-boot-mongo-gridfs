package com.gridfs.springbootmongogridfs.controller;

import com.gridfs.springbootmongogridfs.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
    @PostMapping("/api/v1/upload")
    public void fileUpload(@RequestParam MultipartFile file) throws IOException {
        fileUploadService.uploadFile(file);

    }
}
