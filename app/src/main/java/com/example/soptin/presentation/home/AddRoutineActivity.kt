package com.example.soptin.presentation.home

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.soptin.MainActivity
import com.example.soptin.R
import com.example.soptin.databinding.ActivityAddRoutineBinding

class AddRoutineActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddRoutineBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddRoutineBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clickToolbarBtnBack()
        clickImageChange()


    }

    private fun clickToolbarBtnBack() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                val intent = Intent(this, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                finish()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun clickImageChange() {
        var isMorning = true
        var isAfternoon = true
        var isNight = true



        with(binding) {

            ivMorning.setOnClickListener {
                if (isMorning) {
                    ivMorning.setImageResource(R.drawable.ic_morning_off)
                    isMorning = false
                } else {
                    ivMorning.setImageResource(R.drawable.ic_morning_on)
                    isMorning = true
                }
            }


            ivAfternoon.setOnClickListener {
                if (isAfternoon) {
                    ivAfternoon.setImageResource(R.drawable.ic_afternoon_off)
                    isAfternoon = false
                } else {
                    ivAfternoon.setImageResource(R.drawable.ic_afternoon_on)
                    isAfternoon = true
                }
            }

            ivNight.setOnClickListener {
                if (isNight) {
                    ivNight.setImageResource(R.drawable.ic_night_off)
                    isNight = false
                } else {
                    ivNight.setImageResource(R.drawable.ic_night_on)
                    isNight = true
                }
            }


        }

    }
}
