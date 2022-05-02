package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.Movie;
import ru.netology.repository.RepositoryMoviePoster;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ManagerMoviePoster {
    private RepositoryMoviePoster repository = new RepositoryMoviePoster();

    public ManagerMoviePoster(RepositoryMoviePoster repository) {
        this.repository = repository;
    }

    Movie[] movies = new Movie[0];

    public void addMovie(Movie mov) {
        repository.addMovie(mov);
    }

    public Movie[] findAll() {
        return repository.findAll();
    }

    public void removeById(int idMovie) {
        repository.removeById(idMovie);
    }

    public void findById(int id) {
        repository.findById(id);
    }

    public void removeAll() {
        repository.removeAll();
    }
}
