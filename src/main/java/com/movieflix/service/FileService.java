package com.movieflix.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


public interface FileService {
    //2 MÉTODOS PARA MANIPULAR LOS ARCHIVOS (Cargar el archivo y

    //Para cargar el archivo la propiedad necesita la DIRECCIÓN del archivo y el TIPO de archivo
    String uploadFile(String path, MultipartFile file) throws IOException;

    //Necesitamos entregar el archivo, y para entregarlo no podemos tomar el archivo directamente. Por lo que necesitamos convertir el archivo a las secuencias o a los bytes
    InputStream getResourceFile(String path, String name) throws FileNotFoundException;




}
