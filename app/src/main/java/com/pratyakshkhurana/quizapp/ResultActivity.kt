package com.pratyakshkhurana.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.category_button.cardView
import kotlinx.android.synthetic.main.result_activity.*


// Aktivität zur Anzeige von Quizergebnissen und Powers
class ResultActivity : AppCompatActivity() {

    private lateinit var power1TextView: TextView
    private lateinit var power2TextView: TextView
    private lateinit var power3TextView: TextView

    private lateinit var totalScoreTextView: TextView
    private lateinit var totalPointsTextView: TextView

    private lateinit var powers: ArrayList<Power>

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result_activity)

        // UI-Elemente initialisieren
        power1TextView = findViewById(R.id.power1)
        power2TextView = findViewById(R.id.power2)
        power3TextView = findViewById(R.id.power3)

        totalScoreTextView = findViewById(R.id.totalScore)
        totalPointsTextView = findViewById(R.id.totalPoints)

        // Ergebnisse und Punkte aus dem Intent extrahieren
        val correct = intent.getIntExtra("correct", 0)
        val totalPoints = UserPointsManager.getTotalPoints()

        // Powers abrufen und anzeigen
        powers = Powers().fetchPowers(totalPoints)
        displayPowers(powers)

        // Texte für Gesamtpunktzahl und Punktegewinn aktualisieren
        totalScoreTextView.text = "Your new total is: $totalPoints Points!"
        totalPointsTextView.text = "You gained: $correct Points!" // Display points gained from the current roun

        // Button-Click-Handler für Zurück zum Kategoriewahl-Bildschirm
        btnFinish.setOnClickListener {
            val intent = Intent(this, QuizCategories::class.java)
            startActivity(intent)
        }

        // Click-Handler für Powers
        power1TextView.setOnClickListener { handlePowerClick(powers[0]) }
        power2TextView.setOnClickListener { handlePowerClick(powers[1]) }
        power3TextView.setOnClickListener { handlePowerClick(powers[2]) }

    }

    // Methode zur Verarbeitung von Klicks auf Superkräfte
    private fun handlePowerClick(power: Power) {
        // Punkte für ausgewählten Powers abziehen
        UserPointsManager.deductPoints(power.cost)

        // Gesamtpunktzahl aktualisieren
        totalPointsTextView.text = "Your new total is: ${UserPointsManager.getTotalPoints()} Points!"

        // Ausgewählte Power deaktivieren
        disablePower(power)

        // Prüfen, ob der Benutzer sich die anderen beiden Powers leisten kann
        val totalPoints = UserPointsManager.getTotalPoints()
        powers.forEach { otherPower ->
            if (otherPower != power && otherPower.cost > totalPoints) {
                disablePower(otherPower)
            }
        }
    }

    // Methode zur Deaktivierung einer Power
    private fun disablePower(power: Power) {
        // Abhängig von der ID der Power die zugehörige UI-Komponente deaktivieren
        when (power.id) {
            1 -> disablePowerCard(power1Background)
            2 -> disablePowerCard(power2Background)
            3 -> disablePowerCard(power3Background)
        }
        // Abhängig von der ID der Power den zugehörigen TextView deaktivieren
        when (power.id) {
            1 -> power1TextView.isEnabled = false
            2 -> power2TextView.isEnabled = false
            3 -> power3TextView.isEnabled = false
        }
    }

    // Methode zur Deaktivierung einer CardView für eine Power
    private fun disablePowerCard(cardView: CardView) {
        // CardView deaktivieren
        cardView.isEnabled = false

        // Hintergrundfarbe des deaktivierten CardViews ändern
        cardView.setCardBackgroundColor(ContextCompat.getColor(this, R.color.disabledColor))
    }

    // Methode zur Anzeige der Power
    private fun displayPowers(powers: List<Power>) {
        // Wenn mindestens drei Powers vorhanden sind, Texte für die TextViews setzen
        if (powers.size >= 3) {
            val power1Text = "${powers[0].name}\n\n${powers[0].description}\n\n${powers[0].cost} points"
            val power2Text = "${powers[1].name}\n\n${powers[1].description}\n\n${powers[1].cost} points"
            val power3Text = "${powers[2].name}\n\n${powers[2].description}\n\n${powers[2].cost} points"

            power1TextView.text = power1Text
            power2TextView.text = power2Text
            power3TextView.text = power3Text
        }
    }

    // Übersteuern der Zurück-Taste, um die Aktivität zu beenden
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}