package com.harryluke.localentertainmentfinder.Movies;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, String> {

}
