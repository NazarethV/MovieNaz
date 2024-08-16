package com.movieflix.exceptions;

public class FileExistsException extends RuntimeException{
    public FileExistsException(String message){
        super(message);
    }
}

@ExceptionHandler(EmptyFileException.class)
public ProblemDetail handleEmptyFileException(EmptyFileException ex) {
    return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
}