package io.javabrain.movieinfoservice.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrain.movieinfoservice.models.Movie;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/movies")
@Slf4j
public class MovieInfoResource {

    @GetMapping(value = "/{movieId}")
    public Movie getMovie(@PathVariable(name = "movieId") String movieId) {
        log.error("Othe movie about a fish");
        return new Movie("1", "Nemo");
    }

}
