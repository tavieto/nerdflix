package br.com.usemobile.nerdflix.presentation.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.usemobile.nerdflix.databinding.ItemMovieBinding
import br.com.usemobile.nerdflix.network.model.MovieRequest

class MovieAdapter(
    private val callback: (item: MovieRequest) -> Unit
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var listData: List<MovieRequest> = emptyList()

    inner class MovieViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MovieRequest) {
            binding.text.text = item.id
            binding.root.setOnClickListener {
                callback(item)
            }
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
    fun setList(list: List<MovieRequest>) {
        listData = list
        notifyDataSetChanged()
    }
}