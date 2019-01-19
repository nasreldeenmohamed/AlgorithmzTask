package com.algorithmz.algorithmztask.modules.topRatedMovies.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.algorithmz.algorithmztask.R
import com.algorithmz.algorithmztask.databinding.ActivityMainBinding
import com.algorithmz.algorithmztask.modules.MovieDetailsActivity
import com.algorithmz.algorithmztask.modules.topRatedMovies.MoviesViewModel

class MainActivity : AppCompatActivity() {

    internal lateinit var moviesAdapter: MoviesAdapter

    internal lateinit var mainViewModel: MoviesViewModel
    internal lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.setLifecycleOwner(this);
        title = "Top Rated"

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.setHasFixedSize(true)
        moviesAdapter = MoviesAdapter()
        binding.recyclerView.adapter = moviesAdapter

        mainViewModel = ViewModelProviders.of(this).get(MoviesViewModel::class.java)
        mainViewModel.topRatedMoviesList.observe(this, Observer {
            movies -> moviesAdapter.submitList(movies) })

        moviesAdapter.setOnItemClickListener { movie ->
            val intent = Intent(this@MainActivity, MovieDetailsActivity::class.java)
            intent.putExtra("movie", movie)
            startActivity(intent)
        }
    }

}
