package com.example.whatsapp.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.whatsapp.R
import com.example.whatsapp.RecyclerViewItemClicked
import com.example.whatsapp.activities.ChatActivity
import com.example.whatsapp.activities.HomeActivity
import com.example.whatsapp.adapter.ChatsAdapter
import com.example.whatsapp.data.Users
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_chat.*
import kotlinx.android.synthetic.main.fragment_chats.*


class ChatsFragment : Fragment(), RecyclerViewItemClicked {
    private lateinit var databaseReference: DatabaseReference
    private var userList = mutableListOf<Users>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_chats, container, false)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databaseReference = FirebaseDatabase.getInstance().getReference("Users")

        /**
         * Get the node where the users are stored in database and fetch all the users and display it
         * in a recycler view where a user can click a particular participant and start chatting
         */
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                userList.clear()
                for (i in snapshot.children) {
                    val user: Users = i.getValue(Users::class.java)!!
                    /*
                    Do not show yourself into the participant list
                     */
                    if (user.profileId != Firebase.auth.currentUser?.uid) {
                        userList.add(user)
                    }
                }
                setAdapter()
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })
    }
    private fun setAdapter() {
        val linearLayoutManager = LinearLayoutManager(activity)
        val userAdapter = ChatsAdapter(userList, this)
        recyclerChats.apply {
            layoutManager = linearLayoutManager
            adapter = userAdapter
        }
    }
    override fun onItemClicked(position: Int, data: Any) {
        if (data is Users){
            val intent = Intent(activity,ChatActivity::class.java)
            intent.putExtra("chats",data.profileId)
            startActivity(intent)
        }

    }


}