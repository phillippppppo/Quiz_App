package com.pratyakshkhurana.quizapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.quiz_categories_activity.recyclerView

class QuizCategories : AppCompatActivity(), OnClicked {
    private lateinit var categoryList: ArrayList<CategoryView>
    private lateinit var userName: String
    private lateinit var categorySelected: String
    private lateinit var builder : AlertDialog.Builder
    private lateinit var alertDialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quiz_categories_activity)


        userName = intent.getStringExtra("user").toString()
        //recycler view needs layout manager
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        categoryList = fetchCategories()
        recyclerView.adapter = CategoriesAdapter(categoryList, this)
    }

    // TODO Missing Resources
    private fun fetchCategories(): ArrayList<CategoryView> {
        val data: ArrayList<CategoryView> = ArrayList()

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

    //through interface in adapter class
    override fun categoryClicked(s: CategoryView) {
        showDialog(s)
    }

    //Dialog for Quiz Category selection
    private fun showDialog(s: CategoryView) {
        val dialogLayout = layoutInflater.inflate(R.layout.explanation_dialog, null)
        builder = AlertDialog.Builder(this)
        dialogLayout.findViewById<View>(R.id.okButton).setOnClickListener {
            categorySelected = s.category
            alertDialog.dismiss()
            val intent = Intent(this, QuestionsActivity::class.java)
            intent.putExtra("user", userName)
            intent.putExtra("category", categorySelected)
            startActivity(intent)
        }
        dialogLayout.findViewById<View>(R.id.okButton).setOnClickListener {
            categorySelected = s.category
            alertDialog.dismiss()

            val intent = Intent(this, QuestionsActivity::class.java)
            intent.putExtra("user", userName)
            intent.putExtra("category", categorySelected)
            startActivity(intent)
        }
        builder.setView(dialogLayout)
        alertDialog = builder.create()
        alertDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        alertDialog.show()
    }
}