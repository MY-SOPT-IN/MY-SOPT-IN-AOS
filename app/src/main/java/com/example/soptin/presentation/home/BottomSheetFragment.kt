package com.example.soptin.presentation.home

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.soptin.R
import com.example.soptin.databinding.FragmentBottomsheetBinding
import com.example.soptin.databinding.ItemRoutineBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment(val routineId: Int) : BottomSheetDialogFragment() {
    private var _binding: FragmentBottomsheetBinding? = null
    private val binding: FragmentBottomsheetBinding

        get() = requireNotNull(_binding) { "binding is null" }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBottomsheetBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun getTheme(): Int = R.style.AppBottomSheetDialogTheme
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clickButton()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun clickButton() {
        with(binding) {
            ivClose.setOnClickListener {
                dismiss()
            }
            btnDelete.setOnClickListener {// routineId를 삭제 팝업창으로 넘김
                val bundle = Bundle()
                bundle.putInt("routineId",routineId)
                val alertDeleteDialogFragment = AlertDeleteDialogFragment()
                alertDeleteDialogFragment.arguments = bundle
                alertDeleteDialogFragment.show(parentFragmentManager,"TAG")
            }
            btnStatistics.setOnClickListener {
                val intent = Intent(activity,RoutineCalendarActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }
            btnEdit.setOnClickListener {
                val intent = Intent(activity,UpdateRoutineActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }
        }
    }


}