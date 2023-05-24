package com.example.soptin.presentation.collectretrospectives

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.soptin.R
import com.example.soptin.databinding.ActivityCollectRetrospectiveBinding
import com.example.soptin.databinding.ActivityMainBinding
import com.example.soptin.presentation.home.HomeAdapter
import com.example.soptin.presentation.home.RoutineViewModel
import com.example.soptin.util.ViewModelFactory

class CollectRetrospectiveActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCollectRetrospectiveBinding
    private val adapter = RetrostpectAdapter()
    private val viewModel: RetrospectViewModel by viewModels { ViewModelFactory(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_collect_retrospective)

        //달 선택 만들면 추후에 바꿈 현재는 하드
        viewModel.getRetrospect(5)

        viewModel.retrospectDto.observe(this){
            binding.rvRetrospect.adapter = adapter.apply {
                submitList(it)

            }
        }

    }
}