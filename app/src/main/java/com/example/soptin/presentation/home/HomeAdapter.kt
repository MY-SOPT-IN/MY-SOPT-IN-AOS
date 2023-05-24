package com.example.soptin.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.soptin.R
import com.example.soptin.data.model.RoutineDto
import com.example.soptin.databinding.ItemRoutineBinding
import com.example.soptin.util.DiffCallback

class HomeAdapter() : ListAdapter<RoutineDto, HomeAdapter.HomeViewHolder>(
    HomeDiffCallback
) {

    private lateinit var binding: ItemRoutineBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        binding = ItemRoutineBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class HomeViewHolder(private val binding: ItemRoutineBinding) :
        RecyclerView.ViewHolder(binding.root) {
        // 이거 이따구로 해도되나? ㅋㅋ
        fun bind(routineDto: RoutineDto) {
            if (position == 0) {
                binding.tvDo.setBackgroundResource(R.drawable.backgroundtop)
                binding.ivCheck.setBackgroundResource(R.drawable.background_grey_top)
                binding.tvRoutine.setBackgroundResource(R.drawable.background_grey_top)
            } else if (position < itemCount - 1) {
                binding.tvDo.setBackgroundResource(R.drawable.backgroundcenter)
                binding.ivCheck.setBackgroundResource(R.drawable.background_grey_center)
                binding.tvRoutine.setBackgroundResource(R.drawable.background_grey_center)
            } else {
                binding.tvDo.setBackgroundResource(R.drawable.backgroundbottom)
                binding.ivCheck.setBackgroundResource(R.drawable.background_grey_bottom)
                binding.tvRoutine.setBackgroundResource(R.drawable.background_grey_bottom)
            }
            binding.tvIndex.text = (position + 1).toString()
            binding.routineDto = routineDto
            binding.executePendingBindings()
        }
    }

    companion object {
        private val HomeDiffCallback =
            DiffCallback<RoutineDto>(id = { old, new -> old.routineId == new.routineId })
    }
}

