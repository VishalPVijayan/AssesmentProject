package com.vishalpvijayan.assesmentproject

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

class DataFragment : Fragment() {


    private lateinit var viewInitalizer : ViewModelInstailizer
    private lateinit var viewModel: DataViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.data_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val api = DataApi()
        val repository = DataRepository(api)

        viewInitalizer = ViewModelInstailizer(repository)
        viewModel = ViewModelProviders.of(this, viewInitalizer).get(DataViewModel ::class.java)
        
    }
}