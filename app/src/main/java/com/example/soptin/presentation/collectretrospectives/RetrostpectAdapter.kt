package com.example.soptin.presentation.collectretrospectives

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.soptin.data.model.RetrospectDto
import com.example.soptin.databinding.ItemRetrospectBinding
import com.example.soptin.util.DiffCallback

class RetrostpectAdapter(
    private val viewModel: RetrospectViewModel,
) : ListAdapter<RetrospectDto, RetrostpectAdapter.RetrospectViewHolder>(
    RetrospectDiffCallback
) {

    private lateinit var binding: ItemRetrospectBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrospectViewHolder {
        binding = ItemRetrospectBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RetrospectViewHolder(binding)
    }

    override fun onBindViewHolder(holder:RetrospectViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class RetrospectViewHolder(private val binding: ItemRetrospectBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(retrospectDto: RetrospectDto) {
            binding.viewmodel=viewModel
            binding.retrospect=retrospectDto
            binding.executePendingBindings()
        }
    }

    companion object {
        private val RetrospectDiffCallback =
            DiffCallback<RetrospectDto>(id = { old, new -> old.retrospectId == new.retrospectId })
    }
}

