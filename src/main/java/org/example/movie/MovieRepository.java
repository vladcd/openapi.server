package org.example.movie;

import java.util.List;
import java.util.Optional;

/**
 * @author <a href="vladc@ext.inditex.com">VLADC</a>
 */
public interface MovieRepository {

    List<Movie> findAll();

    Movie save(Movie movie);

    Optional<Movie> get(Integer id);

}
