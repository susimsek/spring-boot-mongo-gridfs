package com.gridfs.springbootmongogridfs.repository;

import com.gridfs.springbootmongogridfs.model.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;

//repository sınıf oluşuturuldu
public interface PhotoRepository extends MongoRepository<Photo, String> { }
