package com.example.soptin.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.soptin.data.RoutineDto
import com.example.soptin.databinding.Item1Binding
import com.example.soptin.util.DiffCallback

class HomeAdapter() : ListAdapter<RoutineDto, HomeAdapter.HomeViewHolder>(
    HomeDiffCallback
){

    private lateinit var binding: Item1Binding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        binding = Item1Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class HomeViewHolder(private val binding: Item1Binding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(routineDto: RoutineDto) {
            binding.routineDto = routineDto
            binding.executePendingBindings()
        }
    }
    companion object {
        private val HomeDiffCallback =
            DiffCallback<RoutineDto>(id = { old, new -> old.index == new.index })
    }
}

