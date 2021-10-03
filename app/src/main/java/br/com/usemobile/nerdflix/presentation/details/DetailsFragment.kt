package br.com.usemobile.nerdflix.presentation.details

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import br.com.usemobile.nerdflix.databinding.FragmentDetailsBinding
import br.com.usemobile.nerdflix.network.model.Star
import br.com.usemobile.nerdflix.network.model.StarDetails
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.GlideException

class DetailsFragment : Fragment() {

    private val args: DetailsFragmentArgs by navArgs()
    private lateinit var binding: FragmentDetailsBinding
    private val starAdapter: StarAdapter by lazy {
        StarAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setScreen()
        setAdapter()
        setListeners()
    }

    private fun setScreen() {
        setImage(args.pathImage)
        binding.txtReleaseTitle.text = args.title
        binding.txtStars.text = args.starsString
        binding.txtSynopsis.text = args.synopsis
    }

    private fun setImage(pathImage: String) {
        Glide
            .with(binding.root)
            .load(pathImage)
            .centerCrop()
            .into(binding.imgRelease)
    }

    private fun setListeners() {
        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setAdapter() {
        binding.recyclerView.adapter = starAdapter
        val listStars = mutableListOf<StarDetails>()
        var counter = 0

        while (counter < args.starsId.size) {
            listStars.add(
                StarDetails(
                    args.starsId[counter],
                    args.starsName[counter],
                    args.starsImage[counter]
                )
            )

            counter++
        }

        starAdapter.setList(listStars)
    }

}