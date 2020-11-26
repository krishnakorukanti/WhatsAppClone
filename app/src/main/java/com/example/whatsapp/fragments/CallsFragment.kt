package com.example.whatsapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.whatsapp.R
import com.example.whatsapp.adapter.CallsAdapter
import com.example.whatsapp.data.CallsModel
import kotlinx.android.synthetic.main.fragment_calls.*

class CallsFragment : Fragment() {
    private val modelList = ArrayList<CallsModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_calls, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        buildModelList()
        val itemAdapter = CallsAdapter(modelList)
        recyclerCalls.layoutManager = LinearLayoutManager(this.context)
        recyclerCalls.adapter = itemAdapter
    }

    private fun buildModelList() {
        modelList.add(CallsModel(R.drawable.john, "John"))
        modelList.add(CallsModel(R.drawable.john, "John"))
        modelList.add(CallsModel(R.drawable.john, "John"))
        modelList.add(CallsModel(R.drawable.john, "John"))
        modelList.add(CallsModel(R.drawable.john, "John"))
        modelList.add(CallsModel(R.drawable.john, "John"))
        modelList.add(CallsModel(R.drawable.john, "John"))
        modelList.add(CallsModel(R.drawable.john, "John"))
        modelList.add(CallsModel(R.drawable.john, "John"))
        modelList.add(CallsModel(R.drawable.john, "John"))
        modelList.add(CallsModel(R.drawable.john, "John"))
        modelList.add(CallsModel(R.drawable.john, "John"))
        modelList.add(CallsModel(R.drawable.john, "John"))
        modelList.add(CallsModel(R.drawable.john, "John"))
        modelList.add(CallsModel(R.drawable.john, "John"))
        modelList.add(CallsModel(R.drawable.john, "John"))
        modelList.add(CallsModel(R.drawable.john, "John"))
        modelList.add(CallsModel(R.drawable.john, "John"))
        modelList.add(CallsModel(R.drawable.john, "John"))
        modelList.add(CallsModel(R.drawable.john, "John"))
        modelList.add(CallsModel(R.drawable.john, "John"))
        modelList.add(CallsModel(R.drawable.john, "John"))
        modelList.add(CallsModel(R.drawable.john, "John"))
        modelList.add(CallsModel(R.drawable.john, "John"))
        modelList.add(CallsModel(R.drawable.john, "John"))
        modelList.add(CallsModel(R.drawable.john, "John"))
        modelList.add(CallsModel(R.drawable.john, "John"))
        modelList.add(CallsModel(R.drawable.john, "John"))
    }
}