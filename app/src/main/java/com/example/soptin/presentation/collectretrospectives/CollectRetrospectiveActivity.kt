package com.example.soptin.presentation.collectretrospectives

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.soptin.MainActivity
import com.example.soptin.R
import com.example.soptin.databinding.ActivityCollectRetrospectiveBinding
import com.example.soptin.presentation.retrospect.RetrospectViewModel
import com.example.soptin.presentation.retrospect.RetrostpectAdapter
import com.example.soptin.presentation.update_retrospect.UpdateRetrospectActivity
import com.example.soptin.util.EventObserver
import com.example.soptin.util.ViewModelFactory

class CollectRetrospectiveActivity : AppCompatActivity(), BottomSheetListner {

    private lateinit var binding: ActivityCollectRetrospectiveBinding
    private val viewModel: RetrospectViewModel by viewModels { ViewModelFactory(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_collect_retrospective)
        val adapter = RetrostpectAdapter(viewModel)

        //달 선택 만들면 추후에 바꿈 현재는 하드
        viewModel.getRetrospect(5)
        setRespectAdapter(adapter)
        onClickCalendar()
        onBackButton()
        sharedRetrospectDto()

    }

    private fun sharedRetrospectDto() {
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

    private fun onBackButton() {
        binding.toolbarCollectBack.setNavigationOnClickListener {
            Intent(this, MainActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(this)
            }
        }
    }

    private fun onClickCalendar() {
        binding.ivCalendar.setOnClickListener {
            val bottomSheetFragment = BottomSheetDialog(this)
            bottomSheetFragment.setCheckDialogListener(this)
            bottomSheetFragment.show(supportFragmentManager, "childFragmentManager")
        }
    }

    private fun setRespectAdapter(adapter: RetrostpectAdapter) {
        viewModel.retrospectDto.observe(this) {
            binding.rvRetrospect.adapter = adapter.apply {
                submitList(it)
            }
        }
    }

    override fun onBottomSheetResult(month: Int) {
        viewModel.getRetrospect(month)
    }

}