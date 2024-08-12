package com.movieflix.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileServiceImpl implements FileService{


    @Override
    public String uploadFile(String path, MultipartFile file) throws IOException {

        //get name (necesitamos el nombre del archivo, porque necesitamos devolver eso)
        String fileName = file.getOriginalFilename();

        //to get the file path
        String filePath = path + File.separator + fileName;

        //create file object
        File f = new File(path);
        if(!f.exists()){
            f.mkdir();
        }

        //copy the file or upload file to the path              NO QUEREMOS QUE SE ELIMINEN LOS "ARCHIVOS" REPETIDOS ((Si los nombres de peliculas repetidos))
        Files.copy(file.getInputStream(), Paths.get(filePath); //, StandardCopyOption.REPLACE_EXISTING);

        return fileName;
    }


    @Override                                      //Nombre del archivo(en FileService también utilizamos filename para el nombre del archivo)
    public InputStream getResourceFile(String path, String filename) throws FileNotFoundException {
        String filePath = path + File.separator + filename;
        return new FileInputStream(filePath);
    }
}

