package io.javabrain.ratingdataservice.resources;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrain.ratingdataservice.models.Rating;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/ratingsdata")
@Slf4j
public class RatingsResource {
    @GetMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId){
        log.error("Rating of the fish movie");
		return new Rating("1", 4);
	}
}
