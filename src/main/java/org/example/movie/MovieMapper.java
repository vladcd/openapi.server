package org.example.movie;

import java.util.List;

import org.example.rest.model.MovieDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @author <a href="vladc@ext.inditex.com">VLADC</a>
 */
@Mapper
public interface MovieMapper {

    List<MovieDTO> toMovieDTOList(List<Movie> movies);

    @Mappings(
        @Mapping(source = "ratings", target = "rating")
    )
    MovieDTO toMovieDTO(Movie movie);

    Movie toMovie(MovieDTO movieDTO);

    default Double average(List<Double> doubles) {
        return doubles.stream()
            .mapToDouble(item -> item)
            .average()
            .orElse(0);
    }
}
