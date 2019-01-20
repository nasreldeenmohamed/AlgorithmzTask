package com.algorithmz.algorithmztask.dataRepositories;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import com.algorithmz.algorithmztask.models.Genre;
import com.algorithmz.algorithmztask.webService.RetrofitRepository;

import java.util.HashMap;
import java.util.List;

public class GenresRepository {
    private RetrofitRepository retrofitRepository;

    private HashMap<Integer, String> GenresMap;
    private LiveData<HashMap<Integer, String>> hashMapLiveData = new MutableLiveData<>();

    @SuppressLint("UseSparseArrays")
    public GenresRepository() {
        GenresMap = new HashMap<>();
        retrofitRepository = RetrofitRepository.getInstance();
    }

    public LiveData<HashMap<Integer, String>> getGenresHashMapLiveData(String lang) {
        LiveData<List<Genre>> genreLiveData = retrofitRepository.getGenresList(lang);
        genreLiveData.observeForever(new Observer<List<Genre>>() {
            @Override
            public void onChanged(@Nullable List<Genre> genres) {
                mapGenres(genres);
                ((MutableLiveData<HashMap<Integer, String>>) hashMapLiveData).setValue(GenresMap);
            }
        });
        return hashMapLiveData;
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
