package com.movieflix.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

//ENTIDAD CON SUS RESPECTIVAS PROPIEDADES
// (y Validaciones de las mismas)

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieId;

    //No puede ser false, y tiene que tener una longitud de 200 carácteres por ejemplo
    @Column(nullable = false, length = 200)
    @NotBlank(message = "Please provide movie´s title") //Se puede pasar un mensaje también
    private String title;

    private String director;

    private String studio;

    private Set<String> movieCast;

    private Integer realeaseYear;

    private String poster;
}
