package com.udacity.popularmovie.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.*;
import com.udacity.popularmovie.model.Movie;

@Dao
public interface MovieDao {
    @Query("SELECT * FROM movie")
    LiveData<Movie[]> loadAllMovies();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertMovie(Movie movie);

    @Query("DELETE FROM movie WHERE movieId = :movieId")
    void deleteMovie(int movieId);

    @Query("SELECT * FROM movie WHERE movieId = :movieId")
    LiveData<Movie> loadMovieById(int movieId);
}
