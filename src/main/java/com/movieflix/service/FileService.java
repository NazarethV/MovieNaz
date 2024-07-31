package com.movieflix.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


public interface FileService {

    //Para cargar el archivo la propiedad necesita la DIRECCIÓN del archivo y el TIPO de archivo
    String uploadFile(String path, MultipartFile file) throws IOException;

    InputStream getResourceFile(String path, String name) throws FileNotFoundException;




}
