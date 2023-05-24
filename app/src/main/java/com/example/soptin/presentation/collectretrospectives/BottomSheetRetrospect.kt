package com.example.soptin.presentation.collectretrospectives

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.soptin.R
import com.example.soptin.databinding.FragmentBottomsheetRetrospectBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.coroutines.async
import kotlinx.coroutines.launch


class BottomSheetDialog() : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentBottomsheetRetrospectBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBottomsheetRetrospectBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun getTheme(): Int = R.style.AppBottomSheetDialogTheme

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun onClick() {
        with(binding) {
            btnBottomRetroSelect.setOnClickListener {
                Log.d("test", "success")
                viewLifecycleOwner.lifecycleScope.launch {
                    val job = async {
                    }
                    job.await()
                    dismiss()
                }
            }
        }

    }
}