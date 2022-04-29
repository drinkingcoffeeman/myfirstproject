package com.hwkim.becarefulbang.contentsList

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.hwkim.becarefulbang.R
//웹뷰 보이게 하는 액티비티

class ContentShowActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_content_show)

        val getUrl = intent.getStringExtra("url")


        val webView : WebView = findViewById(R.id.webView)
        webView.loadUrl(getUrl.toString()) //웹뷰안에 url 집어넣음



    }
}

