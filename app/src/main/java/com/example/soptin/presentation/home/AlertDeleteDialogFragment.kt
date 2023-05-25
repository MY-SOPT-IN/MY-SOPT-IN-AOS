package com.example.soptin.presentation.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.example.soptin.R
import com.example.soptin.databinding.ItemDeleteAlertBinding
import com.example.soptin.presentation.collectretrospectives.BottomSheetListner
import com.example.soptin.util.ViewModelFactory

interface dialogListner {
    fun onDialogResult()
}

class AlertDeleteDialogFragment :DialogFragment() {
    private var _binding: ItemDeleteAlertBinding? = null
    private val binding: ItemDeleteAlertBinding
        get() = requireNotNull(_binding) { "binding is null..." }
    private var routineId:Int? = null // 리스트 아이템값
    private val viewModel: RoutineViewModel by viewModels { ViewModelFactory(requireContext()) }
    private var dialogListner: dialogListner? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        routineId = arguments?.getInt("routineId")
        _binding = ItemDeleteAlertBinding.inflate(inflater, container, false)
        return binding.root
    }
    fun DialogListener(listener: dialogListner) {
        this.dialogListner = listener
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("routineId","$routineId") // 이거 이용해서 삭제 api 구현해주세요~

        binding.btnDeleteCancel.setOnClickListener {
            dismiss()
        }
        binding.btnDeleteOk.setOnClickListener {
            viewModel.deleteRoutine(routineId!!)
            dialogListner?.onDialogResult()
            dismiss()
        }


    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    override fun onResume() {
        super.onResume()

    }
}