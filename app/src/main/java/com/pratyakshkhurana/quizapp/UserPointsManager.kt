package com.pratyakshkhurana.quizapp

object UserPointsManager {
    private var totalPoints = 0

    fun getTotalPoints(): Int {
        return totalPoints
    }

    fun setTotalPoints(points: Int) {
        totalPoints = points
    }

    fun deductPoints(cost: Int) {
        totalPoints -= cost
    }
}