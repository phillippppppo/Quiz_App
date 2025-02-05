package com.pratyakshkhurana.quizapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var builder : AlertDialog.Builder
    private lateinit var alertDialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get a reference to the buttonStart TextView
        val buttonStart = findViewById<TextView>(R.id.buttonStart)

        val showExplanationButton = findViewById<TextView>(R.id.showHintTextView)

        // Set an OnClickListener on the buttonStart TextView
        buttonStart.setOnClickListener {
            // Intent to start QuizCategories activity
            val intent = Intent(this@MainActivity, QuizCategories::class.java)
            // Reset score when restarting the app
            intent.putExtra("resetScore", true)
            startActivity(intent)
        }

        // Set an OnClickListener on the showExplanation TextView
        showExplanationButton.setOnClickListener {
            showDialog()
        }

    }

    // Methode zur Anzeige des Dialogs mit der Erklärung
    private fun showDialog() {
        val dialogLayout = layoutInflater.inflate(R.layout.explanation_dialog, null)
        builder = AlertDialog.Builder(this)
        // OnClickListener für den OK-Button im Dialog
        dialogLayout.findViewById<View>(R.id.okButton).setOnClickListener {
            alertDialog.dismiss()
        }
        builder.setView(dialogLayout)
        alertDialog = builder.create()
        alertDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        alertDialog.show()
    }

    // Übersteuern der Zurück-Taste, um die App zu minimieren
    override fun onBackPressed() {
        moveTaskToBack(true)
    }

}