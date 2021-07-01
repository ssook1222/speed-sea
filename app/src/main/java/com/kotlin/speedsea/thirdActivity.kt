package com.kotlin.speedsea

import android.content.DialogInterface
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
            overridePendingTransition(0, 0);
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

    override fun onBackPressed() {
        val builder: android.app.AlertDialog.Builder = android.app.AlertDialog.Builder(this@thirdActivity)
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
