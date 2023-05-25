package com.example.soptin.presentation.collectretrospectives

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.soptin.R
import com.example.soptin.databinding.ItemBottomSheetRetrospectBinding
import com.example.soptin.util.DiffCallback

class MonthYearAdapter(
    val context: Context
) : ListAdapter<String, MonthYearAdapter.RetrospectViewHolder>(
    MonthYearDiffCallback
) {

    private var onItemClickListener: OnItemClickListener? = null
    private lateinit var binding: ItemBottomSheetRetrospectBinding
    private var selectedPosition = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrospectViewHolder {
        binding = ItemBottomSheetRetrospectBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RetrospectViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RetrospectViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    interface OnItemClickListener {
        fun onItemClick(item: String, position: Int)
    }

    fun setOnItemClickListener(listener: MonthYearAdapter.OnItemClickListener) {
        this.onItemClickListener = listener
    }

    inner class RetrospectViewHolder(private val binding: ItemBottomSheetRetrospectBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(a: String) {
            binding.tvMonthYear.text = a
            binding.executePendingBindings()

            binding.root.setOnClickListener {

                onItemClickListener?.onItemClick(a, absoluteAdapterPosition)
                if (selectedPosition != absoluteAdapterPosition) {
                    binding.setChecked()
                    selectedPosition = absoluteAdapterPosition
                }
            }
        }
    }

    private fun ItemBottomSheetRetrospectBinding.setChecked() =
        tvMonthYear.setBackgroundResource(R.drawable.background_select_month)// 선택되었을 때 배경 설정

    companion object {
        private val MonthYearDiffCallback =
            DiffCallback<String>(id = { old, new -> old == new })
    }
}

