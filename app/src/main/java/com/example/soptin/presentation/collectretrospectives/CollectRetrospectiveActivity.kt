package com.example.soptin.presentation.collectretrospectives

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.soptin.MainActivity
import com.example.soptin.R
import com.example.soptin.databinding.ActivityCollectRetrospectiveBinding
import com.example.soptin.databinding.ActivityMainBinding
import com.example.soptin.presentation.home.HomeAdapter
import com.example.soptin.presentation.home.RoutineViewModel
import com.example.soptin.presentation.retrospect.RetrospectFragment
import com.example.soptin.presentation.retrospect.UpdateRetrospectActivity
import com.example.soptin.util.EventObserver
import com.example.soptin.util.ViewModelFactory
import kotlinx.serialization.SerialName

class CollectRetrospectiveActivity : AppCompatActivity() , BottomSheetListner{

    private lateinit var binding: ActivityCollectRetrospectiveBinding
    private val viewModel: RetrospectViewModel by viewModels { ViewModelFactory(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_collect_retrospective)
        val adapter = RetrostpectAdapter(viewModel)

        //달 선택 만들면 추후에 바꿈 현재는 하드
        viewModel.getRetrospect(5)

        viewModel.retrospectDto.observe(this){
            binding.rvRetrospect.adapter = adapter.apply {
                submitList(it)
            }
        }

        binding.ivCalendar.setOnClickListener {
            val bottomSheetFragment = BottomSheetDialog(this)
            bottomSheetFragment.setCheckDialogListener(this)
            bottomSheetFragment.show(supportFragmentManager, "childFragmentManager")
        }

        binding.toolbarCollectBack.setNavigationOnClickListener {
            Intent(this, MainActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(this)
            }
        }
        viewModel.retrospectId.observe(this, EventObserver {
            Intent(this, UpdateRetrospectActivity::class.java).apply {
                putExtra("id", it.retrospectId)
                putExtra("writtenDate", it.writtenDate)
                putExtra("routine", it.descRoutine)
                putExtra("best", it.descBest)
                putExtra("self", it.descSelf)
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                setResult(RESULT_OK)
                startActivity(this)
            }
        })
    }

    override fun onBottomSheetResult(month:Int) {
        viewModel.getRetrospect(month)
    }

}