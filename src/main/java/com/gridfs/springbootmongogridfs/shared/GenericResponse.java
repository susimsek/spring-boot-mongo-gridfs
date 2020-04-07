package com.gridfs.springbootmongogridfs.shared;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class GenericResponse {

    @NonNull
    private String message;
}
