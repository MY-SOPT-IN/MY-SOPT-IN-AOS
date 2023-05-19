package com.example.soptin.presentation.home

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.soptin.MainActivity
import com.example.soptin.databinding.ActivityAddRoutineBinding

class AddRoutineActivity : AppCompatActivity() {
    private lateinit var binding:ActivityAddRoutineBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddRoutineBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)

        }


    }
}