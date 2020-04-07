package com.gridfs.springbootmongogridfs.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//Basit bir document tipinde class oluşturduk.
@Document(collection = "photos")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Photo {
    @Id
    private String id;

    @NonNull
    private String title;
         
    private Binary image;//imageyi bson binary formatında tutuyoruz.
}