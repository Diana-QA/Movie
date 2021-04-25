package ru.netology.manager;

import ru.netology.domain.Movie;

public class MovieManager {
    private Movie[] items = new Movie[0];
    private int poster = 10;

    public MovieManager() {
    }

    public MovieManager(int poster) {
        this.poster = poster;
    }

    public void add(Movie item) {

        int length = items.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Movie[] getLastAdd() {
        if (items.length < poster) {
            poster = items.length;
        }
        Movie[] posterFilm = new Movie[poster];
        for (int i = 0; i < posterFilm.length; i++) {
            int result = items.length - i - 1;
            posterFilm[i] = items[result];

        }
        return posterFilm;
    }
}
