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
        val writtenDate = Intent.getStringExtra("writtenDate")
        val routine = Intent.getStringExtra("routine")
        val best = Intent.getStringExtra("best")
        val self = Intent.getStringExtra("self")
        binding.etRoutineRetro.setText(routine)
        binding.etTodayGood.setText(best)
        binding.etTalkMyself.setText(self)
        binding.tvPutDate.text = writtenDate
        binding.btnUpdate.setOnClickListener {
            with(binding) {
                viewModel.putRetrospect(
                    retrospectId, RetrospectDto(
                        etTodayGood.text.toString(), etRoutineRetro.text.toString(),
                        etTalkMyself.text.toString(), null, true, null, tvPutDate.text.toString()
                    )
                )
            }
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

