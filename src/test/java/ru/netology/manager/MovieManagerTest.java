package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerTest {
    private MovieManager manager = new MovieManager();
    private Movie first = new Movie("1", "bloodshot", "thriller", "1");
    private Movie second = new Movie("2", "forward", "cartoon", "2");
    private Movie third = new Movie("3", "HotelBelgrad", "comedy", "3");
    private Movie fourth = new Movie("4", "Gentlemen", "actionMovie", "4");
    private Movie fifth = new Movie("5", "InvisibleMan", "horrors", "5");
    private Movie sixth = new Movie("6", "Trolls", "cartoon", "6");
    private Movie seventh = new Movie("7", "NumberOne", "comedy", "7");
    private Movie eighth = new Movie("8", "NumberTwo", "comedy", "8");
    private Movie ninth = new Movie("9", "NumberThree", "comedy", "9");
    private Movie tenth = new Movie("10", "NumberFour", "comedy", "10");

    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
    }

    @Test
    public void shouldAddMovie() {
        manager.add(tenth);
        Movie[] actual = manager.getAllMovies();
        Movie[] expected = new Movie[]{tenth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLast() {
        setUp();
        Movie[] actual = manager.getLastAdd();
        Movie[] expected = new Movie[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLastAdd() {
        MovieManager manager = new MovieManager(5);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        Movie[] actual = manager.getLastAdd();
        Movie[] expected = new Movie[]{tenth, ninth, eighth, seventh, sixth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldOverMaxMovie() {
        MovieManager manager = new MovieManager(11);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        Movie[] actual = manager.getLastAdd();
        Movie[] expected = new Movie[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }
}
