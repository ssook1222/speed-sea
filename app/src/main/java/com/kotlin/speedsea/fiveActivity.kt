package com.kotlin.speedsea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button

class fiveActivity : AppCompatActivity() {

    private lateinit var son: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_five)

        son = findViewById(R.id.son) as Button
        son.setOnClickListener {
            var intent = Intent(this, sixActivity::class.java)
            startActivity(intent)
        }
    }
}
