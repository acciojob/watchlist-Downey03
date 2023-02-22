package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public void addMovie(Movie movie){
        movieRepository.addMovie(movie);
    }
    public void addDirector(Director director){
        movieRepository.addDirector(director);
    }
    public void addMovieDirectorPair(String movieName,String directorName){
        movieRepository.addMovieDirectorPair(movieName,directorName);
    }
    public Movie getMovieByName(String movieName){
       return movieRepository.getMovieByName(movieName);
    }
    public Director getDirectorByName(String directorName){
       return movieRepository.getDirectorByName(directorName);
    }
    public List<Movie> getMoviesByDirectorName(String directorName){
        return movieRepository.getMoviesByDirectorName(directorName);
    }
    public List<Movie> findAllMovies(){
        return movieRepository.movies;
    }
    public void deleteDirectorByName(String directorName){
        movieRepository.deleteDirectorByName(directorName);
    }
    public void deleteAllDirectors(){
        movieRepository.deleteAllDirectors();
    }

}
