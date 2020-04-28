package org.example.movie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.example.exception.NotFoundException;

/**
 * @author <a href="vladc@ext.inditex.com">VLADC</a>
 */
@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public void rateMovie(Integer movieId, Integer rating) {
        Movie movie = movieRepository.get(movieId).orElseThrow(() -> new NotFoundException());
        movie.addRating(rating.doubleValue());
    }
}
