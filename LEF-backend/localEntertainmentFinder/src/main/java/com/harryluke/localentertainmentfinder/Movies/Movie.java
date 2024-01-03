package com.harryluke.localentertainmentfinder.Movies;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "movies")
public class Movie {

    private String title;
    private String description;

    public Movie(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Movie() {
    }

}
