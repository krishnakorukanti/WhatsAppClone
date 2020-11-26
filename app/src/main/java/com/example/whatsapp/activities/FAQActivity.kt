package com.example.whatsapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.whatsapp.R

class FAQActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_f_a_q)
        title = "FAQ"
        val webView = findViewById<WebView>(R.id.fAQWebView)
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://faq.whatsapp.com/web?lang=en")
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
    }
}