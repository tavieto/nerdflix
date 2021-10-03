package br.com.usemobile.nerdflix.presentation.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.usemobile.nerdflix.databinding.ItemMovieBinding
import br.com.usemobile.nerdflix.network.model.Movie
import com.bumptech.glide.Glide

class HomeAdapter(
    private val callback: (item: Movie) -> Unit
) : RecyclerView.Adapter<HomeAdapter.MovieViewHolder>() {

    private var listData: List<Movie> = emptyList()

    inner class MovieViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Movie) {
            setImage(item)
            binding.text.text = item.title
            binding.root.setOnClickListener {
                callback(item)
            }
        }

        private fun setImage(item: Movie) {
            Glide
                .with(binding.root)
                .load(item.pathImage)
                .centerCrop()
                .into(binding.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<Movie>) {
        listData = list
        notifyDataSetChanged()
    }
}