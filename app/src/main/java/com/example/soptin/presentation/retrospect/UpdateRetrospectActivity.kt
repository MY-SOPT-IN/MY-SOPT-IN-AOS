package com.example.soptin.presentation.retrospect

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.soptin.data.model.ResponseCollectRetrospectDto
import com.example.soptin.data.model.RetrospectDto
import com.example.soptin.databinding.ActivityUpdateRetrospectBinding
import com.example.soptin.presentation.collectretrospectives.CollectRetrospectiveActivity
import com.example.soptin.presentation.collectretrospectives.RetrospectViewModel
import com.example.soptin.util.ViewModelFactory

class UpdateRetrospectActivity : AppCompatActivity() {

    private lateinit var binding : ActivityUpdateRetrospectBinding

    private val viewModel: RetrospectViewModel by viewModels { ViewModelFactory(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateRetrospectBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clickToolbarBtnBack()

        val Intent = intent
        val retrospectId = Intent.getIntExtra("id",0)
        binding.btnUpdate.setOnClickListener {
            viewModel.putRetrospect(retrospectId, RetrospectDto("오늘 먹은 밥 최고!","오늘 루틴 최고",
            "오늘 하루 수고  많았다.",null,true,null,"2023-05-19"))
        }
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

