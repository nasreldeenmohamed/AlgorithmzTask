package com.algorithmz.algorithmztask.webService;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.algorithmz.algorithmztask.models.Genre;
import com.algorithmz.algorithmztask.models.Movie;
import com.algorithmz.algorithmztask.utils.Constants;
import com.algorithmz.algorithmztask.webService.models.GenreResponse;
import com.algorithmz.algorithmztask.webService.models.TopRatedRequest;
import com.algorithmz.algorithmztask.webService.models.TopRatedResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitRepository {


    private APIRequests apiRequests;
    private static RetrofitRepository retrofitRepository;

    private RetrofitRepository() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        apiRequests = retrofit.create(APIRequests.class);
    }

    public synchronized static RetrofitRepository getInstance() {

        if (retrofitRepository == null) {
            retrofitRepository = new RetrofitRepository();
        }

        return retrofitRepository;
    }

    public LiveData<List<Movie>> getTopRatedMoviesList(TopRatedRequest topRatedRequest) {
        final LiveData<List<Movie>> postsList = new MutableLiveData<>();

        apiRequests.getTopRatedMovies(Constants.API_KEY, topRatedRequest.getLanguage(), topRatedRequest.getPageNumber(),
                topRatedRequest.getRegion()).enqueue(new Callback<TopRatedResponse>() {
            @Override
            public void onResponse(@NonNull Call<TopRatedResponse> call, @NonNull Response<TopRatedResponse> response) {
                if (response.isSuccessful()) {
                    ((MutableLiveData<List<Movie>>) postsList).setValue(response.body().getTopRatedMovies());
                }
            }

            @Override
            public void onFailure(Call<TopRatedResponse> call, Throwable t) {
                TopRatedResponse topRatedResponse = new TopRatedResponse();
                topRatedResponse.setStatusMessage(t.getMessage());
            }
        });

        return postsList;
    }

    public LiveData<List<Genre>> getGenresList(String lang) {
        final LiveData<List<Genre>> genresList = new MutableLiveData<>();

        apiRequests.getGenresList(Constants.API_KEY, lang).enqueue(new Callback<GenreResponse>() {
            @Override
            public void onResponse(@NonNull Call<GenreResponse> call, @NonNull Response<GenreResponse> response) {
                if (response.isSuccessful()) {
                    ((MutableLiveData<List<Genre>>) genresList).setValue(response.body().getGenresList());
                }
            }

            @Override
            public void onFailure(Call<GenreResponse> call, Throwable t) {
                TopRatedResponse topRatedResponse = new TopRatedResponse();
                topRatedResponse.setStatusMessage(t.getMessage());
            }
        });

        return genresList;
    }
}
