package com.example.test2movie.view.home.popular.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.test2movie.databinding.PopMovieItemBinding
import com.example.test2movie.view.home.popular.model.PopularMovieResult


class PopAdapter(val callback: (movie: PopularMovieResult) -> Unit) :
    androidx.recyclerview.widget.ListAdapter<PopularMovieResult,
            PopAdapter.PopMovieViewHolder>(PopDiffUtil()){



    class PopDiffUtil : DiffUtil.ItemCallback<PopularMovieResult>() {
        override fun areItemsTheSame(oldItem: PopularMovieResult, newItem: PopularMovieResult): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: PopularMovieResult, newItem: PopularMovieResult): Boolean {
            return oldItem == newItem
        }
    }

    class PopMovieViewHolder (val binding: PopMovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(popMovie: PopularMovieResult) {
            //binding.popmovie = popMovie
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopMovieViewHolder {
        val binding =
            PopMovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PopMovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PopMovieViewHolder, position: Int) {
        var result = getItem(position)
        holder.bind(result)
        /*holder.binding.root.setOnClickListener {
            ConstraintUtils.movieDetails.selectedMovieID = result.id
            callback(result)
        }*/
    }
}