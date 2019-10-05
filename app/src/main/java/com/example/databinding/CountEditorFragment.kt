package com.example.databinding

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import java.lang.NumberFormatException

class CountEditorFragment : Fragment() {

    private lateinit var viewModel: CountLiveDataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /* https://developer.android.com/topic/libraries/architecture/viewmodel */
        viewModel = activity?.run {
            val factory = ViewModelProvider.NewInstanceFactory()
            ViewModelProvider(this, factory).get<CountLiveDataViewModel>(CountLiveDataViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.count_editor_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val countEditor = view.findViewById<EditText>(R.id.countEditor).apply {
            hint = "0 - ${Integer.MAX_VALUE}"
        }

        view.findViewById<Button>(R.id.countApply).setOnClickListener {
            countEditor.text.also {
                if(it.isNotEmpty()) {
                    try {
                        viewModel.count = Integer.parseInt(it.toString())
                    } catch (_: NumberFormatException) { }
                }
            }
        }
    }
}