package com.kotlin.speedsea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button

class fourActivity : AppCompatActivity() {

    private lateinit var left: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_four)

        left = findViewById(R.id.left) as Button
        left.setOnClickListener {
            var intent = Intent(this, thirdActivity::class.java)
            startActivity(intent)
        }
    }
}
