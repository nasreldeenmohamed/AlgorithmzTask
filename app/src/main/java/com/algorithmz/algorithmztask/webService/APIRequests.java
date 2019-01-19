package com.algorithmz.algorithmztask.webService;

import com.algorithmz.algorithmztask.webService.models.TopRatedResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIRequests {
    @GET("posts")
    Call<TopRatedResponse> getTopRatedMovies();
}
