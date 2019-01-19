package com.algorithmz.algorithmztask.modules.topRatedMovies.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.algorithmz.algorithmztask.R;
import com.algorithmz.algorithmztask.databinding.ItemMovieBinding;
import com.algorithmz.algorithmztask.models.Movie;
import com.squareup.picasso.Picasso;

public class MoviesAdapter extends ListAdapter<Movie, MoviesAdapter.MovieHolder> {

    OnItemClickListener listener;

    LayoutInflater layoutInflater;

    public MoviesAdapter() {
        super(DIFF_CALLBACK);
    }

    private static final DiffUtil.ItemCallback<Movie> DIFF_CALLBACK = new DiffUtil.ItemCallback<Movie>() {
        @Override
        public boolean areItemsTheSame(Movie oldItem, Movie newItem) {
            return oldItem.getMovieID() == newItem.getMovieID();
        }

        @Override
        public boolean areContentsTheSame(Movie oldItem, Movie newItem) {
            return oldItem.getTitle().equals(newItem.getTitle())
                    && oldItem.getGenres().equals(newItem.getGenres());
        }
    };

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        ItemMovieBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_movie, parent, false);
        return new MovieHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {
        holder.binding.setMovie(getItem(position));
//        Picasso.with(context).load(getItem(position).getPosterPath()).fit().into(holder.binding.imageView);
    }


    public class MovieHolder extends RecyclerView.ViewHolder {

        private final ItemMovieBinding binding;

        public MovieHolder(final ItemMovieBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    listener.onItemClick(getItem(position));
                }
            });
        }

    }

    public interface OnItemClickListener {
        void onItemClick(Movie note);
    }

    public void setOnItemClickListener(OnItemClickListener listner) {
        this.listener = listner;
    }
}
