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
    private var selectedPosition = RecyclerView.NO_POSITION

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrospectViewHolder {
        binding = ItemBottomSheetRetrospectBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RetrospectViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RetrospectViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it, position) }
    }

    interface OnItemClickListener {
        fun onItemClick(item: String, position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.onItemClickListener = listener
    }

    inner class RetrospectViewHolder(private val binding: ItemBottomSheetRetrospectBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(a: String, position: Int) {
            binding.tvMonthYear.text = a
            binding.executePendingBindings()

            if (selectedPosition == position) {
                binding.setChecked()
            } else {
                binding.setUnchecked()
            }

            binding.root.setOnClickListener {
                if (selectedPosition != position) {
                    val previousSelectedPosition = selectedPosition
                    selectedPosition = position
                    notifyItemChanged(previousSelectedPosition)
                    notifyItemChanged(selectedPosition)
                    onItemClickListener?.onItemClick(a, position)
                }
            }
        }
    }

    private fun ItemBottomSheetRetrospectBinding.setChecked() {
        tvMonthYear.setBackgroundResource(R.drawable.background_select_month)
        tvMonthYear.setTextColor(context.getColor(R.color.black))
    }

    private fun ItemBottomSheetRetrospectBinding.setUnchecked() {
        tvMonthYear.setBackgroundResource(0)
        tvMonthYear.setTextColor(context.getColor(R.color.gray_700))
    }

    companion object {
        private val MonthYearDiffCallback = DiffCallback<String>(id = { old, new -> old == new })
    }
}