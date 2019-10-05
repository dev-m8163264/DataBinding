package com.example.databinding

import androidx.lifecycle.ViewModelProvider
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.databinding.databinding.CountButtonsFragmentBinding

class CountButtonsFragment : Fragment() {

    private lateinit var viewModel: CountLiveDataViewModel
    private lateinit var binding: CountButtonsFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /* https://developer.android.com/topic/libraries/architecture/viewmodel */
        viewModel = activity?.run {
            val factory = ViewModelProvider.NewInstanceFactory()
            ViewModelProvider(this, factory).get<CountLiveDataViewModel>(CountLiveDataViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.count_buttons_fragment, container, false)
        binding.viewmodel = viewModel
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.setLifecycleOwner(activity)
    }
}