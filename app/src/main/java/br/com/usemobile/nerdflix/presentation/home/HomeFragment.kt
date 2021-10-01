package br.com.usemobile.nerdflix.presentation.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import br.com.usemobile.nerdflix.commons.toMovieActionEntity
import br.com.usemobile.nerdflix.commons.toMovieDramaEntity
import br.com.usemobile.nerdflix.databinding.FragmentHomeBinding
import br.com.usemobile.nerdflix.network.model.Movie
import com.bumptech.glide.Glide
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeViewModel: HomeViewModel
    private val movieAdapterForYou: MovieAdapter by lazy {
        MovieAdapter {
            onClickItem(it)
        }
    }
    private val movieAdapterAction: MovieAdapter by lazy {
        MovieAdapter {
            onClickItem(it)
        }
    }
    private val movieAdapterDrama: MovieAdapter by lazy {
        MovieAdapter {
            onClickItem(it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getData()
        setObservers()
        setAdapter()
    }

    private fun getData() {
        homeViewModel.getData()
    }

    private fun setObservers() {
        homeViewModel.comingSoon.observe(viewLifecycleOwner, { movie ->
            setComingSoon(movie)
        })
        homeViewModel.forYou.observe(viewLifecycleOwner, {
            movieAdapterForYou.setList(it)
        })
        homeViewModel.action.observe(viewLifecycleOwner, {
            movieAdapterAction.setList(it)
        })
        homeViewModel.drama.observe(viewLifecycleOwner, {
            movieAdapterDrama.setList(it)
        })


    }


    private fun setComingSoon(movie: Movie) {
        binding.txtReleaseTitle.text = movie.title
        binding.txtStars.text = movie.starListString
        setComingSoonImage(movie.pathImage)

    }

    private fun setComingSoonImage(pathImage: String) {
        Glide
            .with(binding.root)
            .load(pathImage)
            .centerCrop()
            .into(binding.imgRelease)
    }

    private fun setAdapter() {
        binding.toYouRecycler.adapter = movieAdapterForYou
        binding.actionRecycler.adapter = movieAdapterAction
        binding.dramaRecycler.adapter = movieAdapterDrama
    }

    private fun onClickItem(item: Movie) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToDetailsFragment()
        )
    }

}