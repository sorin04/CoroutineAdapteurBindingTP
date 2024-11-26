package com.example.etudiants

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.etudiants.databinding.ActivityMainBinding
import com.example.etudiants.view_model.EtuViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var viewModel : EtuViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this)[EtuViewModel::class.java]
        binding.lifecycleOwner = this@MainActivity
        binding.liveData = viewModel
        viewModel.initData()
    }
}