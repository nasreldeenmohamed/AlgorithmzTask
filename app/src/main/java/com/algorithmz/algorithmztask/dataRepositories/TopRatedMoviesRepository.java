package com.algorithmz.algorithmztask.dataRepositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.algorithmz.algorithmztask.models.Movie;
import com.algorithmz.algorithmztask.webService.RetrofitRepository;
import com.algorithmz.algorithmztask.webService.models.TopRatedRequest;

import java.util.List;

public class TopRatedMoviesRepository {
    RetrofitRepository retrofitRepository;
    List<Movie> movieList;
    LiveData<List<Movie>> listLiveData;

    public TopRatedMoviesRepository(Application application) {
        retrofitRepository = RetrofitRepository.getInstance();
    }

    public LiveData<List<Movie>> getTopRatedMoviesList(String lang, String region, int pageNum) {
        TopRatedRequest topRatedRequest = new TopRatedRequest(lang, pageNum, region);
        listLiveData = retrofitRepository.getTopRatedMoviesList(topRatedRequest);
        movieList = listLiveData.getValue();
        return listLiveData;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }
}
