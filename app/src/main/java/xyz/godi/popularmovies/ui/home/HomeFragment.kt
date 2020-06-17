package xyz.godi.popularmovies.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.VisibleForTesting
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import xyz.godi.popularmovies.adapters.MovieAdapter
import xyz.godi.popularmovies.base.MainNavigationFragment
import xyz.godi.popularmovies.databinding.FragmentHomeBinding

@AndroidEntryPoint
class HomeFragment : MainNavigationFragment() {

    private lateinit var binding: FragmentHomeBinding

    @VisibleForTesting val viewModel by viewModels<HomeViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(
                inflater, container, false
        ).apply {
            lifecycleOwner = this@HomeFragment
            adapter = MovieAdapter()
            vm = viewModel.apply { fetchMovieList(0) }
        }

        return binding.root
    }
}