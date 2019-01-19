package com.algorithmz.algorithmztask.webService.models;

import com.algorithmz.algorithmztask.models.Movie;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TopRatedResponse {

    @SerializedName("page")
    @Expose
    private int PageNumber;
    @SerializedName("total_results")
    @Expose
    private int TotalNumberOfResults;
    @SerializedName("total_pages")
    @Expose
    private int TotalNumberOfPages;

    @SerializedName("status_message")
    @Expose
    private String StatusMessage;

    @SerializedName("status_code")
    @Expose
    private int StatusCode;

    @SerializedName("results")
    @Expose
    private List<Movie> TopRatedMovies;

    public TopRatedResponse() {

    }

    public int getPageNumber() {
        return PageNumber;
    }

    public void setPageNumber(int pageNumber) {
        PageNumber = pageNumber;
    }

    public int getTotalNumberOfResults() {
        return TotalNumberOfResults;
    }

    public void setTotalNumberOfResults(int totalNumberOfResults) {
        TotalNumberOfResults = totalNumberOfResults;
    }

    public int getTotalNumberOfPages() {
        return TotalNumberOfPages;
    }

    public void setTotalNumberOfPages(int totalNumberOfPages) {
        TotalNumberOfPages = totalNumberOfPages;
    }

    public String getStatusMessage() {
        return StatusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        StatusMessage = statusMessage;
    }

    public int getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(int statusCode) {
        StatusCode = statusCode;
    }

    public List<Movie> getTopRatedMovies() {
        return TopRatedMovies;
    }

    public void setTopRatedMovies(List<Movie> topRatedMovies) {
        TopRatedMovies = topRatedMovies;
    }
}
