package com.example.soptin.presentation.collectretrospectives

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.soptin.data.model.RetrospectDto
import com.example.soptin.databinding.ItemBottomSheetRetrospectBinding
import com.example.soptin.databinding.ItemRetrospectBinding
import com.example.soptin.util.DiffCallback

class MonthYearAdapter(
) : ListAdapter<String, MonthYearAdapter.RetrospectViewHolder>(
    MonthYearDiffCallback
) {

    private lateinit var binding: ItemBottomSheetRetrospectBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrospectViewHolder {
        binding = ItemBottomSheetRetrospectBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RetrospectViewHolder(binding)
    }

    override fun onBindViewHolder(holder:RetrospectViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class RetrospectViewHolder(private val binding: ItemBottomSheetRetrospectBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(a:String) {
            binding.tvMonthYear.text = a
            binding.executePendingBindings()
        }
    }

    companion object {
        private val MonthYearDiffCallback =
            DiffCallback<String>(id = { old, new -> old== new })
    }
}

