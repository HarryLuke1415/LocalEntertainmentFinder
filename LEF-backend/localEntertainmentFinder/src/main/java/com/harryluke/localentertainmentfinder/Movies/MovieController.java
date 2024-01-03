package com.harryluke.localentertainmentfinder.Movies;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/movies")
    public ResponseEntity<?> getMovies() {
        return ResponseEntity.ok().body(movieService.getAllMovies());
    }

    @PostMapping("/movies/refresh")
    public ResponseEntity<?> refreshMovies() {

        return ResponseEntity.ok().body(movieService.refreshMovies());
    }

}
