package com.example.whatsapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.whatsapp.R

class ContactUsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_us)

        title = "Contact Us"
        val webView = findViewById<WebView>(R.id.contactUsWebView)
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://web.whatsapp.com/")
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
    }
}