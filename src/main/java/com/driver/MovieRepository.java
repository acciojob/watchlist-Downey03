package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

@Repository
public class MovieRepository {
    List<Movie> movies ;
    List<Director> directors ;
    HashMap<String, ArrayList<Movie>> pair ;

    public MovieRepository() {
        this.movies = new ArrayList<>();
        this.directors = new ArrayList<>();
        this.pair = new HashMap<>();
    }

    public void addMovie(Movie movie) {
        if (!movies.contains(movie)) movies.add(movie);
    }

    public void addDirector(Director director) {
        if (!directors.contains(director)) directors.add(director);
    }

    public void addMovieDirectorPair(String movieName, String directorName) {
        for (Movie movie : movies) {
            if (movie.getName().equals(movieName)) {
                Movie pairMovie = movie;
                if (pair.containsKey(directorName)) pair.get(directorName).add(pairMovie);
                else {
                    ArrayList<Movie> newList = new ArrayList<>();
                    newList.add(pairMovie);
                    pair.put(directorName, newList);
                }
                for(Director director : directors){
                    if(director.getName().equals(directorName)) director.setNumberOfMovies(pair.get(directorName).size());
                }
                break;
            }

        }

    }

    public Movie getMovieByName(String movieName) {
        for (Movie movie : movies) {
            if (movie.getName().equals(movieName)) {
                return movie;
            }
        }
        return null;
    }
    public Director getDirectorByName(String directorName){
        for (Director director : directors) {
            if (director.getName().equals(directorName)) {
                return director;
            }
        }
        return null;
    }
    public List<String> getMoviesByDirectorName(String directorName){
        if(!pair.containsKey(directorName)) return null;
        List<Movie> directed = pair.get(directorName);
        List<String> name = new ArrayList<>();
        for(Movie movie : movies){
            name.add(movie.getName());
        }
        return name;
    }
    public List<String> findAllMovies(){

        List<String> name = new ArrayList<>();
        for(Movie movie : movies){
            name.add(movie.getName());
        }
        return name;
    }
    public void deleteDirectorByName(String directorName){
        ArrayList<Movie> pairMovie = pair.get(directorName);
        for(Movie movie: pairMovie){
            movies.remove(movie);
        }
        pair.remove(directorName);
        directors.remove(directorName);
    }
    public void deleteAllDirectors(){
        for(String directorName: pair.keySet()){
            ArrayList<Movie> pairMovie = pair.get(directorName);
            for(Movie movie: pairMovie){
                movies.remove(movie);
            }
        }
    }
}
