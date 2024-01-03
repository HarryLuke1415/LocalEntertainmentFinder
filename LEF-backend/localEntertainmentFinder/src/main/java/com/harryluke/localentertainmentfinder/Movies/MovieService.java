package com.harryluke.localentertainmentfinder.Movies;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import com.harryluke.localentertainmentfinder.WebScrapers.MovieScraper;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final MovieScraper movieScraper;

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public List<Movie> refreshMovies(){
        List<Movie> movies = movieScraper.scrape();
        clearMovies();
        movieRepository.saveAll(movies);
        return movieRepository.findAll();
    }

    public void clearMovies(){
        movieRepository.deleteAll();
    }



}
