package br.com.usemobile.nerdflix.presentation.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.com.usemobile.nerdflix.databinding.FragmentDetailsBinding
import br.com.usemobile.nerdflix.network.model.Star

class DetailsFragment : Fragment() {

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

        setAdapter()
        setListeners()
    }

    private fun setListeners() {
        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setAdapter() {
        binding.recyclerView.adapter = starAdapter
        starAdapter.setList(
            listOf(
                Star(
                    "",
                    "Ethan Hawke"
                ),
                Star(
                    "",
                    "Sarah Snook"
                ),
                Star(
                    "",
                    "Noah Taylor"
                ),
                Star(
                    "",
                    "Noah Taylor"
                ),
                Star(
                    "",
                    "Noah Taylor"
                ),
                Star(
                    "",
                    "Noah Taylor"
                )
            )
        )
    }

}