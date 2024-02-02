package com.pratyakshkhurana.quizapp

// Ein Objekt, um den Punktestand des Benutzers zu verwalten
object UserPointsManager {
    // Private Variable für den gesamten Punktestand
    private var totalPoints = 0

    // Methode zum Abrufen des aktuellen Gesamtpunktestands
    fun getTotalPoints(): Int {
        return totalPoints
    }

    // Methode zum Setzen des Gesamtpunktestands
    fun setTotalPoints(points: Int) {
        totalPoints = points
    }

    // Methode zum Abziehen von Punkten basierend auf den Kosten
    fun deductPoints(cost: Int) {
        totalPoints -= cost
    }
}