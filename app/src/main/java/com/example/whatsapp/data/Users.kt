package com.example.whatsapp.data

data class Users(
    val profileName: String,
    val profilePhone: Int,
    val profileAbout: String,
    val profileId: String
) {
    constructor() : this("", 0, "", "")
}
