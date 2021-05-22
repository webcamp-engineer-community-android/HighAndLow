package com.example.hignandlow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val tag = "high and low"
    private var yourCard = 0
    private var droidCard = 0
    private var hitCount = 0
    private var loseCount = 0
    private var gameStart = false
    private var answerd = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        hitCount = 0
        loseCount = 0
        hitText.text = getString(R.string.hit_text)
        loseText.text = getString(R.string.lose_text)
        gameStart = true
        drawCard()
    }

    private fun drawCard() {
        // カード表示
        yourCardImage.setImageResource(R.drawable.z02)
        droidCardImage.setImageResource(R.drawable.z01)

        // 乱数生成
        yourCard = (1..13).random()
        Log.d(tag, "You:" + yourCard)
        when (yourCard) {
            1 -> yourCardImage.setImageResource(R.drawable.d01)
            2 -> yourCardImage.setImageResource(R.drawable.d02)
            3 -> yourCardImage.setImageResource(R.drawable.d03)
            4 -> yourCardImage.setImageResource(R.drawable.d04)
            5 -> yourCardImage.setImageResource(R.drawable.d05)
            6 -> yourCardImage.setImageResource(R.drawable.d06)
            7 -> yourCardImage.setImageResource(R.drawable.d07)
            8 -> yourCardImage.setImageResource(R.drawable.d08)
            9 -> yourCardImage.setImageResource(R.drawable.d09)
            10 -> yourCardImage.setImageResource(R.drawable.d10)
            11 -> yourCardImage.setImageResource(R.drawable.d11)
            12 -> yourCardImage.setImageResource(R.drawable.d12)
            13 -> yourCardImage.setImageResource(R.drawable.d13)
        }
        droidCard = (1..13).random()
        Log.d(tag, "droid:" + droidCard)
        answerd = false
    }
}