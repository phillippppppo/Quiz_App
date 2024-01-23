package com.pratyakshkhurana.quizapp

class Questions {

    fun fetchDataForCategory(category: String): ArrayList<QuestionsView> {
        return when (category) {
            "Music" -> {
                // Music Category Questions
                createMusicQuestions()
            }
            "Sports" -> {
                // Sports Category Questions
                createSportsQuestions()
            }
            "Art" -> {
                // Art Category Questions
                createArtQuestions()
            }
            "Politics" -> {
                // Politics Category Questions
                createPoliticsQuestions()
            }
            // Add more cases for other categories as needed
            else -> {
                // Handle unknown category or add a default set of questions
                createDefaultQuestions()
            }
        }
    }

    private fun createMusicQuestions(): ArrayList<QuestionsView> {
        val musicQuestions = ArrayList<QuestionsView>()
        // Music Category Questions
        musicQuestions.add(QuestionsView(
            11,
            "Who is known as the 'King of Pop'?",
            "Michael Jackson",
            "Elvis Presley",
            "Prince",
            "Bob Marley",
            1
        ))
        musicQuestions.add(QuestionsView(
            11,
            "Who is known as the 'King of Pop'?",
            "Michael Jackson",
            "Elvis Presley",
            "Prince",
            "Bob Marley",
            1
        ))
        musicQuestions.add(QuestionsView(
            16,
            "Which band released the album 'Abbey Road'?",
            "The Rolling Stones",
            "The Beatles",
            "Led Zeppelin",
            "Pink Floyd",
            2
        ))
        musicQuestions.add(QuestionsView(
            17,
            "Who is the lead vocalist of the band Queen?",
            "Freddie Mercury",
            "Mick Jagger",
            "David Bowie",
            "Robert Plant",
            1
        ))
        musicQuestions.add(QuestionsView(
            18,
            "In which year did Elvis Presley pass away?",
            "1977",
            "1982",
            "1969",
            "1991",
            1
        ))
        musicQuestions.add(QuestionsView(
            19,
            "Which song by Michael Jackson is the best-selling single of all time?",
            "Thriller",
            "Billie Jean",
            "Black or White",
            "Beat It",
            1
        ))
        musicQuestions.add(QuestionsView(
            20,
            "What instrument did Jimi Hendrix play?",
            "Guitar",
            "Drums",
            "Piano",
            "Saxophone",
            1
        ))
        musicQuestions.add(QuestionsView(
            21,
            "Who is the 'Material Girl' in pop music?",
            "Celine Dion",
            "Britney Spears",
            "Madonna",
            "Lady Gaga",
            3
        ))
        musicQuestions.add(QuestionsView(
            22,
            "Which country is the origin of the Flamenco music and dance style?",
            "Italy",
            "Spain",
            "France",
            "Brazil",
            2
        ))
        musicQuestions.add(QuestionsView(
            23,
            "What is the title of Beyoncé's debut solo album?",
            "Dangerously in Love",
            "Lemonade",
            "B'Day",
            "I Am... Sasha Fierce",
            1
        ))
        // Add more music questions as needed
        return musicQuestions
    }

    private fun createSportsQuestions(): ArrayList<QuestionsView> {
        val sportsQuestions = ArrayList<QuestionsView>()
        // Question 1
        sportsQuestions.add(QuestionsView(
            12,
            "Which country won the FIFA World Cup in 2018?",
            "Brazil",
            "Germany",
            "France",
            "Spain",
            3
        ))

        // Question 2
        sportsQuestions.add(QuestionsView(
            25,
            "Which country has won the most Olympic gold medals in history?",
            "United States",
            "China",
            "Russia",
            "Germany",
            1
        ))

// Question 3
        sportsQuestions.add(QuestionsView(
            26,
            "Who is considered the 'GOAT' (Greatest of All Time) in tennis?",
            "Rafael Nadal",
            "Novak Djokovic",
            "Roger Federer",
            "Serena Williams",
            3
        ))

// Question 4
        sportsQuestions.add(QuestionsView(
            27,
            "In which sport would you perform a slam dunk?",
            "Soccer",
            "Basketball",
            "Golf",
            "Tennis",
            2
        ))

// Question 5
        sportsQuestions.add(QuestionsView(
            28,
            "Which country hosted the 2016 Summer Olympics?",
            "China",
            "Brazil",
            "Russia",
            "Japan",
            2
        ))

// Question 6
        sportsQuestions.add(QuestionsView(
            29,
            "Who holds the record for the most goals scored in a single football season?",
            "Lionel Messi",
            "Cristiano Ronaldo",
            "Pele",
            "Gerd Muller",
            4
        ))

// Question 7
        sportsQuestions.add(QuestionsView(
            30,
            "Which athlete is known as 'The Fastest Man on Earth'?",
            "Usain Bolt",
            "Michael Phelps",
            "Carl Lewis",
            "Jesse Owens",
            1
        ))

// Question 8
        sportsQuestions.add(QuestionsView(
            31,
            "In which sport would you perform a triple axel?",
            "Figure Skating",
            "Ski Jumping",
            "Gymnastics",
            "Ice Hockey",
            1
        ))

// Question 9
        sportsQuestions.add(QuestionsView(
            32,
            "Which country won the 2019 FIFA Women's World Cup?",
            "Germany",
            "United States",
            "France",
            "England",
            2
        ))

// Question 10
        sportsQuestions.add(QuestionsView(
            33,
            "Who is the all-time leading scorer in NBA history?",
            "LeBron James",
            "Kobe Bryant",
            "Michael Jordan",
            "Kareem Abdul-Jabbar",
            4
        ))
        // Add more sports questions as needed
        return sportsQuestions
    }

