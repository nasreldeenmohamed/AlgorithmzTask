package com.algorithmz.algorithmztask.modules.topRatedMovies;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.algorithmz.algorithmztask.dataRepositories.GenresRepository;
import com.algorithmz.algorithmztask.dataRepositories.TopRatedMoviesRepository;
import com.algorithmz.algorithmztask.models.Genre;
import com.algorithmz.algorithmztask.models.Movie;

import java.util.HashMap;
import java.util.List;

public class MoviesViewModel extends AndroidViewModel {
    private LiveData<List<Movie>> topRatedListLiveData = new MutableLiveData<>();
    private LiveData<List<Genre>> GenresListLiveData = new MutableLiveData<>();

    private GenresRepository genresRepository;
    private TopRatedMoviesRepository topRatedMoviesRepository;

    // these data supposed to be in user's settings for the app, for now I'll make it constants
    private int CurrentPage = 1;
    private String CurrentLanguage = "en-US";
    private String CurrentRegion = "ME";

    public MoviesViewModel(@NonNull Application application) {
        super(application);
        genresRepository = new GenresRepository();

        topRatedMoviesRepository = new TopRatedMoviesRepository(application);
    }

    public LiveData<List<Movie>> getTopRatedMoviesList() {
        return topRatedMoviesRepository.getTopRatedMoviesList(CurrentLanguage, CurrentRegion, CurrentPage);
    }

    public LiveData<HashMap<Integer, String>> getGenresListLiveData() {
        return genresRepository.getGenresHashMapLiveData(CurrentLanguage);
    }

    public List<Movie> mapMoviesGenres(List<Movie> movieList) {
//        List<Movie> movieList = topRatedMoviesRepository.getMovieList();
        HashMap<Integer, String> GenresHashMap = genresRepository.getGenresMap();

        if (movieList != null && GenresHashMap != null) {
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
        return movieList;
    }
}
