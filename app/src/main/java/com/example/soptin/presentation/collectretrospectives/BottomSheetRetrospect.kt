package com.example.soptin.presentation.collectretrospectives

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.soptin.R
import com.example.soptin.databinding.FragmentBottomsheetRetrospectBinding
import com.example.soptin.util.getNowMonth
import com.example.soptin.util.toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter

interface BottomSheetListner {
    fun onBottomSheetResult(month: Int)
}

class BottomSheetDialog(private val context: Context) : BottomSheetDialogFragment() {

    private val adapter = MonthYearAdapter(context)
    private lateinit var binding: FragmentBottomsheetRetrospectBinding
    private var bottomSheetListner: BottomSheetListner? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBottomsheetRetrospectBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun getTheme(): Int = R.style.AppBottomSheetDialogTheme
    fun setCheckDialogListener(listener: BottomSheetListner) {
        this.bottomSheetListner = listener
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val a = getNowMonth()
        var month: Int
        binding.rvBottomsheetRetro.adapter = adapter.apply {
            submitList(a)
            setOnItemClickListener(object : MonthYearAdapter.OnItemClickListener {
                override fun onItemClick(item: String, position: Int) {
                    val input = "$item"
                    val regex = """\d+년 (\d+)월""".toRegex()
                    month = regex.find(input)?.groupValues?.getOrNull(1)?.toInt()!!
                    onClick(month)
                }
            })
        }
    }

    private fun onClick(month: Int) {
        with(binding) {
            btnBottomRetroSelect.setOnClickListener {
                viewLifecycleOwner.lifecycleScope.launch {
                    val job = async {
                        bottomSheetListner?.onBottomSheetResult(month)
                    }
                    job.await()
                    dismiss()
                }
            }
        }

    }
}