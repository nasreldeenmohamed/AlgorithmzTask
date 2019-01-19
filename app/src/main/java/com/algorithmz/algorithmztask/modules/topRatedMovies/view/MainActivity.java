package com.algorithmz.algorithmztask.modules.topRatedMovies.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.algorithmz.algorithmztask.R;
import com.algorithmz.algorithmztask.databinding.ActivityMainBinding;
import com.algorithmz.algorithmztask.models.Movie;
import com.algorithmz.algorithmztask.modules.MovieDetailsActivity;
import com.algorithmz.algorithmztask.modules.topRatedMovies.MoviesViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    MoviesAdapter moviesAdapter;

    MoviesViewModel mainViewModel;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setTitle("Top Rated");

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setHasFixedSize(true);

        moviesAdapter = new MoviesAdapter();

        mainViewModel = ViewModelProviders.of(this).get(MoviesViewModel.class);
        mainViewModel.getTopRatedMoviesList().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(@Nullable List<Movie> movies) {
                moviesAdapter.submitList(movies);
            }
        });

        moviesAdapter.setOnItemClickListener(new MoviesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Movie movie) {
                Intent intent = new Intent(MainActivity.this, MovieDetailsActivity.class);
                intent.putExtra("movieId", movie.getMovieID());
                startActivity(intent);
            }
        });
    }
}
