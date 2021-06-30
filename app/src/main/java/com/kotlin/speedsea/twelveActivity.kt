package com.kotlin.speedsea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button

class twelveActivity : AppCompatActivity() {

    private lateinit var next: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_twelve)

        next = findViewById(R.id.next) as Button
        next.setOnClickListener {
            var intent = Intent(this, thirteenActivity::class.java)
            startActivity(intent)
        }
    }
}