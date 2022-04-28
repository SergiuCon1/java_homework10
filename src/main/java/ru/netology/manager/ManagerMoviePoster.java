package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.Movie;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ManagerMoviePoster {

    private int limitMovies = 3;
    private Movie mov;

    public ManagerMoviePoster(int limitMovies) {
        this.limitMovies = limitMovies;
    }

    Movie[] movies = new Movie[0];

    public ManagerMoviePoster(Movie mov) {
        this.mov = mov;
    }

    public void addMovie(Movie mov) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = mov;
        movies = tmp;
    }

    public Movie[] findAll() {
        return movies;
    }

    public Movie[] findLast() {
        int resultLength = movies.length;
        if (resultLength > limitMovies) {
            resultLength = limitMovies;
        } else {
            resultLength = resultLength;
        }
        Movie[] result = new Movie[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        movies = result;
        return movies;
    }
}
