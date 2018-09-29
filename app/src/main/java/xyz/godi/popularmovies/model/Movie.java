package xyz.godi.popularmovies.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

@Entity
public class Movie implements Parcelable {
    // Class TAG
    public static final String TAG = "movies";

    // Class properties
    @PrimaryKey
    @SerializedName("id")
    private int id;
    @SerializedName("poster_path")
    private String poster_path;
    @SerializedName("backdrop_path")
    private String backdrop_path;
    @SerializedName("original_title")
    private String original_title;
    @SerializedName("release_date")
    private String release_date;
    @SerializedName("vote_count")
    private Integer vote_count;
    @SerializedName("vote_average")
    private double vote_average;
    @SerializedName("overview")
    private String overview;

    // constructor Movie with parameters
    public Movie(int id, String poster_path, String backdrop_path, String original_title,
                 String release_date, int vote_count, double vote_average, String overview) {
        this.id = id;
        this.poster_path = poster_path;
        this.original_title = original_title;
        this.release_date = release_date;
        this.vote_count = vote_count;
        this.overview = overview;
        this.backdrop_path = backdrop_path;
        this.vote_average = vote_average;
    }

    private Movie(Parcel in) {
        id = in.readInt();
        poster_path = in.readString();
        backdrop_path = in.readString();
        original_title = in.readString();
        release_date = in.readString();
        vote_count = in.readInt();
        vote_average = in.readDouble();
        overview = in.readString();
    }

    public static final Creator CREATOR = new Creator() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    // getters & setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public Integer getVote_count() {
        return vote_count;
    }

    public void setVote_count(Integer vote_count) {
        this.vote_count = vote_count;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(poster_path);
        dest.writeString(backdrop_path);
        dest.writeString(original_title);
        dest.writeString(release_date);
        dest.writeInt(vote_count);
        dest.writeDouble(vote_average);
        dest.writeString(overview);
    }
}