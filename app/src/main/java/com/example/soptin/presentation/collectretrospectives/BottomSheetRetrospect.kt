package com.example.soptin.presentation.collectretrospectives

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.soptin.R
import com.example.soptin.databinding.FragmentBottomsheetRetrospectBinding
import com.example.soptin.util.ViewModelFactory
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

interface BottomSheetListner {
    fun onBottomSheetResult()
}

class BottomSheetDialog() : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentBottomsheetRetrospectBinding
    private var bottomSheetListner: BottomSheetListner? = null
    private val viewModel: RetrospectViewModel by viewModels { ViewModelFactory(requireContext()) }
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
        onClick()
    }

    private fun onClick() {
        with(binding) {
            btnBottomRetroSelect.setOnClickListener {
                viewLifecycleOwner.lifecycleScope.launch {
                    val job = async {
                        bottomSheetListner?.onBottomSheetResult()
                    }
                    job.await()
                    dismiss()
                }
            }
        }

    }
}