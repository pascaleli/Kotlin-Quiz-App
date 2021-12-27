package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.WindowInsetsCompat

import androidx.core.view.ViewCompat

import androidx.core.view.WindowInsetsControllerCompat




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


// Creating a validation

        val btnStart = findViewById<Button>(R.id.btn_start)

        val txtName = findViewById<TextView>(R.id.txt_name)

        btnStart.setOnClickListener {
            if (txtName.text.toString().isEmpty()) {
                Toast.makeText(
                    this,
                    "Please we need your name to progress in this APP",
                    Toast.LENGTH_SHORT
                ).show()
            }
            else{
                val intent = Intent(this,QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.USERNAME,txtName.text.toString())
                startActivity(intent)
                finish()
            }
        }


    }

}