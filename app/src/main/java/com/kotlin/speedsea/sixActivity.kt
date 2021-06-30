package com.kotlin.speedsea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button

class sixActivity : AppCompatActivity() {

    private lateinit var mom: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_six)

        mom = findViewById(R.id.mom) as Button
        mom.setOnClickListener {
            var intent = Intent(this, sevenActivity::class.java)
            startActivity(intent)
        }
    }
}
