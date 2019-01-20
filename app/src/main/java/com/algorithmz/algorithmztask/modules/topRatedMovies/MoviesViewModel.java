package com.algorithmz.algorithmztask.modules.topRatedMovies;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.algorithmz.algorithmztask.dataRepositories.GenresRepository;
import com.algorithmz.algorithmztask.dataRepositories.TopRatedMoviesRepository;
import com.algorithmz.algorithmztask.models.Movie;

import java.util.HashMap;
import java.util.List;

public class MoviesViewModel extends AndroidViewModel {
    private LiveData<List<Movie>> topRatedListLiveData;
    private LiveData<HashMap<Integer, String>> GenresListLiveData;

    private GenresRepository genresRepository;
    private TopRatedMoviesRepository topRatedMoviesRepository;

    private HashMap<Integer, String> genresList;

    // these data supposed to be in user's settings for the app, for now I'll make it constants
    private int CurrentPage = 1;
    private String CurrentLanguage = "en-US";
    private String CurrentRegion = "ME";

    public MoviesViewModel(@NonNull Application application) {
        super(application);
        genresRepository = new GenresRepository();
        topRatedMoviesRepository = new TopRatedMoviesRepository(application);

        GenresListLiveData = genresRepository.getGenresHashMapLiveData(CurrentLanguage);
        GenresListLiveData.observeForever(new Observer<HashMap<Integer, String>>() {
            @Override
            public void onChanged(@Nullable HashMap<Integer, String> integerStringHashMap) {
                Log.e("viewModel", "genres map ready");
                genresList = integerStringHashMap;
                GenresListLiveData.removeObserver(this);
            }
        });

        topRatedListLiveData = topRatedMoviesRepository.getTopRatedMoviesList(CurrentLanguage, CurrentRegion, CurrentPage);
        topRatedListLiveData.observeForever(new Observer<List<Movie>>() {
            @Override
            public void onChanged(@Nullable List<Movie> movies) {
                Log.e("viewModel", "movies list ready");
                if (genresList != null)
                    mapMoviesGenres(movies, genresList);
                topRatedListLiveData.removeObserver(this);
            }
        });
    }

    public LiveData<List<Movie>> getTopRatedMoviesList() {
        return topRatedListLiveData;
    }

    private void mapMoviesGenres(List<Movie> movieList, HashMap<Integer, String> GenresHashMap) {
        if (movieList != null && GenresHashMap != null) {
            String genreTemp = "";
            for (int i = 0; i < movieList.size(); i++) {
                int[] genresString = movieList.get(i).getGeneratedIDs();
                for (int j = 0; j < genresString.length; j++) {
                    genreTemp += GenresHashMap.get(genresString[j]) + ", ";
                }
                genreTemp = genreTemp.substring(0, (genreTemp.length() - 2));
                movieList.get(i).setGenres(genreTemp);
                genreTemp = "";
            }
            ((MutableLiveData<List<Movie>>) topRatedListLiveData).setValue(movieList);
        }
    }
}
