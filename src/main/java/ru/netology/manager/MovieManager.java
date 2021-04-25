package ru.netology.manager;

import ru.netology.domain.Movie;

public class MovieManager {
    public Movie[] items = new Movie[0];
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

    public Movie[] getAllMovies() {
        Movie[] result = new Movie[items.length];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public Movie[] getLastAdd() {
        int poster = this.poster;
        if (poster > items.length)
            poster = items.length;
        Movie[] result = new Movie[poster];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];

        }
        return result;
    }
}
