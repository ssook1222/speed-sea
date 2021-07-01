package com.kotlin.speedsea

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*
import kotlin.concurrent.timer

class eighteenActivity : AppCompatActivity() {
    private var time = 10
    private var timerTask: Timer? = null
    private var sec: Int? = null

    private lateinit var one: Button
    private lateinit var two: Button
    private lateinit var three: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_eighteen)
        startTimer()

        one = findViewById(R.id.one) as Button
        one.setOnClickListener {
            var toastMsg = Toast.makeText(this, "틀렸습니다.", Toast.LENGTH_SHORT)
            toastMsg.show()
        }
        two = findViewById(R.id.two) as Button
        two.setOnClickListener {
            var toastMsg = Toast.makeText(this, "스테이지 클리어!", Toast.LENGTH_SHORT)
            toastMsg.show()
            timerTask?.cancel()
            var intent = Intent(this, thirdActivity::class.java)
            startActivity(intent)
        }
        three = findViewById(R.id.three) as Button
        three.setOnClickListener {
            var toastMsg = Toast.makeText(this, "틀렸습니다.", Toast.LENGTH_SHORT)
            toastMsg.show()
        }
    }

    private fun startTimer() {
        timerTask = timer(period = 10){
            time--;
            val timer = findViewById(R.id.timer) as TextView
            sec = 10 + (time / 100)
            runOnUiThread {
                timer.text = "${sec}"
            }
            Log.d("남은 시간","띠용"+sec)
            if(sec==0){
                timerTask?.cancel();
                val handler = Handler(Looper.getMainLooper())
                handler.postDelayed(Runnable {
                    Toast.makeText(
                        this@eighteenActivity,
                        "실패!",
                        Toast.LENGTH_SHORT
                    ).show()
                }, 0)
                var retry = Intent(this@eighteenActivity, thirteenActivity::class.java)
                startActivity(retry)
            }
        }
    }
    override fun onBackPressed() {
        val builder: android.app.AlertDialog.Builder = android.app.AlertDialog.Builder(this@eighteenActivity)
        builder.setMessage("정말로 종료하시겠습니까?")
        builder.setTitle("종료 알림창")
            .setCancelable(false)
            .setPositiveButton("Yes",
                DialogInterface.OnClickListener { dialogInterface, i -> finish()
                    val intent = Intent(this,MyService::class.java)
                    stopService(intent)})
            .setNegativeButton("No",
                DialogInterface.OnClickListener { dialogInterface, i -> dialogInterface.cancel() })
        val alert: android.app.AlertDialog? = builder.create().also {
            it.setTitle("종료 알림창")
            it.show()
        }
    }
}
