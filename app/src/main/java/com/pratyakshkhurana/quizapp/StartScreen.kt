package com.pratyakshkhurana.quizapp


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class StartScreen : AppCompatActivity() {
    private var sharedPreferences: SharedPreferences?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_screen)

        // Initialisieren der SharedPreferences
        sharedPreferences=applicationContext.getSharedPreferences("pref", Context.MODE_PRIVATE)

        // Verzögertes Starten der MainActivity nach 1000 Millisekunden (1 Sekunde)
        Handler().postDelayed(
            {
                startActivity(Intent(applicationContext,MainActivity::class.java))
                finish()
            },1000
        )

    }
}