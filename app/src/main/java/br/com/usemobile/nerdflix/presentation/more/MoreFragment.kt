package br.com.usemobile.nerdflix.presentation.more

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import br.com.usemobile.nerdflix.R
import br.com.usemobile.nerdflix.commons.Const
import br.com.usemobile.nerdflix.commons.getStarIds
import br.com.usemobile.nerdflix.commons.getStarImage
import br.com.usemobile.nerdflix.commons.getStarNames
import br.com.usemobile.nerdflix.databinding.FragmentMoreBinding
import br.com.usemobile.nerdflix.network.model.Movie
import br.com.usemobile.nerdflix.presentation.home.HomeFragmentDirections
import org.koin.androidx.viewmodel.ext.android.viewModel

class MoreFragment : Fragment() {

    private lateinit var binding: FragmentMoreBinding
    private val moreViewModel: MoreViewModel by viewModel()
    private val adapter: MoreAdapter by lazy {
        MoreAdapter {
            onClickItem(it)
        }
    }
    private val args: MoreFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        verifyType()
        setAdapter()
        setObservers()
        setListeners()
    }

    private fun setObservers() {
        moreViewModel.forYouMovieList.observe(viewLifecycleOwner, { list ->
            adapter.setList(list)
        })
        moreViewModel.actionMovieList.observe(viewLifecycleOwner, { list ->
            adapter.setList(list)
        })
        moreViewModel.dramaMovieList.observe(viewLifecycleOwner, { list ->
            adapter.setList(list)
        })
    }

    private fun setAdapter() {
        binding.recyclerView.adapter = adapter
    }

    private fun verifyType() {
        when(args.type) {
            Const.TYPE_FOR_YOU -> {
                binding.txtCategoryTitle.text = getString(R.string.for_you)
                moreViewModel.getAllForYouMovie()
            }
            Const.TYPE_DRAMA -> {
                binding.txtCategoryTitle.text = getString(R.string.drama)
                moreViewModel.getAllActionMovie()
            }
            Const.TYPE_ACTION -> {
                binding.txtCategoryTitle.text = getString(R.string.action)
                moreViewModel.getAllDramaMovie()
            }
        }
    }

    private fun setListeners() {
        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun onClickItem(movie: Movie) {
        findNavController().navigate(
            MoreFragmentDirections.actionMoreFragmentToDetailsFragment(
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

