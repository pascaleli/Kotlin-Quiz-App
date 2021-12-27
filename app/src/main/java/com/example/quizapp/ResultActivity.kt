package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val username = intent.getStringExtra(Constants.USERNAME)
        val totalQuestion = intent.getIntExtra(Constants.Total_Questions,0)
        val correctAnswer = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)

       val tvUsername = findViewById<TextView>(R.id.tv_name)
        val tvScore = findViewById<TextView>(R.id.tv_score)
        val btnFinish = findViewById<Button>(R.id.btn_finish)

        tvScore.text = "Your Score is $correctAnswer Out of  $totalQuestion"
        tvUsername.text = username
        btnFinish.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }


    }
}