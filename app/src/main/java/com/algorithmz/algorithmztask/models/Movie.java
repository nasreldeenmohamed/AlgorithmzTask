package com.algorithmz.algorithmztask.models;

import android.support.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Movie {

    @SerializedName("poster_path")
    @Expose
    private String PosterPath;

    @SerializedName("adult")
    @Expose
    private boolean isAdult;

    @SerializedName("video")
    @Expose
    private boolean isVideo;

    @SerializedName("overview")
    @Expose
    private String Overview;

    @SerializedName("release_date")
    @Expose
    private String ReleaseDate;

    @SerializedName("original_title")
    @Expose
    private String OriginalTitle;

    @SerializedName("original_language")
    @Expose
    private String OriginalLanguage;

    @SerializedName("title")
    @Expose
    private String Title;

    @Nullable
    @SerializedName("backdrop_path")
    @Expose
    private String BackdropPath;

    @SerializedName("genre_ids")
    @Expose
    private int[] GeneratedIDs;

    @SerializedName("id")
    @Expose
    private int MovieID;

    @SerializedName("popularity")
    @Expose
    private double Popularity;

    @SerializedName("vote_average")
    @Expose
    private double VoteAverage;

    @SerializedName("vote_count")
    @Expose
    private int VoteCount;

    public Movie() {
    }

    public String getPosterPath() {
        return PosterPath;
    }

    public void setPosterPath(String posterPath) {
        PosterPath = posterPath;
    }

    public boolean isAdult() {
        return isAdult;
    }

    public void setAdult(boolean adult) {
        isAdult = adult;
    }

    public boolean isVideo() {
        return isVideo;
    }

    public void setVideo(boolean video) {
        isVideo = video;
    }

    public String getOverview() {
        return Overview;
    }

    public void setOverview(String overview) {
        Overview = overview;
    }

    public String getReleaseDate() {
        return ReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        ReleaseDate = releaseDate;
    }

    public String getOriginalTitle() {
        return OriginalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        OriginalTitle = originalTitle;
    }

    public String getOriginalLanguage() {
        return OriginalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        OriginalLanguage = originalLanguage;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    @Nullable
    public String getBackdropPath() {
        return BackdropPath;
    }

    public void setBackdropPath(@Nullable String backdropPath) {
        BackdropPath = backdropPath;
    }

    public int[] getGeneratedIDs() {
        return GeneratedIDs;
    }

    public void setGeneratedIDs(int[] generatedIDs) {
        GeneratedIDs = generatedIDs;
    }

    public int getMovieID() {
        return MovieID;
    }

    public void setMovieID(int movieID) {
        MovieID = movieID;
    }

    public double getPopularity() {
        return Popularity;
    }

    public void setPopularity(double popularity) {
        Popularity = popularity;
    }

    public double getVoteAverage() {
        return VoteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        VoteAverage = voteAverage;
    }

    public int getVoteCount() {
        return VoteCount;
    }

    public void setVoteCount(int voteCount) {
        VoteCount = voteCount;
    }
}