    private fun createArtQuestions(): ArrayList<QuestionsView> {
        val artQuestions = ArrayList<QuestionsView>()
        // Question 1
        artQuestions.add(QuestionsView(
            13,
            "Who painted the Mona Lisa?",
            "Pablo Picasso",
            "Leonardo da Vinci",
            "Vincent van Gogh",
            "Claude Monet",
            2
        ))
        // Question 2
        artQuestions.add(QuestionsView(
            16,
            "Which famous artist is known for cutting off his own ear?",
            "Pablo Picasso",
            "Vincent van Gogh",
            "Leonardo da Vinci",
            "Claude Monet",
            2
        ))

// Question 3
        artQuestions.add(QuestionsView(
            17,
            "In which country was the famous painter Frida Kahlo born?",
            "Mexico",
            "Spain",
            "Italy",
            "France",
            1
        ))

// Question 4
        artQuestions.add(QuestionsView(
            18,
            "Who created the sculpture 'The Thinker'?",
            "Auguste Rodin",
            "Michelangelo",
            "Pablo Picasso",
            "Leonardo da Vinci",
            1
        ))

// Question 5
        artQuestions.add(QuestionsView(
            19,
            "Which art movement is known for its use of bright colors and bold shapes?",
            "Impressionism",
            "Cubism",
            "Abstract Expressionism",
            "Fauvism",
            4
        ))

// Question 6
        artQuestions.add(QuestionsView(
            20,
            "Who painted 'Starry Night'?",
            "Vincent van Gogh",
            "Claude Monet",
            "Edvard Munch",
            "Pablo Picasso",
            1
        ))

// Question 7
        artQuestions.add(QuestionsView(
            21,
            "Which Renaissance artist painted the ceiling of the Sistine Chapel?",
            "Leonardo da Vinci",
            "Raphael",
            "Donatello",
            "Michelangelo",
            4
        ))

// Question 8
        artQuestions.add(QuestionsView(
            22,
            "Who is considered the founder of modern abstract art?",
            "Piet Mondrian",
            "Salvador Dalí",
            "Wassily Kandinsky",
            "Georgia O'Keeffe",
            3
        ))

// Question 9
        artQuestions.add(QuestionsView(
            23,
            "Which art form involves creating three-dimensional objects using materials like clay or stone?",
            "Painting",
            "Sculpture",
            "Drawing",
            "Printmaking",
            2
        ))

// Question 10
        artQuestions.add(QuestionsView(
            24,
            "Who is famous for painting the 'Mona Lisa'?",
            "Vincent van Gogh",
            "Leonardo da Vinci",
            "Pablo Picasso",
            "Claude Monet",
            2
        ))
        // Add more art questions as needed
        return artQuestions
    }

    private fun createPoliticsQuestions(): ArrayList<QuestionsView> {
        val politicsQuestions = ArrayList<QuestionsView>()
        // Politics Category Questions
        politicsQuestions.add(QuestionsView(
            14,
            "Who is the current President of the United States?",
            "Joe Biden",
            "Donald Trump",
            "Barack Obama",
            "George W. Bush",
            1
        ))
        politicsQuestions.add(QuestionsView(
            14,
            "Who is the current President of the United States?",
            "Joe Biden",
            "Donald Trump",
            "Barack Obama",
            "George W. Bush",
            1
        ))
        politicsQuestions.add(QuestionsView(
            24,
            "In which year did Nelson Mandela become the first black President of South Africa?",
            "1990",
            "1994",
            "1985",
            "2000",
            2
        ))
        politicsQuestions.add(QuestionsView(
            25,
            "Which country is known as the 'Land of the Rising Sun'?",
            "China",
            "South Korea",
            "Japan",
            "Vietnam",
            3
        ))
        politicsQuestions.add(QuestionsView(
            26,
            "Who is the Prime Minister of the United Kingdom?",
            "Boris Johnson",
            "Theresa May",
            "David Cameron",
            "Tony Blair",
            1
        ))
        politicsQuestions.add(QuestionsView(
            27,
            "What is the capital city of Canada?",
            "Toronto",
            "Vancouver",
            "Montreal",
            "Ottawa",
            4
        ))
        politicsQuestions.add(QuestionsView(
            28,
            "Who wrote the 'Communist Manifesto'?",
            "Vladimir Lenin",
            "Karl Marx",
            "Friedrich Engels",
            "Mao Zedong",
            2
        ))
        politicsQuestions.add(QuestionsView(
            29,
            "Which war was fought between North Korea and South Korea?",
            "World War I",
            "Vietnam War",
            "Korean War",
            "Cold War",
            3
        ))
        politicsQuestions.add(QuestionsView(
            30,
            "Who is the current Chancellor of Germany?",
            "Angela Merkel",
            "Gerhard Schröder",
            "Helmut Kohl",
            "Willy Brandt",
            1
        ))
        politicsQuestions.add(QuestionsView(
            31,
            "In which country is the Parliament known as the 'Duma'?",
            "Russia",
            "China",
            "India",
            "Brazil",
            1
        ))
        // Add more politics questions as needed
        return politicsQuestions
    }

    private fun createDefaultQuestions(): ArrayList<QuestionsView> {
        val defaultQuestions = ArrayList<QuestionsView>()
        // Handle unknown category or add a default set of questions
        defaultQuestions.add(QuestionsView(
            15,
            "Default Question",
            "Option A",
            "Option B",
            "Option C",
            "Option D",
            1
        ))

        return defaultQuestions
    }
}