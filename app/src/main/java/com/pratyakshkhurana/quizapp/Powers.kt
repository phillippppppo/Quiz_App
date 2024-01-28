package com.pratyakshkhurana.quizapp

data class Power(val id: Int, val name: String, val description: String, val cost: Int)

class Powers {


    fun fetchPowers(userPoints: Int): ArrayList<Power> {
        val allPowers = getAllPowers()
        val affordablePowers = allPowers.filter { it.cost <= userPoints }
        val selectedPowers = mutableListOf<Power>()

        // Shuffle the list of affordable powers
        val shuffledPowers = affordablePowers.shuffled()

        // Select the first three powers
        for (i in 0 until 3) {
            if (i < shuffledPowers.size) {
                // Assign an ID (1 to 3) to each power
                selectedPowers.add(shuffledPowers[i].copy(id = i + 1))
            }
        }

        return ArrayList(selectedPowers)
    }

    private fun getAllPowers(): List<Power> {
        // Fetch powers from your data source (or create them)
        val powers = ArrayList<Power>()

        // Economy Powers:

        // 0 Cost:

        powers.add(Power(0, "Name 1", "This is the description for Power 1. Econ", 0))
        powers.add(Power(0, "Name 2", "This is the description for Power 2. Econ", 0))
        powers.add(Power(0, "Name 3", "This is the description for Power 3. Econ", 0))

        // 1Cost:

        powers.add(Power(0, "Name 7", "This is the description for Power 1.", 1))
        powers.add(Power(0, "Name 8", "This is the description for Power 2.", 1))
        powers.add(Power(0, "Name 9", "This is the description for Power 3.", 1))

        // Other Powers:

        // 0 Cost:

        powers.add(Power(0, "Name 4", "This is the description for Power 1.", 0))
        powers.add(Power(0, "Name 5", "This is the description for Power 2.", 0))
        powers.add(Power(0, "Name 6", "This is the description for Power 3.", 0))

        // 1Cost:

        powers.add(Power(0, "Name 10", "This is the description for Power 1.", 1))
        powers.add(Power(0, "Name 11", "This is the description for Power 2.", 1))
        powers.add(Power(0, "Name 12", "This is the description for Power 3.", 1))

        return powers
    }
}