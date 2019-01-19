package com.algorithmz.algorithmztask.modules.topRatedMovies;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.algorithmz.algorithmztask.models.Movie;
import com.algorithmz.algorithmztask.webService.RetrofitRepository;

import java.util.List;

public class ToRatedMoviesRepository {
    RetrofitRepository retrofitRepository;

    public ToRatedMoviesRepository(Application application) {
        retrofitRepository = RetrofitRepository.getInstance();
    }

    public LiveData<List<Movie>> getAllPosts() {

        return retrofitRepository.getTopRatedMoviesList();
    }
}
