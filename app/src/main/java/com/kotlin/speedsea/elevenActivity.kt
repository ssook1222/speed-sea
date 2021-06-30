package com.kotlin.speedsea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button

class elevenActivity : AppCompatActivity() {

    private lateinit var next: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_eleven)

        next = findViewById(R.id.next) as Button
        next.setOnClickListener {
            var intent = Intent(this, twelveActivity::class.java)
            startActivity(intent)

        }
    }
}
