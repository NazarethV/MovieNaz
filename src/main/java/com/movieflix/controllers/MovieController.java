package com.movieflix.controllers;

import com.movieflix.service.MovieService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {

    //Necesito el Service de Movies
    private final MovieService movieService;

    //Constructor del MovieService
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    //Controller q manejará la solicitud para Add/Agregar la Movie/Película a la Base de Datos
    @PostMapping("/add-movie")
}
