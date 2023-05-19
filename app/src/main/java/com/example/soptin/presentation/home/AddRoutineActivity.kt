package com.example.soptin.presentation.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.soptin.databinding.ActivityAddRoutineBinding

class AddRoutineActivity : AppCompatActivity() {
    private lateinit var binding:ActivityAddRoutineBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddRoutineBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}