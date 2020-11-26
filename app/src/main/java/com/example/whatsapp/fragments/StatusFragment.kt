package com.example.whatsapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.whatsapp.R
import com.example.whatsapp.adapter.CallsAdapter
import com.example.whatsapp.adapter.StatusAdapter
import com.example.whatsapp.data.CallsModel
import com.example.whatsapp.data.StatusModel
import kotlinx.android.synthetic.main.fragment_calls.*
import kotlinx.android.synthetic.main.fragment_status.*

class StatusFragment : Fragment() {
    private val modelList = ArrayList<StatusModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_status, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        buildModelList()
        val statusAdapter = StatusAdapter(modelList)
        recyclerStatus.layoutManager = LinearLayoutManager(this.context)
        recyclerStatus.adapter = statusAdapter
    }

    private fun buildModelList() {
        modelList.add(StatusModel(R.drawable.john, "John"))
        modelList.add(StatusModel(R.drawable.john, "John"))
        modelList.add(StatusModel(R.drawable.john, "John"))
        modelList.add(StatusModel(R.drawable.john, "John"))
        modelList.add(StatusModel(R.drawable.john, "John"))
        modelList.add(StatusModel(R.drawable.john, "John"))
        modelList.add(StatusModel(R.drawable.john, "John"))
        modelList.add(StatusModel(R.drawable.john, "John"))
        modelList.add(StatusModel(R.drawable.john, "John"))
        modelList.add(StatusModel(R.drawable.john, "John"))
    }
}