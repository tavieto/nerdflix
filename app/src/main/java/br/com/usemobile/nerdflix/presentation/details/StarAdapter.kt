package br.com.usemobile.nerdflix.presentation.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.usemobile.nerdflix.databinding.ItemStarBinding
import br.com.usemobile.nerdflix.network.model.Star
import com.bumptech.glide.Glide

class StarAdapter : RecyclerView.Adapter<StarAdapter.StarViewHolder>() {

    private var listData: List<Star> = emptyList()

    inner class StarViewHolder(private val binding: ItemStarBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Star) {
            binding.text.text = item.name

            Glide
                .with(binding.root)
                .load("https://imdb-api.com/images/original/MV5BZWUxY2JmMzgtYzY3ZS00MGI1LWE0ZjAtNTA5MDBiZTZmNzRhXkEyXkFqcGdeQXVyODk4OTc3MTY@._V1_Ratio1.5000_AL_.jpg")
                .centerCrop()
                .into(binding.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarViewHolder {
        val view = ItemStarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StarViewHolder(view)
    }

    override fun onBindViewHolder(holder: StarViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    fun setList(list: List<Star>) {
        listData = list
        notifyDataSetChanged()
    }
}