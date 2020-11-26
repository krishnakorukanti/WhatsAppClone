package com.example.whatsapp.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.whatsapp.R
import com.example.whatsapp.adapter.ChatScreenAdapter
import com.example.whatsapp.data.Chats
import com.example.whatsapp.data.Users
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_chat.*

class ChatActivity : AppCompatActivity() {
    private var chatList = mutableListOf<Chats>()
    private lateinit var chatAdapter: ChatScreenAdapter
    private var receiverId: String? = null
    private lateinit var databaseReference: DatabaseReference
    private var userList = mutableListOf<Users>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        profile_backarrow.setOnClickListener(View.OnClickListener {
            val intent_home = Intent(this, HomeActivity::class.java)
            startActivity(intent_home)
        })
        setRecyclerAdapter()
        receiverId = intent.getStringExtra("chats")
        databaseReference = FirebaseDatabase.getInstance().getReference("Users")

        /**
         * Get the node where the users are stored in database and fetch all the users and display it
         * in a recycler view where a user can click a particular participant and start chatting
         */
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                // userList.clear()
                for (i in snapshot.children) {
                    val user: Users = i.getValue(Users::class.java)!!
                    /*
                    Do not show yourself into the participant list
                     */
                    if (user.profileId == receiverId) {
                        toolBarName.text = user.profileName
                    }
                }

            }

            override fun onCancelled(error: DatabaseError) {
            }

        })

        btnSendMsg.setOnClickListener {

            val chatsMessage = Chats(
                typeMsg.text.toString().trim(),
                System.currentTimeMillis().toString(),
                Firebase.auth.uid!!, receiverId!!

            )
            FirebaseDatabase.getInstance().reference.child("messages").push().setValue(chatsMessage)
            typeMsg.setText("")
        }
        readMessages()
    }

    private fun readMessages() {
        FirebaseDatabase.getInstance().getReference("messages")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    chatList.clear()
                    for (i in snapshot.children) {
                        val chat: Chats = i.getValue(Chats::class.java)!!

                        /*
                        The below condition will show the messages that are related to a sender and participant
                         */
                        if ((chat.receiver == Firebase.auth.currentUser?.uid && chat.sender == receiverId)
                            || chat.receiver == receiverId && chat.sender == Firebase.auth.currentUser?.uid
                        ) {
                            chatList.add(chat)
                        }
                    }

                    chatAdapter.updateList(chatList)
                    /*
                    This will scroll the recycler view to the bottom position when every new message
                    comes
                     */
                    recyclerChatCon.scrollToPosition(chatList.size - 1)
                }

                override fun onCancelled(error: DatabaseError) {

                }

            })
    }

    private fun setRecyclerAdapter() {
        val linearLayoutManager = LinearLayoutManager(this)
        chatAdapter = ChatScreenAdapter(chatList)
        recyclerChatCon.apply {
            layoutManager = linearLayoutManager
            adapter = chatAdapter
        }
    }
}