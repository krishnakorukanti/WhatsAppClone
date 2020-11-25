package com.example.whatsapp.data

data class Users(
    val profileName: String,
    val profilePhone: String,
    val profileAbout: String,
    val profileId: String?
) {
    constructor() : this(" ", "", "", "")
}
