package com.example.soptin.presentation.retrospect

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.soptin.MainActivity
import com.example.soptin.R
import com.example.soptin.databinding.FragmentRetrospectBinding
import com.example.soptin.presentation.home.AddRoutineActivity

class RetrospectFragment : Fragment() {

    private var _binding: FragmentRetrospectBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_retrospect, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnPlus.setOnClickListener {
            val intent = Intent(context,UpdateRetrospectActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }


}

