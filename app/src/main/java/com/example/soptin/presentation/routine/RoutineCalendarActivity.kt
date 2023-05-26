package com.example.soptin.presentation.routine

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.soptin.MainActivity
import com.example.soptin.databinding.ActivityRoutineCalendarBinding

class RoutineCalendarActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRoutineCalendarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoutineCalendarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clickToolbarBtnBack()
    }

    private fun clickToolbarBtnBack(){
        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                val intent = Intent(this, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}