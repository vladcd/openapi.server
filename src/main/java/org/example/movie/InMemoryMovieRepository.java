package org.example.movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Component;

/**
 * @author <a href="vladc@ext.inditex.com">VLADC</a>
 */
@Component
public class InMemoryMovieRepository implements MovieRepository {

    private final Map<Integer, Movie> moviesMap = new HashMap<>();

    public InMemoryMovieRepository() {
        moviesMap.put(1, Movie.builder()
            .id(1)
            .name("Sherlock")
            .actors(Collections.singletonList("Benedict Cumberbatch"))
            .build());
    }

    @Override
    public List<Movie> findAll() {
        return new ArrayList<>(moviesMap.values());
    }

    @Override
    public Movie save(Movie movie) {
        if (movie.getId() == null) {
            // new movie
            Integer newId = moviesMap.keySet().stream()
                .mapToInt(key -> key)
                .max()
                .orElse(0) + 1;
            movie.setId(newId);
        }
        moviesMap.put(movie.getId(), movie);
        return movie;
    }

    @Override
    public Optional<Movie> get(Integer id) {
        return Optional.ofNullable(moviesMap.get(id));
    }
}
