package com.pratyakshkhurana.quizapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.enterNameEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, QuizCategories::class.java)
        intent.putExtra("user", enterNameEditText.text.toString())
        startActivity(intent)
    }

    override fun onBackPressed() {
        moveTaskToBack(true)
    }

}