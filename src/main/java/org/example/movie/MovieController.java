package org.example.movie;

import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import org.example.rest.api.MoviesApi;
import org.example.rest.model.MovieDTO;

/**
 * @author <a href="vladc@ext.inditex.com">VLADC</a>
 */
@RestController("/movies")
public class MovieController implements MoviesApi {

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieMapper movieMapper;

    @Override
    public ResponseEntity<List<MovieDTO>> getMovies() {
        return ResponseEntity.ok(movieMapper.toMovieDTOList(
            movieService.findAll()
        ));
    }

    @Override
    public ResponseEntity<MovieDTO> addNewMovie(@Valid MovieDTO movieDTO) {
        return ResponseEntity.ok(movieMapper.toMovieDTO(
            movieService.save(movieMapper.toMovie(movieDTO))
        ));
    }

    @Override
    public ResponseEntity<Void> rateMovie(Integer id, Integer value) {
        movieService.rateMovie(id, value);
        return ResponseEntity.ok(null);
    }
}
