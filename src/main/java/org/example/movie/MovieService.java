package org.example.movie;

import java.util.List;

/**
 * @author <a href="vladc@ext.inditex.com">VLADC</a>
 */
public interface MovieService {

    List<Movie> findAll();

    Movie save(Movie movie);

    void rateMovie(Integer movieId, Integer rating);
}
