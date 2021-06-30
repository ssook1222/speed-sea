package com.kotlin.speedsea

import android.os.Bundle
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class fourteenActivity : AppCompatActivity() {

    private var timerTask : Timer? = null
    private var time:Int?=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_fourteen)

        var timeIntent = getIntent()
        time= timeIntent.getIntExtra("timer",60)
        var timer = findViewById(R.id.timer) as TextView
        timer.text=time.toString()
    }
}
