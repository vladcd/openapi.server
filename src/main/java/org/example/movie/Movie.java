package org.example.movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author <a href="vladc@ext.inditex.com">VLADC</a>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {

    private Integer id;
    private String name;
    private String director;
    private List<String> actors;
    private List<Double> ratings;

    public List<String> getActors() {
        return Optional.ofNullable(actors).orElse(new ArrayList<>());
    }

    public List<Double> getRatings() {
        return Optional.ofNullable(ratings).orElse(new ArrayList<>());
    }

    public void addRating(Double rating) {
        if (ratings == null) {
            ratings = new ArrayList<>();
        }
        ratings.add(rating);
    }
}
