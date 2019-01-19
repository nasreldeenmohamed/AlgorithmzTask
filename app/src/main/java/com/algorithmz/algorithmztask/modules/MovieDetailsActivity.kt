package com.algorithmz.algorithmztask.modules

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.algorithmz.algorithmztask.R
import com.algorithmz.algorithmztask.databinding.ActivityMovieDetailsBinding
import com.algorithmz.algorithmztask.models.Movie

class MovieDetailsActivity : AppCompatActivity() {

    internal lateinit var binding: ActivityMovieDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_details)
        binding.setLifecycleOwner(this);

        val currMovie: Movie = intent.getParcelableExtra<Movie>("movie");
        title = currMovie.title
        binding.movie = currMovie

    }
}
