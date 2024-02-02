package com.pratyakshkhurana.quizapp

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.media.Image
import android.widget.ImageView
import androidx.cardview.widget.CardView

// CategoryView Data Class
data class CategoryView(
    val image: Int,
    val category: String,
    val cardImage: Drawable,
    val icon: Drawable
)
