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

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class CallsFragment : Fragment() {
    private val modelList = ArrayList<Calls_1>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View= inflater.inflate(R.layout.fragment_calls, container, false)
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