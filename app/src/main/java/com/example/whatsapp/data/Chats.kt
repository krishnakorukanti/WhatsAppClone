package com.example.whatsapp.data

data class Chats(
    val message: String, val timeStamp: String, val sender: String, val receiver: String
) {
    constructor() : this("a", "b", "", "")
}
