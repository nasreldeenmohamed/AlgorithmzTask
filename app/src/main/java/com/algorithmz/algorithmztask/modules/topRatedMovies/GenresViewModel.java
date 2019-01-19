package com.algorithmz.algorithmztask.modules.topRatedMovies;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.algorithmz.algorithmztask.dataRepositories.TopRatedMoviesRepository;
import com.algorithmz.algorithmztask.models.Movie;

import java.util.List;

public class GenresViewModel extends AndroidViewModel {
    LiveData<List<Movie>> topRatedListLiveData = new MutableLiveData<>();
    TopRatedMoviesRepository topRatedMoviesRepository;

    // these data supposed to be in user's settings for the app, for now I'll make it constants
    int CurrentPage = 1;
    String CurrentLanguage = "en-US";
    String CurrentRegion = "ME";

    public GenresViewModel(@NonNull Application application) {
        super(application);
        topRatedMoviesRepository = new TopRatedMoviesRepository(application);
    }

    public LiveData<List<Movie>> getTopRatedMoviesList() {
        topRatedListLiveData = topRatedMoviesRepository.getTopRatedMoviesList(CurrentLanguage, CurrentRegion, CurrentPage);
        return topRatedListLiveData;
    }
}
