package com.example.databinding

import androidx.lifecycle.ViewModelProvider
import androidx.databinding.DataBindingUtil
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val factory = ViewModelProvider.NewInstanceFactory()
        val viewModel = ViewModelProvider(this, factory).get<CountLiveDataViewModel>(CountLiveDataViewModel::class.java)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.apply {
            viewmodel = viewModel
            setLifecycleOwner(this@MainActivity)
        }
    }
}
