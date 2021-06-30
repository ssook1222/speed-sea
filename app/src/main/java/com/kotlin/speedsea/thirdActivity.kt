package com.kotlin.speedsea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast

class thirdActivity : AppCompatActivity() {

    private lateinit var stage1: Button
    private lateinit var stage2: Button
    private lateinit var right: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_third)

        right = findViewById(R.id.right) as Button
        right.setOnClickListener {
            var intent = Intent(this, fourActivity::class.java)
            startActivity(intent)
        }

        stage1 = findViewById(R.id.stage1) as Button
        stage1.setOnClickListener {
            var intent = Intent(this, fiveActivity::class.java)
            startActivity(intent)
        }

        stage2 = findViewById(R.id.stage2) as Button
        stage2.setOnClickListener {
            var toastMsg = Toast.makeText(this, "추후 업데이트 할 예정입니다.", Toast.LENGTH_SHORT)
            toastMsg.show()
        }
    }
}
