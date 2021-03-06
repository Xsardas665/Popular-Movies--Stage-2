package com.udacity.popularmovie;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.udacity.popularmovie.database.AppDatabase;
import com.udacity.popularmovie.model.Movie;

public class MainViewModel extends AndroidViewModel {

    private LiveData<Movie[]> movies;

    public MainViewModel(@NonNull Application application) {
        super (application);
        AppDatabase database = AppDatabase.getInstance (this.getApplication ());
        movies = database.movieDao ().loadAllMovies ();
    }

    public LiveData<Movie[]> getMovies() {
        return movies;
    }
}
