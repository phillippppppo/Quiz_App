package com.pratyakshkhurana.quizapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.category_button.view.*

// Adapter-Klasse für die RecyclerView zur Anzeige von Kategorien
class CategoriesAdapter(
    private val data: ArrayList<CategoryView>,
    private val listener: OnClicked
) :
    RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {

    // Methode zum Erstellen eines neuen ViewHolders
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        // Inflaten des Layouts für jeden Listeneintrag
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.category_button, parent, false)
        // Erstellen eines ViewHolders und Zuweisen des Klick-Listeners für die Kategorie
        val viewHolder = CategoriesViewHolder(view)
        view.setOnClickListener {
            listener.categoryClicked(data[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    // Methode zum Binden von Daten an einen ViewHolder
    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        // Aktuelle Kategorie aus der Datenliste abrufen
        val curr = data[position]
        // Daten in die UI-Elemente des ViewHolders setzen
        holder.categoryText.text = curr.category
        holder.card.background = curr.cardImage
        Glide.with(holder.itemView.context).load(curr.icon).into(holder.image)
    }

    // Methode zur Rückgabe der Anzahl von Elementen in der Datenliste
    override fun getItemCount(): Int {
        return data.size
    }

    // ViewHolder-Klasse für die RecyclerView
    class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val categoryText: TextView = view.categoryText
        val image: ImageView = view.image
        val card:CardView = view.cardView
    }

}

// Schnittstelle für den Klick-Listener der Kategorien
interface OnClicked {
    fun categoryClicked(s: CategoryView)

}