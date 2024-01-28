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

        power1TextView = findViewById(R.id.power1)
        power2TextView = findViewById(R.id.power2)
        power3TextView = findViewById(R.id.power3)

        totalScoreTextView = findViewById(R.id.totalScore)
        totalPointsTextView = findViewById(R.id.totalPoints)

        val correct = intent.getIntExtra("correct", 0)
        val totalPoints = UserPointsManager.getTotalPoints()

        // Fetch and display powers
        powers = Powers().fetchPowers(totalPoints)
        displayPowers(powers)

        totalScoreTextView.text = "Your new total is: $totalPoints Points!"
        totalPointsTextView.text = "You gained: $correct Points!" // Display points gained from the current roun

        btnFinish.setOnClickListener {
            val intent = Intent(this, QuizCategories::class.java)
            startActivity(intent)
        }

        // Handle power clicks
        power1TextView.setOnClickListener { handlePowerClick(powers[0]) }
        power2TextView.setOnClickListener { handlePowerClick(powers[1]) }
        power3TextView.setOnClickListener { handlePowerClick(powers[2]) }

    }

    private fun handlePowerClick(power: Power) {
        // Deduct points for the selected power
        UserPointsManager.deductPoints(power.cost)

        // Update the total score text
        totalPointsTextView.text = "Your new total is: ${UserPointsManager.getTotalPoints()} Points!"

        // Disable the clicked power
        disablePower(power)

        // Check if the user can afford the other two powers
        val totalPoints = UserPointsManager.getTotalPoints()
        powers.forEach { otherPower ->
            if (otherPower != power && otherPower.cost > totalPoints) {
                disablePower(otherPower)
            }
        }
    }

    private fun disablePower(power: Power) {
        when (power.id) {
            1 -> disablePowerCard(power1Background)
            2 -> disablePowerCard(power2Background)
            3 -> disablePowerCard(power3Background)
            // Add more cases if needed
        }

        when (power.id) {
            1 -> power1TextView.isEnabled = false
            2 -> power2TextView.isEnabled = false
            3 -> power3TextView.isEnabled = false
            // Add more cases if needed
        }
    }

    private fun disablePowerCard(cardView: CardView) {
        // Disable the card view
        cardView.isEnabled = false

        // Change the background color of the disabled card view
        cardView.setCardBackgroundColor(ContextCompat.getColor(this, R.color.disabledColor))
    }

    private fun displayPowers(powers: List<Power>) {
        if (powers.size >= 3) {
            val power1Text = "${powers[0].name}\n\n${powers[0].description}\n\n${powers[0].cost} points"
            val power2Text = "${powers[1].name}\n\n${powers[1].description}\n\n${powers[1].cost} points"
            val power3Text = "${powers[2].name}\n\n${powers[2].description}\n\n${powers[2].cost} points"

            power1TextView.text = power1Text
            power2TextView.text = power2Text
            power3TextView.text = power3Text
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}