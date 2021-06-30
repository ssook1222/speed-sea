package com.kotlin.speedsea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast

class secondActivity : AppCompatActivity() {

    private lateinit var battle: Button
    private lateinit var story: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_second)

        story = findViewById(R.id.story) as Button
        story.setOnClickListener {
            var intent = Intent(this, thirdActivity::class.java)
            startActivity(intent)
        }

        battle = findViewById(R.id.battle) as Button
        battle.setOnClickListener {
            var toastMsg = Toast.makeText(this, "추후 업데이트 할 예정입니다.", Toast.LENGTH_SHORT)
            toastMsg.show()
        }
    }
}
