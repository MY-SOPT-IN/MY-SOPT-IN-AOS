package com.example.soptin.presentation.AddRoutine

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.soptin.MainActivity
import com.example.soptin.databinding.ActivityUpdateRetrospectBinding

class UpdateRoutineActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateRetrospectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateRetrospectBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clickToolbarBtnBack()
    }

    private fun clickToolbarBtnBack() {
        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
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