package com.example.soptin.presentation.retrospect

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.soptin.databinding.ActivityUpdateRetrospectBinding
import com.example.soptin.presentation.collectretrospectives.CollectRetrospectiveActivity

class UpdateRetrospectActivity : AppCompatActivity() {

    private lateinit var binding : ActivityUpdateRetrospectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateRetrospectBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clickToolbarBtnBack()

        val Intent = intent
        val retrospectId = Intent.getIntExtra("id",0)
    }


    private fun clickToolbarBtnBack(){
        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                val intent = Intent(this,CollectRetrospectiveActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}

