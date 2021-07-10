package com.example.hignandlow

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_launch.*

class LaunchActivity: AppCompatActivity() {

    private val handler = Handler()
    private val runnable = Runnable {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)

        startButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // 8秒後、自動遷移
        handler.postDelayed(runnable, 8000)
    }

    override fun onResume() {
        super.onResume()

        handler.postDelayed(runnable, 8000)
    }
}