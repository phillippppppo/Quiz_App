package com.pratyakshkhurana.quizapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.quiz_categories_activity.recyclerView

// Aktivität für die Quiz-Kategorien
class QuizCategories : AppCompatActivity(), OnClicked {
    private lateinit var categoryList: ArrayList<CategoryView>
    private lateinit var categorySelected: String
    private lateinit var totalScoreText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quiz_categories_activity)

        // Überprüfen, ob die Aktivität mit einem Flag zum Zurücksetzen des Punktestands gestartet wurde
        val resetScore = intent.getBooleanExtra("resetScore", false)

        if (resetScore) {
            // Punktestand zurücksetzen, wenn die Kategorien von der MainActivity aus aufgerufen werden
            UserPointsManager.setTotalPoints(0)
        }

        // RecyclerView benötigt einen Layout Manager
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        // Kategorien abrufen
        categoryList = fetchCategories()

        // Adapter für die RecyclerView setzen
        recyclerView.adapter = CategoriesAdapter(categoryList, this)

        // TextView für den Gesamtpunktestand initialisieren und aktualisieren
        totalScoreText = findViewById(R.id.totalScoreText)
        updateTotalScore()
    }

    // Methode zur Aktualisierung des Gesamtpunktestands
    private fun updateTotalScore() {
        totalScoreText.text = "Total Score: ${UserPointsManager.getTotalPoints()}"
    }

    // Methode zum Abrufen der Kategorien
    private fun fetchCategories(): ArrayList<CategoryView> {
        val data: ArrayList<CategoryView> = ArrayList()

        // Kategorienobjekte erstellen und zur Liste hinzufügen
        val obj1 = ResourcesCompat.getDrawable(resources, R.drawable.bg1, null)?.let {
            ResourcesCompat.getDrawable(resources, R.drawable.music2, null)?.let { it1 ->
                CategoryView(
                    R.drawable.bg,
                    "Music",
                    it, it1
                )
            }
        }
        val obj2 = ResourcesCompat.getDrawable(resources, R.drawable.bg2, null)?.let {
            ResourcesCompat.getDrawable(resources, R.drawable.runner2, null)?.let { it1 ->
                CategoryView(
                    R.drawable.bg,
                    "Sports",
                    it, it1
                )
            }
        }
        val obj3 = ResourcesCompat.getDrawable(resources, R.drawable.bg3, null)?.let {
            ResourcesCompat.getDrawable(resources, R.drawable.art2, null)?.let { it1 ->
                CategoryView(
                    R.drawable.bg,
                    "Art",
                    it, it1
                )
            }
        }
        val obj4 = ResourcesCompat.getDrawable(resources, R.drawable.bg4, null)?.let {
            ResourcesCompat.getDrawable(resources, R.drawable.politics2, null)?.let { it1 ->
                CategoryView(
                    R.drawable.bg,
                    "Politics",
                    it, it1
                )
            }
        }
        val obj5 = ResourcesCompat.getDrawable(resources, R.drawable.bg5, null)?.let {
            ResourcesCompat.getDrawable(resources, R.drawable.history2, null)?.let { it1 ->
                CategoryView(
                    R.drawable.bg,
                    "History",
                    it, it1
                )
            }
        }
        val obj6 = ResourcesCompat.getDrawable(resources, R.drawable.bg6, null)?.let {
            ResourcesCompat.getDrawable(resources, R.drawable.experiment2, null)?.let { it1 ->
                CategoryView(
                    R.drawable.bg,
                    "Science",
                    it, it1
                )
            }
        }

        if (obj1 != null) {
            data.add(obj1)
        }
        if (obj2 != null) {
            data.add(obj2)
        }
        if (obj3 != null) {
            data.add(obj3)
        }
        if (obj4 != null) {
            data.add(obj4)
        }
        if (obj5 != null) {
            data.add(obj5)
        }
        if (obj6 != null) {
            data.add(obj6)
        }
        return data

    }

    // Implementierung der Methode aus dem Interface OnClicked
    override fun categoryClicked(s: CategoryView) {
        categorySelected = s.category
        val intent = Intent(this, QuestionsActivity::class.java)
        intent.putExtra("category", categorySelected)
        startActivity(intent)

    }
}