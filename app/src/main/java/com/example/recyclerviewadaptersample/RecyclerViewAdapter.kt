package com.example.recyclerviewadaptersample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewadaptersample.databinding.RecyclerViewItemBinding

interface RecyclerViewHolderListener {
    fun onClickRow(name: String)
}

class RecyclerViewAdapter(
    private val names: List<String>,
    private val recyclerViewHolderListener: RecyclerViewHolderListener?,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private inner class ViewHolder(
        val binding: RecyclerViewItemBinding,
        private val listener: RecyclerViewHolderListener?,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun set(name: String) {
            binding.data = name
            binding.root.setOnClickListener { listener?.onClickRow(name) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = RecyclerViewItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false,
        )
        return ViewHolder(binding, recyclerViewHolderListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            holder.set(names[position])
        }
    }

    override fun getItemCount(): Int {
        return names.size
    }
}
