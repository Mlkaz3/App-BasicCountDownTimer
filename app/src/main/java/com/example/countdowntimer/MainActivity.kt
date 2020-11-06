package com.example.countdowntimer

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //create val and assign to the startButton & timeCount in xml
        val startButton: Button = findViewById(R.id.startButton)
        val timeCountDownTimer:TextView = findViewById(R.id.timeCount)

        //setting button settings
        startButton.setOnClickListener {
            //set the button to counting
            startButton.text = "Counting.."
            //create a countdown timer of 30 seconds
            object : CountDownTimer(30000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    timeCountDownTimer.text = "seconds remaining: " + millisUntilFinished / 1000
                }

                override fun onFinish() {
                    timeCountDownTimer.text = "Times Up!"
                    startButton.text = "START TIMER"
                }
            }.start()

        }
    }
}