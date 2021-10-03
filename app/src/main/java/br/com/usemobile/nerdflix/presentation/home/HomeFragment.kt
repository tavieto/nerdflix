package br.com.usemobile.nerdflix.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.usemobile.nerdflix.commons.Const
import br.com.usemobile.nerdflix.commons.getStarIds
import br.com.usemobile.nerdflix.commons.getStarImage
import br.com.usemobile.nerdflix.commons.getStarNames
import br.com.usemobile.nerdflix.databinding.FragmentHomeBinding
import br.com.usemobile.nerdflix.network.model.Movie
import com.bumptech.glide.Glide
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val homeViewModel: HomeViewModel by viewModel()
    private val movieAdapterForYou: HomeAdapter by lazy {
        HomeAdapter {
            onClickItem(it)
        }
    }
    private val movieAdapterAction: HomeAdapter by lazy {
        HomeAdapter {
            onClickItem(it)
        }
    }
    private val movieAdapterDrama: HomeAdapter by lazy {
        HomeAdapter {
            onClickItem(it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getData()
        setObservers()
        setAdapter()
        setListeners()
    }

    private fun setListeners() {
        binding.forYouMore.setOnClickListener {
            findNavController().navigate(
                HomeFragmentDirections
                    .actionHomeFragmentToMoreFragment(Const.TYPE_FOR_YOU)
            )
        }
        binding.actionMore.setOnClickListener {
            findNavController().navigate(
                HomeFragmentDirections
                    .actionHomeFragmentToMoreFragment(Const.TYPE_ACTION)
            )
        }
        binding.dramaMore.setOnClickListener {
            findNavController().navigate(
                HomeFragmentDirections
                    .actionHomeFragmentToMoreFragment(Const.TYPE_DRAMA)
            )
        }
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

        binding.imgRelease.setOnClickListener {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToDetailsFragment(
                    movie.pathImage,
                    movie.title,
                    movie.starListString,
                    movie.description,
                    movie.starList.getStarIds().toTypedArray(),
                    movie.starList.getStarNames().toTypedArray(),
                    movie.starList.getStarImage().toTypedArray()
                )
            )
        }
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

    private fun onClickItem(movie: Movie) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToDetailsFragment(
                movie.pathImage,
                movie.title,
                movie.starListString,
                movie.description,
                movie.starList.getStarIds().toTypedArray(),
                movie.starList.getStarNames().toTypedArray(),
                movie.starList.getStarImage().toTypedArray()
            )
        )
    }

}