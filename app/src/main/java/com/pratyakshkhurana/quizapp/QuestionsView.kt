package com.pratyakshkhurana.quizapp


//Questions Data Class
data class QuestionsView(
    val id:Int,
    val question: String,
    val option1:String,
    val option2:String,
    val option3:String,
    val option4:String,
    val correct:Int
    )
