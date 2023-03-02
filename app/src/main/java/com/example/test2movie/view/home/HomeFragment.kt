package com.example.test2movie.view.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.test2movie.view.home.popular.adapter.PopAdapter
import com.example.test2movie.databinding.FragmentHomeBinding
import com.example.test2movie.databinding.PopMovieItemBinding
import com.example.test2movie.view.home.popular.model.PopularMovieResult
import com.example.test2movie.view.home.popular.viewModel.PopularViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    var poplist = ArrayList<PopularMovieResult>()

    private lateinit var binding: FragmentHomeBinding
    private lateinit var binding2: PopMovieItemBinding

    private lateinit var viewModel_popular: PopularViewModel

    private lateinit var popularMovieAdapter: PopAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        //viewModel initialiZe kora hoise
        viewModel_popular = ViewModelProvider(requireActivity()).get(PopularViewModel::class.java)

        viewModel_popular._poplar_LiveDataObj.observe(viewLifecycleOwner) {

            for (i in 0 until it.results.size - 1) {
                poplist.add(it.results[i])
                    Log.d("himu", "onCreateView: " + it.results[i].original_title)
                binding2.movieSingleItemName.text = it.results[i].original_title
                fatchPopularMovieData(1)
            }
            /*popularMovieAdapter.submitList(poplist)
            popularMovieAdapter.notifyDataSetChanged()*/
            Log.d("abcd", "onCreateView: " + it.results.toString())
        }
        return binding.root
    }
    private fun fatchPopularMovieData(popularMoviePage: Int) {
        viewModel_popular.getPopularMoviessss(popularMoviePage)
    }
}