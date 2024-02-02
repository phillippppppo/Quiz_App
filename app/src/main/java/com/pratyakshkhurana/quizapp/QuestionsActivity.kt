package com.pratyakshkhurana.quizapp

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.Typeface
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.view.animation.DecelerateInterpolator
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.questions_activity2.*

// Klasse für die Fragenaktivität, implementiert den View.OnClickListener
class QuestionsActivity : AppCompatActivity(), View.OnClickListener {

    // Variablen für den aktuellen Fragen-Index, ausgewählte Option, Fragenliste und korrekte Antworten
    private var mSelectOptionPosition: Int = 0
    private var mCurrentQuestionIndex: Int = 1
    private lateinit var mQuestionList: ArrayList<QuestionsView>
    private lateinit var category: String
    private var mCorrectAnswers: Int = 0


    // UI-Elemente
    private lateinit var mQuestion: TextView
    private lateinit var mProgressbar: ProgressBar
    private lateinit var mRating: TextView
    private lateinit var mOption1: TextView
    private lateinit var mOption2: TextView
    private lateinit var mOption3: TextView
    private lateinit var mOption4: TextView
    private lateinit var mSubmitButton: TextView

    // Musik-Effekte
    private lateinit var right: MediaPlayer
    private lateinit var wrong: MediaPlayer


