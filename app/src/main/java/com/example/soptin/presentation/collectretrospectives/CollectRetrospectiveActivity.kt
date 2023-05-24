package com.example.soptin.presentation.collectretrospectives

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.soptin.R
import com.example.soptin.databinding.ActivityCollectRetrospectiveBinding
import com.example.soptin.databinding.ActivityMainBinding

class CollectRetrospectiveActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCollectRetrospectiveBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_collect_retrospective)
    }
}