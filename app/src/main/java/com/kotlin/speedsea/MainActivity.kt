package com.kotlin.speedsea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var start: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, secondActivity::class.java)

        start = findViewById(R.id.start) as Button
        start.setOnClickListener {
            startActivity(intent)
        }
    }
}
