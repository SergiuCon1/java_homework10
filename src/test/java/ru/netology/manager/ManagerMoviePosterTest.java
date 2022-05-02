package ru.netology.manager;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.Movie;
import ru.netology.repository.RepositoryMoviePoster;

import static org.junit.jupiter.api.Assertions.*;

class ManagerMoviePosterTest {

    Movie first = new Movie(0, "Бладшот", "Боевик");
    Movie second = new Movie(1, "Вперёд", "Мультфильм");
    Movie third = new Movie(2, "Отель'Белград'", "Комедия");
    Movie fourth = new Movie(3, "Джентельмены", "Боевик");
    Movie fifth = new Movie(4, "Человек-неведимка", "Ужасы");
    Movie sixth = new Movie(5, "Тролли.Мировой тур", "Мультфильм");
    Movie seventh = new Movie(6, "Номер один", "Комедия");


    @Test
    @DisplayName("Проверка пустой корзины при создании менеджера")
    void shouldGetZeroMovies() {
        ManagerMoviePoster poster = new ManagerMoviePoster();

        Movie[] expected = {};
        Movie[] actual = poster.findAll();

        assertArrayEquals(expected, actual);

    }

    @Test
    @DisplayName("Добавление одного фильма в корзину и вывод в порядке добавления")
    void shouldAddOneMovie() {
        ManagerMoviePoster poster = new ManagerMoviePoster();

        poster.addMovie(first);

        Movie[] expected = {first};
        Movie[] actual = poster.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Добавление нескольких фильмов в корзину и вывод в порядке добавления")
    void shouldAddSeveralMovies() {
        ManagerMoviePoster poster = new ManagerMoviePoster();

        poster.addMovie(first);
        poster.addMovie(second);
        poster.addMovie(third);
        poster.addMovie(fourth);
        poster.addMovie(fifth);
        poster.addMovie(sixth);
        poster.addMovie(seventh);

        Movie[] expected = {first, second, third, fourth, fifth, sixth, seventh};
        Movie[] actual = poster.findAll();

        assertArrayEquals(expected, actual);
    }


    @DisplayName("Удаление фильма по id")
    @Test
    void shouldRemoveMovieById() {
        ManagerMoviePoster repo = new ManagerMoviePoster();
        repo.addMovie(first);
        repo.addMovie(second);
        repo.addMovie(third);
        repo.addMovie(fourth);
        repo.addMovie(fifth);
        repo.addMovie(sixth);
        repo.addMovie(seventh);

        repo.removeById(4);

        Movie[] expected = {first, second, third, fourth, sixth, seventh};
        Movie[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @DisplayName("Ищет фильм по id, когда он существует")
    @Test
    void shouldFindByIdWhenExist() {
        ManagerMoviePoster repo = new ManagerMoviePoster();
        repo.addMovie(first);
        repo.addMovie(second);
        repo.addMovie(third);
        repo.addMovie(fourth);
        repo.addMovie(fifth);
        repo.addMovie(sixth);
        repo.addMovie(seventh);

        repo.findById(6);

        Movie[] expected = {seventh};
        Movie[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @DisplayName("Ищет фильм по id, когда его не существует")
    @Test
    void shouldFindByIdWhenNotExist() {
        ManagerMoviePoster repo = new ManagerMoviePoster();
        repo.addMovie(first);
        repo.addMovie(second);
        repo.addMovie(third);
        repo.addMovie(fourth);
        repo.addMovie(fifth);
        repo.addMovie(sixth);
        repo.addMovie(seventh);

        repo.findById(10);

        Movie[] expected = {null};
        Movie[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @DisplayName("Удаляет все фильмы")
    @Test
    void shouldRemoveAll() {
        ManagerMoviePoster repo = new ManagerMoviePoster();
        repo.addMovie(first);
        repo.addMovie(second);
        repo.addMovie(third);
        repo.addMovie(fourth);
        repo.addMovie(fifth);
        repo.addMovie(sixth);
        repo.addMovie(seventh);

        repo.removeAll();

        Movie[] expected = {};
        Movie[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }
}