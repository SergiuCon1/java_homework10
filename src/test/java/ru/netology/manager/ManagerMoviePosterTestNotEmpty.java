package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.Movie;
import ru.netology.repository.RepositoryMoviePoster;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

class ManagerMoviePosterTestNotEmpty {

    private RepositoryMoviePoster repository = Mockito.mock(RepositoryMoviePoster.class);

    private ManagerMoviePoster manager = new ManagerMoviePoster(repository);
    private Movie first = new Movie(0, "Бладшот", "Боевик");
    private Movie second = new Movie(1, "Вперёд", "Мультфильм");
    private Movie third = new Movie(2, "Отель'Белград'", "Комедия");
    private Movie fourth = new Movie(3, "Джентельмены", "Боевик");

    private Movie fifth = new Movie(4, "Человек-неведимка", "Ужасы");
    private Movie sixth = new Movie(5, "Тролли.Мировой тур", "Мультфильм");
    private Movie seventh = new Movie(6, "Номер один", "Комедия");

    @Test
    public void shouldRemoveById() {
        //Настройка заглушки
        Movie[] returned = {first, second, third, fourth, sixth, seventh};
        doReturn(returned).when(repository).findAll();

        Movie[] expected = {first, second, third, fourth, sixth, seventh};
        Movie[] actual = manager.findAll();

        assertArrayEquals(expected, actual);

        // удостоверяемся, что заглушка была вызвана
        // но это уже проверка внутренней реализации
        verify(repository).findAll();
    }

    @Test
    public void shouldFindById() {
        //Настройка заглушки
        Movie[] returned = {seventh};
        doReturn(returned).when(repository).findAll();

        Movie[] expected = {seventh};
        Movie[] actual = manager.findAll();

        assertArrayEquals(expected, actual);

        // удостоверяемся, что заглушка была вызвана
        // но это уже проверка внутренней реализации
        verify(repository).findAll();
    }
}