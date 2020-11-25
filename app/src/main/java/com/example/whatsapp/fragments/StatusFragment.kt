package com.example.whatsapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.whatsapp.R
import com.example.whatsapp.adapter.CallsAdapter
import com.example.whatsapp.data.Calls_1
import kotlinx.android.synthetic.main.fragment_calls.*
import java.util.ArrayList


class StatusFragment : Fragment() {
    private val modelList = ArrayList<Calls_1>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
      val view:View=  inflater.inflate(R.layout.fragment_status, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        buildModelList()
        val itemAdapter = CallsAdapter(modelList)
        recycler_view. layoutManager = LinearLayoutManager(this.context)
        recycler_view.adapter = itemAdapter
    }

    private fun buildModelList() {
        modelList.add(Calls_1(R.drawable.john_1,"John"))
        modelList.add(Calls_1(R.drawable.john_1,"John"))
        modelList.add(Calls_1(R.drawable.john_1,"John"))
        modelList.add(Calls_1(R.drawable.john_1,"John"))
        modelList.add(Calls_1(R.drawable.john_1,"John"))
        modelList.add(Calls_1(R.drawable.john_1,"John"))
        modelList.add(Calls_1(R.drawable.john_1,"John"))
        modelList.add(Calls_1(R.drawable.john_1,"John"))
        modelList.add(Calls_1(R.drawable.john_1,"John"))
        modelList.add(Calls_1(R.drawable.john_1,"John"))
        modelList.add(Calls_1(R.drawable.john_1,"John"))
        modelList.add(Calls_1(R.drawable.john_1,"John"))
        modelList.add(Calls_1(R.drawable.john_1,"John"))
        modelList.add(Calls_1(R.drawable.john_1,"John"))
        modelList.add(Calls_1(R.drawable.john_1,"John"))
    }
}

