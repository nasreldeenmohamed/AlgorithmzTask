package com.algorithmz.algorithmztask.modules.topRatedMovies;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.algorithmz.algorithmztask.models.Movie;

import java.util.List;

public class MoviesViewModel extends AndroidViewModel {
    LiveData<List<Movie>> topRatedListLiveData = new MutableLiveData<>();


    public MoviesViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Movie>> getTopRatedMoviesList() {
        return topRatedListLiveData;
    }
}
