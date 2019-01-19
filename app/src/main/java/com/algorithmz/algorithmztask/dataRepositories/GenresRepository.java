package com.algorithmz.algorithmztask.dataRepositories;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import com.algorithmz.algorithmztask.models.Genre;
import com.algorithmz.algorithmztask.webService.RetrofitRepository;

import java.util.HashMap;
import java.util.List;

public class GenresRepository {
    private HashMap<Integer, String> GenresMap;

    public GenresRepository(String lang) {
        GenresMap = new HashMap<>();
        RetrofitRepository retrofitRepository = RetrofitRepository.getInstance();
        LiveData<List<Genre>> liveData = retrofitRepository.getGenresList(lang);
        liveData.observeForever(new Observer<List<Genre>>() {
            @Override
            public void onChanged(@Nullable List<Genre> genres) {
                mapGenres(genres);
            }
        });
    }

    private void mapGenres(List<Genre> genres) {
        for (Genre genre : genres) {
            GenresMap.put(genre.getID(), genre.getName());
        }
    }

    public HashMap<Integer, String> getGenresMap() {
        return GenresMap;
    }
}
