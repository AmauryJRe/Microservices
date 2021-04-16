package io.javabrain.moviecatalogservice.resources;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.javabrain.moviecatalogservice.models.CatalogItem;
import io.javabrain.moviecatalogservice.models.Movie;
import io.javabrain.moviecatalogservice.models.Rating;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/catalog")
@Slf4j
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable(name = "userId") String userId) {
        log.error("The fish: " + userId);

        List<Rating> ratings = Arrays.asList(
            new Rating("123", 4),
            new Rating("345", 4)
        );

        return ratings.stream().map(rating->{
           Movie movie =   restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
            return new CatalogItem(movie.getName(), "A move about a fish", rating.getRating());
        }).collect(Collectors.toList() );
        // return Collections.singletonList(new CatalogItem("Aquaman", "A move about a fish", 4));
    }
}
