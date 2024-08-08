package com.movieflix.service;

import com.movieflix.dto.MovieDto;
import com.movieflix.entities.Movie;
import com.movieflix.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{

    //INYECCIÓN CREO:

    //Para la Base de datos
    private final MovieRepository movieRepository;

    private final FileService fileService;

    @Value("${project.poster}") //HACE REFERENCIA A LA RUTA "/POSTER" DEFINIDA EN EL ARCHIVO .YML !!!!!!!!!!
    private String path;

    @Value("${base.url}")  //Trae la variable de .yml
    private String baseUrl;

    //Parámetro del constructor (MovieRepository) y (FileService)
    public MovieServiceImpl(MovieRepository movieRepository, FileService fileService) {
        this.movieRepository = movieRepository;
        this.fileService = fileService;
    }


    @Override
    public MovieDto addMovie(MovieDto movieDto, MultipartFile file) throws IOException {
        //1. upload the file  (Para cargar el archivo primero hay que traer el servicio de archivos (FileService))
        String uploadedFileName = fileService.uploadFile(path, file);  //Proporcionamos una ruta y un archivo  (por eso más arriba declaramos path, para poder utilizar la ruta)

        //2. set the value of field 'poster' as filename
        movieDto.setPoster(uploadedFileName); //Establecer el nombre del archivo / el valor del campo filename (nombre de archivo)

        //3. map dto to Movie object   (Para guardar los datos en la base de datos tenemos un Repository de películas que acepta un objeto de clase movie por o que necesitamos mapear el objeto )
        //Asignar el objeto DTO al objeto película
        Movie movie = new Movie(  //Creamos un Objet Movie
                null,
                //Gracias al Constructor de Movie, podemos crear un constructor acá: -->
                movieDto.getTitle(),
                movieDto.getDirector(),
                movieDto.getStudio(),
                movieDto.getMovieCast(),
                movieDto.getReleaseYear(),
                movieDto.getPoster()
        );


        //4. save the movie object -> saved Movie object     (Guardar el Objeto Movie y devolverá ese objeto guardado)   (Devolver la película DTO (la guardada) cómo objeto de respuesta
        Movie savedMovie = movieRepository.save(movie);  //Q el repositorio guarde la Película en la base de datos y devolverá ese objeto movie guardado


        //5. generate the posterURL       (Debemos generar la URL correspondiente al 'poster' cómo agregamos en la entidad la propiedad URL en poster
        //Antes de enviar la respuesta, necesitamos hacer una url para el poster
        String posterUrl = baseUrl + "/file/" + uploadedFileName;

        //(En .yml agregamos una variable de entorno: base: url:"http://localhost:8080") y recuperamos esa variable en este archivo más arriba
        //       ( http://localhost:8080/file/fileName )


        //6. map Movie object to DTO object and return it  (mapear objeto Movie a objeto DTO y devolverlo)
       //GENERAMOS LA RESPUESTA (lo que va a devolver addMovie)
        MovieDto response = new MovieDto(
                savedMovie.getMovieId(),
                savedMovie.getTitle(),
                savedMovie.getDirector(),
                savedMovie.getStudio(),
                savedMovie.getMovieCast(),
                savedMovie.getReleaseYear(),
                savedMovie.getPoster(),
                posterUrl
        );

        return response;
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
