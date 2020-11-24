package com.example.whatsapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.whatsapp.R

class TermPolicyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_term_policyactivity)

        title = "Terms And Privacy Policy"
        val webView = findViewById<WebView>(R.id.termPolicyWebView)
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://www.whatsapp.com/legal/?lg=en")
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
    }
}