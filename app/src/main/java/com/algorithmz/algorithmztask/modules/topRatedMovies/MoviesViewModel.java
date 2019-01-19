package com.algorithmz.algorithmztask.modules.topRatedMovies;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.algorithmz.algorithmztask.dataRepositories.GenresRepository;
import com.algorithmz.algorithmztask.dataRepositories.TopRatedMoviesRepository;
import com.algorithmz.algorithmztask.models.Movie;

import java.util.HashMap;
import java.util.List;

public class MoviesViewModel extends AndroidViewModel {
    LiveData<List<Movie>> topRatedListLiveData = new MutableLiveData<>();

    TopRatedMoviesRepository topRatedMoviesRepository;
    GenresRepository genresRepository;

    // these data supposed to be in user's settings for the app, for now I'll make it constants
    int CurrentPage = 1;
    String CurrentLanguage = "en-US";
    String CurrentRegion = "ME";

    public MoviesViewModel(@NonNull Application application) {
        super(application);
        genresRepository = new GenresRepository(CurrentLanguage);
//        genresListLiveData = genresRepository.getGenresList(CurrentLanguage);

        topRatedMoviesRepository = new TopRatedMoviesRepository(application);
    }

    public LiveData<List<Movie>> getTopRatedMoviesList() {
        topRatedListLiveData = topRatedMoviesRepository.getTopRatedMoviesList(CurrentLanguage, CurrentRegion, CurrentPage);
        mapMoviesGenres();
        return topRatedListLiveData;
    }

    public void mapMoviesGenres() {
        List<Movie> movieList = topRatedListLiveData.getValue();
        HashMap<Integer, String> GenresHashMap = genresRepository.getGenresMap();

        String genreTemp = "";
        for (Movie movie : movieList) {
            int[] genresString = movie.getGeneratedIDs();
            for (int j = 0; j < genresString.length; j++) {
                genreTemp += GenresHashMap.get(genresString[j]) + ", ";
            }
            genreTemp = genreTemp.substring(0, (genreTemp.length() - 2));
            movie.setGenres(genreTemp);
            genreTemp = "";
        }
        ((MutableLiveData<List<Movie>>) topRatedListLiveData).setValue(movieList);
    }
}
