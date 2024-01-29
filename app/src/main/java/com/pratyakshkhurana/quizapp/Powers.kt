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

        // 0 Cost:
        powers.add(Power(0, "Taking a L", "Take 1 Sip", 0))
        powers.add(Power(1, "Taking a W", "Take 1 Sip", 0))
        powers.add(Power(2, "One for the Boys", "Take 1 Sip", 0))

        // 1 Cost:
        powers.add(Power(19, "The Gift", "Target player gives 1 Sip to another player.", 1))
        powers.add(Power(24, "Guessing Game", "Guess how many questions target player has answered correctly during this round. If you guess correct, give 2 Sips to other players", 1))

        // 2 Cost:
        powers.add(Power(3, "Piling On", "Target a player. If he answered 4 or less questions correctly during the last round of questions. Target player takes 2 Sips, if not take 1 Sip.", 2))
        powers.add(Power(20, "Trojan Drink", "Target player gives 1 Sip to another player. If they choose you they take 3 Sips instead.", 2))

        // 3 Cost:
        powers.add(Power(4, "One for the Road", "Target player takes 1 Sip.", 3))
        powers.add(Power(5, "The Masochist", "Take 3 Sips, target player takes 2 Sips.", 3))
        powers.add(Power(6, "Left Handed", "Target player has to drink with his non dominant hand. Every time he does not, he takes 1 Sip.", 3))
        powers.add(Power(7, "High Society", "Until the end of the next round, any player who does not address another player with Mr. / Ms. takes 1 Sip.", 3))
        powers.add(Power(18, "Tongue Twister", "Target player has to say a tongue twister. if they fail, they take 2 Sips.", 3))
        powers.add(Power(22, "Unlucky Number 2", "Target player must avoid saying the number 2 until the start of the 5th round after this was used. Each time they fail, they take 1 Sip.", 3))
        powers.add(Power(21, "Payback", "Counts the Sips you get during this round. At the end of the round give that many Sips to other players", 3))

        // 4 Cost:
        powers.add(Power(8, "Democracy", "Ask a would you rather question to all other players. Count down and vote. Players voting for the minority take 2 Sips.", 4))
        powers.add(Power(9, "RPS Duel", "Challenge another player to RPS. The looser takes 2 Sips.", 4))
        powers.add(Power(10, "Give and Take", "Empty your drink, target 2 players who take 2 Sips.", 4))

        // 5 Cost:
        powers.add(Power(11, "The Gamble", "Challenge another player to call a coin and toss it. If he calls right take 1 Sip, if he calls wrong he takes 3 sips.", 5))
        powers.add(Power(12, "Double Trouble", "Give 1 Sip to 2 players.", 5))

        // 6 Cost:
        powers.add(Power(13, "Share the pain", "Whenever you take a Sip target player has to take the same number of Sips until the start of the 3nd round after this was used.", 6))
        powers.add(Power(23, "Betting Game", "Make two players play RPS and declare who you think will win. The looser takes 2 Sips. If you predicted correctly give 1 Sip to another player", 6))

        // 8 Cost:
        powers.add(Power(14, "Group Effort", "Give 1 Sip to every player, including yourself.", 8))
        powers.add(Power(24, "Doing the Cosby", "Mix the next drink for target player. If they guess 1 of the ingredients they give 1 Sip to another player", 8))

        // 10 Cost:
        powers.add(Power(15, "The Party Pooper", "Give 1 Sip to every player, except yourself.", 10))

        // 15 Cost:
        powers.add(Power(16, "Risky Business", "Challenge target player to RPS. The looser empties his drink.", 15))

        // 20 Cost:
        powers.add(Power(17, "Fresh Start", "Target player has to empty his Drink.", 20))

        return powers
    }
}