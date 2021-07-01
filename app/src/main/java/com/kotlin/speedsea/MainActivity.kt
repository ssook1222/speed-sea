package com.kotlin.speedsea

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.speedsea.MainActivity


class MainActivity : AppCompatActivity() {
    private lateinit var start: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, secondActivity::class.java)
        val musicintent = Intent(this,MyService::class.java)
        startService(musicintent)

        start = findViewById(R.id.start) as Button
        start.setOnClickListener {
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        val builder: android.app.AlertDialog.Builder = android.app.AlertDialog.Builder(this@MainActivity)
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
