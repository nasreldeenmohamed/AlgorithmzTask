package com.algorithmz.algorithmztask.webService.models;

import com.algorithmz.algorithmztask.models.Genre;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GenreResponse {
    @SerializedName("genres")
    @Expose
    private List<Genre> genresList;

    public GenreResponse(List<Genre> genresList) {
        this.genresList = genresList;
    }

    public GenreResponse() {
    }

    public List<Genre> getGenresList() {
        return genresList;
    }

    public void setGenresList(List<Genre> genresList) {
        this.genresList = genresList;
    }
}
