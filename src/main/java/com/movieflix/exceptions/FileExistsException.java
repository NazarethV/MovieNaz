package com.movieflix.exceptions;

//Para addMovie
public class FileExistsException extends RuntimeException{
    public FileExistsException(String message){
        super(message);
    }
}
