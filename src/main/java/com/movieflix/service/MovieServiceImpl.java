package com.movieflix.service;

import com.movieflix.dto.MovieDto;
import com.movieflix.repositories.MovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{

    //INYECCIÓN CREO:

    //Para la Base de datos
    private final MovieRepository movieRepository;

    //Parámetro del constructor (MovieRepository)
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    @Override
    public MovieDto addMovie(MovieDto movieDto, MultipartFile file) {
        //1. upload the file

        //2. set the value of field 'poster' as filename

        //3. map dto to Movie object   (Para guardar los datos en la base de datos tenemos un Repository de películas que acepta un objeto de clase movie por o que necesitamos mapear el objeto )

        //4. save the movie object -> saved Movie object     (Guardar el Objeto Movie y devolverá ese objeto guardado)   (Devolver la película DTO (la guardada) cómo objeto de respuesta

        //5. generate the posterURL       (Debemos generar la URL correspondiente al 'poster' cómo agregamos en la entidad la propiedad URL en poster

        //6. map Movie object to DTO object and return it  (mapear objeto Movie a objeto DTO y devolverlo)

        return null;
    }

    @Override
    public MovieDto getMovie(Integer movieId) {
        return null;
    }

    @Override
    public List<MovieDto> getAllMovies() {
        return List.of();
    }
}
