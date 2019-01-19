package com.algorithmz.algorithmztask.webService;

import com.algorithmz.algorithmztask.webService.models.GenreResponse;
import com.algorithmz.algorithmztask.webService.models.TopRatedResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIRequests {

    @GET("movie/top_rated")
    Call<TopRatedResponse> getTopRatedMovies(@Query("api_key") String API_KEY, @Query("language") String lang,
                                             @Query("page") int pageNumber, @Query("region") String Region);

    @GET("genre/movie/list")
    Call<GenreResponse> getGenresList(@Query("api_key") String apiKey, @Query("language") String lang);
}
