package com.algorithmz.algorithmztask.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.algorithmz.algorithmztask.R;
import com.algorithmz.algorithmztask.utils.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

public class Movie extends BaseObservable implements Parcelable {

    @Bindable
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

    @Bindable
    @SerializedName("original_title")
    @Expose
    private String OriginalTitle;

    @SerializedName("original_language")
    @Expose
    private String OriginalLanguage;

    @Bindable
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

    private String Genres;

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


    protected Movie(Parcel in) {
        PosterPath = in.readString();
        isAdult = in.readByte() != 0;
        isVideo = in.readByte() != 0;
        Overview = in.readString();
        ReleaseDate = in.readString();
        OriginalTitle = in.readString();
        OriginalLanguage = in.readString();
        Title = in.readString();
        BackdropPath = in.readString();
        GeneratedIDs = in.createIntArray();
        Genres = in.readString();
        MovieID = in.readInt();
        Popularity = in.readDouble();
        VoteAverage = in.readDouble();
        VoteCount = in.readInt();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    @BindingAdapter({"bind:poster_path"})
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso.with(view.getContext())
                .load(Constants.BASE_IMAGES_URL + imageUrl)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(view);
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

    public String getGenres() {
        return Genres;
    }

    public void setGenres(String genres) {
        Genres = genres;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(PosterPath);
        parcel.writeByte((byte) (isAdult ? 1 : 0));
        parcel.writeByte((byte) (isVideo ? 1 : 0));
        parcel.writeString(Overview);
        parcel.writeString(ReleaseDate);
        parcel.writeString(OriginalTitle);
        parcel.writeString(OriginalLanguage);
        parcel.writeString(Title);
        parcel.writeString(BackdropPath);
        parcel.writeIntArray(GeneratedIDs);
        parcel.writeString(Genres);
        parcel.writeInt(MovieID);
        parcel.writeDouble(Popularity);
        parcel.writeDouble(VoteAverage);
        parcel.writeInt(VoteCount);
    }
}
