package br.com.usemobile.nerdflix.presentation.details

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.usemobile.nerdflix.databinding.ItemStarBinding
import br.com.usemobile.nerdflix.network.model.StarDetails
import com.bumptech.glide.Glide

class StarAdapter : RecyclerView.Adapter<StarAdapter.StarViewHolder>() {

    private var listData: List<StarDetails> = emptyList()

    inner class StarViewHolder(private val binding: ItemStarBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: StarDetails) {
            binding.text.text = item.name

            Glide
                .with(binding.root)
                .load(item.image)
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

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<StarDetails>) {
        listData = list
        notifyDataSetChanged()
    }
}