    // Shared Preferences für die App-Daten
    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.questions_activity2)

        // Initialisierung der UI-Elemente
        sharedPreferences = getSharedPreferences("QuizApp", MODE_PRIVATE)

        mQuestion = tvQuestion
        mProgressbar = progressBar
        mRating = rating
        mOption1 = option1
        mOption2 = option2
        mOption3 = option3
        mOption4 = option4
        mSubmitButton = submitButton

        // Intent-Extras abrufen und Fragenliste für die ausgewählte Kategorie laden
        category = intent.getStringExtra("category").toString()
        mQuestionList = Questions().fetchDataForCategory(category)

        // Erste Frage anzeigen
        setQuestion()

        // Click-Listener für Optionen und Submit-Button hinzufügen
        mOption1.setOnClickListener(this)
        mOption2.setOnClickListener(this)
        mOption3.setOnClickListener(this)
        mOption4.setOnClickListener(this)
        mSubmitButton.setOnClickListener(this)

        // Musik-Effekte für richtige und falsche Antworten initialisieren
        right = MediaPlayer.create(this, R.raw.right)
        wrong = MediaPlayer.create(this, R.raw.w)


    }

    // Methode zur Anzeige der aktuellen Frage
    @SuppressLint("SetTextI18n")
    private fun setQuestion() {

        // Zurücksetzen der UI-Elemente auf den Standardzustand
        resetToDefaultOptions()

        // Submit-Button deaktivieren und grau hinterlegen
        mSubmitButton.isEnabled = false
        mSubmitButton.background = ContextCompat.getDrawable(this, R.drawable.gray_out_bg)

        // Aktuelle Frage abrufen
        val currentQuestion = mQuestionList[mCurrentQuestionIndex - 1]

        // Prüfen, ob es noch weitere Fragen gibt
        if (mCurrentQuestionIndex <= mQuestionList.size) {
            mSubmitButton.text = "SUBMIT"

            mSubmitButton.isEnabled = false
            mSubmitButton.background = ContextCompat.getDrawable(this, R.drawable.gray_out_bg)
        }

        // Animationsmethode für den Fortschrittsbalken aufrufen
        setProgressAnimate(mProgressbar,mCurrentQuestionIndex)

        // UI-Elemente mit den Daten der aktuellen Frage füllen
        mRating.text = "${mCurrentQuestionIndex}/${mQuestionList.size}"
        mQuestion.text = currentQuestion.question
        mOption1.text = currentQuestion.option1
        mOption2.text = currentQuestion.option2
        mOption3.text = currentQuestion.option3
        mOption4.text = currentQuestion.option4
    }

    // Methode zum Zurücksetzen der UI-Elemente auf den Standardzustand
    private fun resetToDefaultOptions() {
        // Liste aller Optionen erstellen
        val allOptions = arrayListOf<TextView>()
        allOptions.add(mOption1)
        allOptions.add(mOption2)
        allOptions.add(mOption3)
        allOptions.add(mOption4)
        mOption1.background = ContextCompat.getDrawable(this, R.drawable.bg1)
        mOption2.background = ContextCompat.getDrawable(this, R.drawable.bg2)
        mOption3.background = ContextCompat.getDrawable(this, R.drawable.bg3)
        mOption4.background = ContextCompat.getDrawable(this, R.drawable.bg4)

        // Hintergrund und Stil der Optionen zurücksetzen
        for (option in allOptions) {
            option.setTextColor(Color.parseColor("#FFFFFF"))
            option.typeface = Typeface.DEFAULT
        }
    }

    // Methode zur Hervorhebung der ausgewählten Option
    private fun selectedOptionView(tv: TextView, selectedOptionPosition: Int) {
        resetToDefaultOptions()
        mSelectOptionPosition = selectedOptionPosition

        // Submit-Button aktivieren und Hintergrund ändern
        mSubmitButton.isEnabled = true
        mSubmitButton.background = ContextCompat.getDrawable(this, R.drawable.submit_active_bg) // Replace with your actual active drawable resource

        // Textfarbe, Stil und Hintergrund der ausgewählten Option ändern
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_clicked_bg
        )
    }

    // Methode zur Hervorhebung der ausgewählten Option
    @SuppressLint("SetTextI18n")
    override fun onClick(view: View) {

        // Methode je nach ausgewähltem UI-Element ausführen
        if (view == mOption1) {
            selectedOptionView(mOption1, 1)
        } else if (view == mOption2) {
            selectedOptionView(mOption2, 2)
        } else if (view == mOption3) {
            selectedOptionView(mOption3, 3)
        } else if (view == mOption4) {
            selectedOptionView(mOption4, 4)
        } else if (view == mSubmitButton) {

            // Handhaben des Klicks auf den Submit-Button aufrufen

            // Prüfen, ob eine Option ausgewählt wurde
            if (mSelectOptionPosition == 0) {
                // Wenn keine Option ausgewählt wurde, zur nächsten Frage wechseln
                mCurrentQuestionIndex++

                if (mCurrentQuestionIndex <= mQuestionList.size) {
                    // Alle Optionen für die nächste Frage aktivieren
                    setQuestion()
                    option1.isEnabled=true
                    option2.isEnabled=true
                    option3.isEnabled=true
                    option4.isEnabled=true
                } else {
                    // Wenn alle Fragen beantwortet wurden, zur Ergebnisaktivität wechseln
                    val intent = Intent(this, ResultActivity::class.java)
                    intent.putExtra("correct", mCorrectAnswers)
                    intent.putExtra("total", 10)
                    startActivity(intent)
                    finish()

                    // Update total score in memory
                    UserPointsManager.setTotalPoints(UserPointsManager.getTotalPoints() + mCorrectAnswers)

                }

            } else {
                // Wenn eine Option ausgewählt wurde
                val quest = mQuestionList[mCurrentQuestionIndex - 1]
                var wrongAns = 0

                // Prüfen, ob die ausgewählte Option korrekt ist
                if (quest.correct != mSelectOptionPosition) {
                    // Wenn falsch, falschen Sound abspielen und falsche Option deaktivieren
                    wrong.start()
                    wrongAns = mSelectOptionPosition
                    option1.isEnabled=false
                    option2.isEnabled=false
                    option3.isEnabled=false
                    option4.isEnabled=false
                } else {
                    // Wenn richtig, richtigen Sound abspielen, richtige Option deaktivieren und korrekte Antworten erhöhen
                    right.start()
                    mCorrectAnswers++
                    option1.isEnabled=false
                    option2.isEnabled=false
                    option3.isEnabled=false
                    option4.isEnabled=false
                }

                // Hervorhebung der ausgewählten und korrekten Optionen
                for (i in 1..4){
                    when (i) {
                        wrongAns -> {
                            selectedOptionView(i, R.drawable.wrong_option_clicked_bg)
                        }
                        quest.correct -> {
                            selectedOptionView(i, R.drawable.correct_option_clicked_bg)
                        }
                        else -> {
                            selectedOptionView(i,R.drawable.other_options_not_clicked)
                        }
                    }
                }

                // Text des Submit-Buttons aktualisieren basierend auf der aktuellen Frage
                if (mCurrentQuestionIndex == mQuestionList.size) {
                    mSubmitButton.text = "FINISH"
                } else {
                    mSubmitButton.text = "NEXT"
                }

                // Zurücksetzen der ausgewählten Optionen
                mSelectOptionPosition = 0

            }


        }
    }

    // Methode zum Hervorheben der ausgewählten Option
    private fun selectedOptionView(answer: Int, drawableView: Int) {

        when (answer) {
            1 -> {
                mOption1.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2 -> {
                mOption2.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3 -> {
                mOption3.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4 -> {
                mOption4.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }

    // Methode zum Animieren des Fortschrittsbalkens
    private fun setProgressAnimate(pb: ProgressBar, progressTo: Int) {
        val animation = ObjectAnimator.ofInt(pb, "progress", pb.progress, progressTo * 10)
        animation.duration = 500
        animation.interpolator = DecelerateInterpolator()
        animation.start()
    }
}


