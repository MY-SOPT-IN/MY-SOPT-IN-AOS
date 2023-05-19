package com.example.soptin.presentation.retrospect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.soptin.databinding.ActivityUpdateRetrospectBinding

class UpdateRetrospectActivity : AppCompatActivity() {

    private lateinit var binding : ActivityUpdateRetrospectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateRetrospectBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}