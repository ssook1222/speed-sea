package com.kotlin.speedsea

import android.content.DialogInterface
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
            overridePendingTransition(0, 0);
        }
    }

    override fun onBackPressed() {
        val builder: android.app.AlertDialog.Builder = android.app.AlertDialog.Builder(this@fiveActivity)
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
