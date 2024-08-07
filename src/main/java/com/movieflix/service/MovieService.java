package com.movieflix.service;

import com.movieflix.dto.MovieDto;
import org.springframework.web.multipart.MultipartFile;

public interface MovieService {

    MovieDto addMovie(MovieDto movieDto, MultipartFile file);
}
