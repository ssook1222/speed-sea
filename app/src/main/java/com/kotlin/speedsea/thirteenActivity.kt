
package com.kotlin.speedsea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*
import kotlin.concurrent.timer

class thirteenActivity : AppCompatActivity() {
    private  var time = 60
    private var timerTask : Timer? = null

    private lateinit var one: Button
    private lateinit var two: Button
    private lateinit var three: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_thirteen)
        startTimer()

        one = findViewById(R.id.one) as Button
        one.setOnClickListener {
            var intent = Intent(this, fourteenActivity::class.java)
            intent.putExtra("timer",time)
            startActivity(intent)
        }
        two = findViewById(R.id.two) as Button
        two.setOnClickListener {
            var toastMsg = Toast.makeText(this, "틀렸습니다.", Toast.LENGTH_SHORT)
            toastMsg.show()
        }
        three = findViewById(R.id.three) as Button
        three.setOnClickListener {
            var toastMsg = Toast.makeText(this, "틀렸습니다.", Toast.LENGTH_SHORT)
            toastMsg.show()
        }
    }
    private fun startTimer(){
        timerTask=timer(period=10){
            time--;
            val timer=findViewById(R.id.timer) as TextView
            val sec=time/100
            runOnUiThread{
                timer.text = "${sec}"
            }
        }
    }
}
