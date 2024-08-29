package com.movieflix.entities;

import jakarta.persistence.*;
import java.util.Set;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

//ENTIDAD CON SUS RESPECTIVAS PROPIEDADES
// (y Validaciones de las mismas)

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieId;

    //No puede ser false, y tiene que tener una longitud de 200 carácteres por ejemplo
    @Column(nullable = false, length = 200)
    @NotBlank(message = "Please provide movie´s title") //No puede estar vacío, Se puede pasar un mensaje también
    private String title;

    @Column(nullable = false) //No es necesario agregar la longitud
    @NotBlank(message = "Please provide movie´s director") //Para que no esté vacio
    private String director;

    @Column(nullable = false) //No es necesario agregar la longitud
    @NotBlank(message = "Please provide movie´s studio") //Para que no esté vacio
    private String studio;

    @ElementCollection
    @CollectionTable(name = "movie_cast") //Nombramos a la tabla
    private Set<String> movieCast;

    @Column(nullable = false) //No es necesario agregar la longitud
    private Integer realeaseYear;

    @Column(nullable = false) //No es necesario agregar la longitud
    @NotBlank(message = "Please provide movie´s poster!") //Para que no esté vacio
    private String poster;
}
