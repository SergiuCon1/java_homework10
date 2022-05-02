package ru.netology.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.Movie;

import java.util.Arrays;

public class RepositoryMoviePoster {
    Movie[] movies = new Movie[0];

    public RepositoryMoviePoster() {

    }

    public RepositoryMoviePoster(Movie[] movies) {
        this.movies = movies;
    }

    public Movie[] findAll() {
        return movies;
    }

    public void addMovie(Movie mov) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = mov;
        movies = tmp;
    }

    public void removeById(int id) {
        int length = movies.length - 1;
        Movie[] exist = new Movie[length];
        int index = 0;
        for (Movie movie : movies) {
            if (movie.getIdMovie() != id) {
                exist[index] = movie;
                index++;
            }
            movies = exist;
        }
    }
    public void findById(int id) {
        int length = 0;
        Movie[] tmp = new Movie[length + 1];
        int index = 0;
        for (Movie movie : movies) {
            if (movie.getIdMovie() == id) {
                tmp[index] = movie;
            }
        }
        if (tmp == null) {
            tmp = null;
        }
        movies = tmp;
    }

    public void removeAll() {
        Movie[] remove = new Movie[0];
        movies = remove;
    }
}
