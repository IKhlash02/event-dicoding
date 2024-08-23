package com.example.capstone1.core.ui


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.capstone1.R
import com.example.capstone1.core.domain.model.Event
import com.example.capstone1.databinding.ListItemBinding

class EventAdapter : RecyclerView.Adapter<EventAdapter.ListViewHolder>() {

    private var listData = ArrayList<Event>()
    var onItemClick: ((Event) -> Unit)? = null

    fun setData(newListData: List<Event>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ListItemBinding.bind(itemView)
        fun bind(data: Event) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.imageLogo)
                    .into(ivItemImage)
                tvName.text = data.name
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}