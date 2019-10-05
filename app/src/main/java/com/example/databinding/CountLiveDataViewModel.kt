package com.example.databinding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountLiveDataViewModel : ViewModel() {
    val text: MutableLiveData<String> = MutableLiveData()

    var count: Int = 0
        set(value) {
            field = Math.max(0, value)
            text.value = field.toString()
        }


    init {
        reset()
    }

    fun reset() {
        count = 0
    }

    fun onCountUp() {
        count++
    }

    fun onCountDown() {
        count--
    }

    fun onCountReset() {
        reset()
    }
}