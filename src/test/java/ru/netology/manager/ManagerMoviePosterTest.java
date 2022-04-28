package ru.netology.manager;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.Movie;

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

    @Test
    @DisplayName("Добавление одного фильма в корзину и вывод в обратном от добавления порядке")
    void shouldGetOneMoviesReverseOrder() {
        ManagerMoviePoster poster = new ManagerMoviePoster();

        poster.addMovie(third);

        Movie[] expected = {third};
        Movie[] actual = poster.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Добавление нескольких фильмов в корзину и вывод в обратном от добавления порядке")
    void shouldGetSeveralMoviesReverseOrder() {
        ManagerMoviePoster poster = new ManagerMoviePoster();

        poster.addMovie(first);
        poster.addMovie(second);

        Movie[] expected = {second, first};
        Movie[] actual = poster.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Добавление более трёх фильмов в корзину и вывод трёх фильмов в обратном от добавления порядке")
    void shouldGetThreeMoviesWhenAddedMoreThanThreeReverseOrder() {
        ManagerMoviePoster poster = new ManagerMoviePoster();

        poster.addMovie(first);
        poster.addMovie(second);
        poster.addMovie(third);
        poster.addMovie(fourth);

        Movie[] expected = {fourth, third, second};
        Movie[] actual = poster.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Добавление трёх фильмов в корзину и вывод трёх фильмов в обратном от добавления порядке")
    void shouldGetThreeMoviesWhenAddedThreeMoviesReverseOrder() {
        ManagerMoviePoster poster = new ManagerMoviePoster();

        poster.addMovie(first);
        poster.addMovie(second);
        poster.addMovie(third);

        Movie[] expected = {third, second, first};
        Movie[] actual = poster.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Добавление четырёх фильмов в корзину и вывод четырёх фильмов в обратном от добавления порядке")
    void shouldGetFourMoviesWhenLimitIsFiveReverseOrder() {
        ManagerMoviePoster poster = new ManagerMoviePoster(5);

        poster.addMovie(first);
        poster.addMovie(second);
        poster.addMovie(third);
        poster.addMovie(fourth);

        Movie[] expected = {fourth, third, second, first};
        Movie[] actual = poster.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Добавление пяти фильмов в корзину и вывод пяти в обратном от добавления порядке")
    void shouldGetFiveMoviesWhenLimitIsFiveReverseOrder() {
        ManagerMoviePoster poster = new ManagerMoviePoster(5);

        poster.addMovie(first);
        poster.addMovie(second);
        poster.addMovie(third);
        poster.addMovie(fourth);
        poster.addMovie(fifth);


        Movie[] expected = {fifth, fourth, third, second, first};
        Movie[] actual = poster.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Добавление более пяти фильмов в корзину и вывод пяти фильмов в обратном от добавления порядке")
    void shouldGetFiveMoviesWhenAddedMoreThanFiveReverseOrder() {
        ManagerMoviePoster poster = new ManagerMoviePoster(5);

        poster.addMovie(first);
        poster.addMovie(second);
        poster.addMovie(third);
        poster.addMovie(fourth);
        poster.addMovie(fifth);
        poster.addMovie(sixth);
        poster.addMovie(seventh);

        Movie[] expected = {seventh, sixth, fifth, fourth, third};
        Movie[] actual = poster.findLast();

        assertArrayEquals(expected, actual);
    }
}