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
    private var answered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hignBtn.setOnClickListener {
            if (gameStart && !answered) {
                hignAndLow('h')
            }
        }

        lowBtn.setOnClickListener {
            if (gameStart && !answered) {
                hignAndLow('l')
            }
        }

        nextBtn.setOnClickListener {
            if (gameStart) {
                drawCard()
            }
        }
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

    private fun hignAndLow(answer:Char) {
        answered = true
        val balance = droidCard - yourCard

        // 勝敗判定(1回毎)
        if (balance == 0) {
            // 処理なし
        } else if ((balance > 0) && (answer == 'h')) {
            hitCount++
            hitText.text = getString(R.string.hit_text) + hitCount
        } else if ((balance < 0) && (answer == 'l')) {
            hitCount++
            hitText.text = getString(R.string.hit_text) + hitCount
        } else {
            loseCount++
            loseText.text = getString(R.string.lose_text) + loseCount
        }

        // 勝敗判定(最終)
        if (hitCount == 5) {
            resultText.text = "あなたの勝ちです"
            gameStart = false
        } else if (loseCount == 5) {
            resultText.text = "あなたの負けです"
            gameStart = false
        } else {
            // 処理なし
        }
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
        answered = false
    }
}