package br.com.usemobile.nerdflix.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import br.com.usemobile.nerdflix.databinding.FragmentHomeBinding
import br.com.usemobile.nerdflix.network.model.Movie
import br.com.usemobile.nerdflix.network.model.MovieRequest
import com.bumptech.glide.Glide

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeViewModel: HomeViewModel
    private val movieAdapterToYou: MovieAdapter by lazy {
        MovieAdapter {
            onClickItem(it)
        }
    }
    private val movieAdapterAction: MovieAdapter by lazy {
        MovieAdapter{
            onClickItem(it)
        }
    }
    private val movieAdapterDrama: MovieAdapter by lazy {
        MovieAdapter{
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
        homeViewModel.getComingSoon()
    }

    private fun setObservers() {
        homeViewModel.comingSoon.observe(viewLifecycleOwner, { movie ->
            setComingSoon(movie)
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
        binding.toYouRecycler.adapter = movieAdapterToYou
        binding.actionRecycler.adapter = movieAdapterAction
        binding.dramaRecycler.adapter = movieAdapterDrama

        movieAdapterToYou.setList(
            listOf(
                MovieRequest(
                    "",
                    "",
                    "",
                    "",
                    emptyList()
                )
            )
        )
    }

    private fun onClickItem(item: MovieRequest) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToDetailsFragment()
        )
    }

}