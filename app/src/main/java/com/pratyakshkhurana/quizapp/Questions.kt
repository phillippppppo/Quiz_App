package com.pratyakshkhurana.quizapp

class Questions {

    // Methode zum Abrufen von Fragen für eine bestimmte Kategorie
    fun fetchDataForCategory(category: String): ArrayList<QuestionsView> {
        // Je nach Kategorie die entsprechenden Fragen erstellen
        val allQuestions = when (category) {
            "Music" -> createMusicQuestions()
            "Sports" -> createSportsQuestions()
            "Art" -> createArtQuestions()
            "Politics" -> createPoliticsQuestions()
            "History" -> createHistoryQuestions()
            "Science" -> createScienceQuestions()
            else -> createDefaultQuestions()
        }

        // Eine zufällige Auswahl von 10 Fragen zurückgeben
        return selectRandomQuestions(allQuestions, 10)
    }

    //  Methode zum Mischen der Antwortoptionen in den Fragen
    private fun shuffleOptions(questions: ArrayList<QuestionsView>): ArrayList<QuestionsView> {
        val shuffledQuestions = ArrayList<QuestionsView>()

        // Für jede Frage die Antwortoptionen mischen
        for (question in questions) {

            // Die korrekte Antwortoption identifizieren
            val correctOption = when (question.correct) {
                1 -> question.option1
                2 -> question.option2
                3 -> question.option3
                4 -> question.option4
                else -> question.option1
            }

            // Die Antwortoptionen in eine Liste einfügen und mischen
            val options = mutableListOf(
                question.option1,
                question.option2,
                question.option3,
                question.option4
            )

            options.shuffle()

            // Den Index der korrekten Antwortoption im gemischten Array finden
            var correctIndex = 0

            for (i in options.indices) {
                if (options[i] == correctOption) {
                    correctIndex = i + 1
                    break
                }
            }

            // Die Frage mit gemischten Antwortoptionen erstellen und der Liste hinzufügen
            val shuffledQuestion = question.copy(
                option1 = options[0],
                option2 = options[1],
                option3 = options[2],
                option4 = options[3],
                correct = correctIndex
            )

            shuffledQuestions.add(shuffledQuestion)
        }

        return shuffledQuestions
    }

    // Methode zur Auswahl einer zufälligen Anzahl von Fragen
    private fun selectRandomQuestions(allQuestions: ArrayList<QuestionsView>, count: Int): ArrayList<QuestionsView> {
        // Liste der Fragen zufällig mischen
        allQuestions.shuffle()

        // Die ersten 'count' Elemente aus der gemischten Liste auswählen
        // Sicherstellen, dass 'count' nicht größer ist als die Größe der Liste
        val selectedCount = count.coerceAtMost(allQuestions.size)

        // Antwortoptionen in den ausgewählten Fragen mischen und zurückgeben
        return shuffleOptions(ArrayList(allQuestions.take(selectedCount)))
    }

    private fun createMusicQuestions(): ArrayList<QuestionsView> {
        val musicQuestions = ArrayList<QuestionsView>()
        // Music Category Questions
        musicQuestions.add(QuestionsView(
            1,
            "Who is known as the 'King of Pop'?",
            "Michael Jackson",
            "Elvis Presley",
            "Prince",
            "Madonna",
            1
        ))

        musicQuestions.add(QuestionsView(
            2,
            "Which band performed the hit song 'Bohemian Rhapsody'?",
            "The Rolling Stones",
            "The Beatles",
            "Queen",
            "Led Zeppelin",
            3
        ))

        musicQuestions.add(QuestionsView(
            3,
            "What instrument did Jimi Hendrix play?",
            "Guitar",
            "Piano",
            "Drums",
            "Saxophone",
            1
        ))

        musicQuestions.add(QuestionsView(
            4,
            "Who is the lead vocalist of the band U2?",
            "Bono",
            "Chris Martin",
            "Mick Jagger",
            "Freddie Mercury",
            1
        ))

        musicQuestions.add(QuestionsView(
            5,
            "Which genre is the band AC/DC associated with?",
            "Country",
            "Rock",
            "Pop",
            "Rap",
            2
        ))

        musicQuestions.add(QuestionsView(
            6,
            "What is the best-selling album of all time?",
            "Thriller by Michael Jackson",
            "The Dark Side of the Moon by Pink Floyd",
            "Back in Black by AC/DC",
            "The Wall by Pink Floyd",
            1
        ))

        musicQuestions.add(QuestionsView(
            7,
            "Who wrote the song 'Like a Rolling Stone'?",
            "Bob Dylan",
            "John Lennon",
            "Paul McCartney",
            "Bruce Springsteen",
            1
        ))

        musicQuestions.add(QuestionsView(
            8,
            "What is the main instrument in a classical orchestra?",
            "Piano",
            "Violin",
            "Trumpet",
            "Cello",
            2
        ))

        musicQuestions.add(QuestionsView(
            9,
            "Which female artist is known as the 'Queen of Pop'?",
            "Madonna",
            "Beyoncé",
            "Lady Gaga",
            "Rihanna",
            1
        ))

        musicQuestions.add(QuestionsView(
            10,
            "Who composed the 'Moonlight Sonata'?",
            "Ludwig van Beethoven",
            "Wolfgang Amadeus Mozart",
            "Johann Sebastian Bach",
            "Franz Schubert",
            1
        ))

        musicQuestions.add(QuestionsView(
            11,
            "Which rock band had an album called 'Sticky Fingers'?",
            "The Rolling Stones",
            "The Who",
            "Led Zeppelin",
            "The Doors",
            1
        ))

        musicQuestions.add(QuestionsView(
            12,
            "What is the name of Adele's debut album?",
            "19",
            "21",
            "25",
            "Hello",
            1
        ))

        musicQuestions.add(QuestionsView(
            13,
            "Who was the lead guitarist for the band Queen?",
            "Brian May",
            "Jimmy Page",
            "Eric Clapton",
            "Angus Young",
            1
        ))

        musicQuestions.add(QuestionsView(
            14,
            "What is the Beatles' best-selling single of all time?",
            "Hey Jude",
            "Let It Be",
            "I Want to Hold Your Hand",
            "Yesterday",
            3
        ))

        musicQuestions.add(QuestionsView(
            15,
            "Who is known as the 'Godfather of Soul'?",
            "James Brown",
            "Ray Charles",
            "Stevie Wonder",
            "Marvin Gaye",
            1
        ))

        musicQuestions.add(QuestionsView(
            16,
            "Which artist released the album 'Back to Black'?",
            "Amy Winehouse",
            "Adele",
            "Taylor Swift",
            "Beyoncé",
            1
        ))

        musicQuestions.add(QuestionsView(
            17,
            "Who wrote the musical 'The Phantom of the Opera'?",
            "Andrew Lloyd Webber",
            "Stephen Sondheim",
            "Richard Rodgers",
            "Lionel Bart",
            1
        ))

        musicQuestions.add(QuestionsView(
            18,
            "Which city is known as the birthplace of jazz?",
            "New Orleans",
            "Chicago",
            "New York",
            "Memphis",
            1
        ))

        musicQuestions.add(QuestionsView(
            19,
            "What is the name of Taylor Swift's first album?",
            "Taylor Swift",
            "Fearless",
            "Speak Now",
            "Red",
            1
        ))

        musicQuestions.add(QuestionsView(
            20,
            "Which instrument does Yo-Yo Ma play?",
            "Cello",
            "Violin",
            "Piano",
            "Trumpet",
            1
        ))

        musicQuestions.add(QuestionsView(
            21,
            "What is the name of the lead singer of Coldplay?",
            "Chris Martin",
            "Thom Yorke",
            "Brandon Flowers",
            "Dave Grohl",
            1
        ))

        musicQuestions.add(QuestionsView(
            22,
            "Which rapper starred in the movie '8 Mile'?",
            "Eminem",
            "Jay-Z",
            "Kanye West",
            "Snoop Dogg",
            1
        ))

        musicQuestions.add(QuestionsView(
            23,
            "Who is known as the 'Queen of Soul'?",
            "Aretha Franklin",
            "Whitney Houston",
            "Tina Turner",
            "Diana Ross",
            1
        ))

        musicQuestions.add(QuestionsView(
            24,
            "What was the first music video played on MTV?",
            "Video Killed the Radio Star by The Buggles",
            "Thriller by Michael Jackson",
            "Billie Jean by Michael Jackson",
            "Like a Virgin by Madonna",
            1
        ))

        musicQuestions.add(QuestionsView(
            25,
            "Which composer is famous for his 'Four Seasons'?",
            "Antonio Vivaldi",
            "Johann Sebastian Bach",
            "Ludwig van Beethoven",
            "Wolfgang Amadeus Mozart",
            1
        ))
        musicQuestions.add(QuestionsView(
            26,
            "Who is known as the 'Queen of Country'?",
            "Dolly Parton",
            "Shania Twain",
            "Reba McEntire",
            "Taylor Swift",
            1
        ))

        musicQuestions.add(QuestionsView(
            27,
            "Which legendary guitarist is often referred to as 'Slowhand'?",
            "Eric Clapton",
            "Jimi Hendrix",
            "Jimmy Page",
            "Carlos Santana",
            1
        ))

        musicQuestions.add(QuestionsView(
            28,
            "What Beatles album features the famous 'Abbey Road' zebra crossing photo on its cover?",
            "Abbey Road",
            "The White Album",
            "Sgt. Pepper's Lonely Hearts Club Band",
            "Revolver",
            1
        ))

        musicQuestions.add(QuestionsView(
            29,
            "Who is the lead singer of the band Coldplay?",
            "Chris Martin",
            "Thom Yorke",
            "Brandon Flowers",
            "Dave Grohl",
            1
        ))

        musicQuestions.add(QuestionsView(
            30,
            "Which artist released the album 'Lemonade' in 2016?",
            "Beyoncé",
            "Rihanna",
            "Adele",
            "Taylor Swift",
            1
        ))

        musicQuestions.add(QuestionsView(
            31,
            "What is the nickname of legendary jazz trumpeter Louis Armstrong?",
            "Satchmo",
            "Bird",
            "Dizzy",
            "Trane",
            1
        ))

        musicQuestions.add(QuestionsView(
            32,
            "In which city did the punk rock movement originate in the 1970s?",
            "New York",
            "London",
            "Los Angeles",
            "Berlin",
            2
        ))

        musicQuestions.add(QuestionsView(
            33,
            "What is the name of the record label founded by Jay-Z?",
            "Roc-A-Fella Records",
            "Bad Boy Records",
            "Def Jam Recordings",
            "Interscope Records",
            1
        ))

        musicQuestions.add(QuestionsView(
            34,
            "Which famous pop artist is known for her meat dress at the 2010 MTV Video Music Awards?",
            "Lady Gaga",
            "Katy Perry",
            "Rihanna",
            "Beyoncé",
            1
        ))

        musicQuestions.add(QuestionsView(
            35,
            "What was the first music video played on MTV?",
            "Video Killed the Radio Star by The Buggles",
            "Thriller by Michael Jackson",
            "Billie Jean by Michael Jackson",
            "Like a Virgin by Madonna",
            1
        ))

        musicQuestions.add(QuestionsView(
            36,
            "Which legendary rock band's name is inspired by a Muddy Waters song?",
            "The Rolling Stones",
            "The Beatles",
            "Led Zeppelin",
            "The Who",
            1
        ))

        musicQuestions.add(QuestionsView(
            37,
            "Who composed the famous ballet 'The Nutcracker'?",
            "Pyotr Ilyich Tchaikovsky",
            "Ludwig van Beethoven",
            "Wolfgang Amadeus Mozart",
            "Claude Debussy",
            1
        ))

        musicQuestions.add(QuestionsView(
            38,
            "Which rapper won the Academy Award for Best Original Song with 'Lose Yourself'?",
            "Eminem",
            "Jay-Z",
            "Kendrick Lamar",
            "Drake",
            1
        ))

        musicQuestions.add(QuestionsView(
            39,
            "What is the name of the lead singer of Queen after Freddie Mercury?",
            "Adam Lambert",
            "George Michael",
            "Paul Rodgers",
            "Elton John",
            1
        ))

        musicQuestions.add(QuestionsView(
            40,
            "Who is known as the 'Piano Man'?",
            "Billy Joel",
            "Elton John",
            "John Lennon",
            "Stevie Wonder",
            1
        ))

        musicQuestions.add(QuestionsView(
            41,
            "Which country is the birthplace of the tango?",
            "Argentina",
            "Spain",
            "Italy",
            "France",
            1
        ))

        musicQuestions.add(QuestionsView(
            42,
            "Who was the first woman to be inducted into the Rock and Roll Hall of Fame?",
            "Aretha Franklin",
            "Janis Joplin",
            "Tina Turner",
            "Patti Smith",
            1
        ))

        musicQuestions.add(QuestionsView(
            43,
            "What year did Elvis Presley pass away?",
            "1977",
            "1969",
            "1983",
            "1956",
            1
        ))

        musicQuestions.add(QuestionsView(
            44,
            "Which musical instrument does Yo-Yo Ma play?",
            "Cello",
            "Violin",
            "Piano",
            "Trumpet",
            1
        ))

        musicQuestions.add(QuestionsView(
            45,
            "What is the name of the famous Woodstock music festival held in 1969?",
            "Woodstock Music & Art Fair",
            "Summer of Love Festival",
            "Monterey Pop Festival",
            "Isle of Wight Festival",
            1
        ))

        musicQuestions.add(QuestionsView(
            46,
            "Who wrote the famous rock opera 'Tommy'?",
            "The Who",
            "Pink Floyd",
            "The Rolling Stones",
            "Led Zeppelin",
            1
        ))

        musicQuestions.add(QuestionsView(
            47,
            "What is the best-selling single of all time?",
            "White Christmas by Bing Crosby",
            "Candle in the Wind by Elton John",
            "I Will Always Love You by Whitney Houston",
            "Bohemian Rhapsody by Queen",
            1
        ))

        musicQuestions.add(QuestionsView(
            48,
            "Which singer is known as the 'Voice of a Generation'?",
            "Bob Dylan",
            "John Lennon",
            "Bruce Springsteen",
            "Neil Young",
            1
        ))

        musicQuestions.add(QuestionsView(
            49,
            "What is the name of the lead singer of the Red Hot Chili Peppers?",
            "Anthony Kiedis",
            "Dave Grohl",
            "Eddie Vedder",
            "Chris Cornell",
            1
        ))

        musicQuestions.add(QuestionsView(
            50,
            "Who wrote the opera 'The Marriage of Figaro'?",
            "Wolfgang Amadeus Mozart",
            "Giuseppe Verdi",
            "Ludwig van Beethoven",
            "Richard Wagner",
            1
        ))

        musicQuestions.add(QuestionsView(
            51,
            "What is the name of the lead singer of Nirvana?",
            "Kurt Cobain",
            "Dave Grohl",
            "Eddie Vedder",
            "Chris Cornell",
            1
        ))

        musicQuestions.add(QuestionsView(
            52,
            "Which country is the birthplace of the flamenco music and dance style?",
            "Spain",
            "Italy",
            "Greece",
            "Portugal",
            1
        ))

        musicQuestions.add(QuestionsView(
            53,
            "Who is known as the 'Father of the Blues'?",
            "W.C. Handy",
            "B.B. King",
            "Muddy Waters",
            "Robert Johnson",
            1
        ))

        musicQuestions.add(QuestionsView(
            54,
            "Which legendary singer was known as 'The Chairman of the Board'?",
            "Frank Sinatra",
            "Elvis Presley",
            "Dean Martin",
            "Nat King Cole",
            1
        ))

        musicQuestions.add(QuestionsView(
            55,
            "In what year did The Beatles officially disband?",
            "1970",
            "1969",
            "1972",
            "1967",
            1
        ))

        musicQuestions.add(QuestionsView(
            56,
            "What is the genre of music associated with Bob Marley?",
            "Reggae",
            "Ska",
            "Dubstep",
            "Calypso",
            1
        ))

        musicQuestions.add(QuestionsView(
            57,
            "Which rock band released the album 'The Wall'?",
            "Pink Floyd",
            "The Rolling Stones",
            "The Who",
            "Led Zeppelin",
            1
        ))

        musicQuestions.add(QuestionsView(
            58,
            "Who is the lead guitarist of the rock band Guns N' Roses?",
            "Slash",
            "Eddie Van Halen",
            "Jimmy Page",
            "Angus Young",
            1
        ))

        musicQuestions.add(QuestionsView(
            59,
            "What is the name of Beyoncé's alter ego?",
            "Sasha Fierce",
            "Queen Bey",
            "Diva",
            "Yoncé",
            1
        ))

        musicQuestions.add(QuestionsView(
            60,
            "Which composer is famous for his 'Symphony No. 9'?",
            "Ludwig van Beethoven",
            "Wolfgang Amadeus Mozart",
            "Johann Sebastian Bach",
            "Franz Schubert",
            1
        ))

        musicQuestions.add(QuestionsView(
            61,
            "What is the name of the first music video ever played on MTV?",
            "Video Killed the Radio Star by The Buggles",
            "Thriller by Michael Jackson",
            "Billie Jean by Michael Jackson",
            "Like a Virgin by Madonna",
            1
        ))

        musicQuestions.add(QuestionsView(
            62,
            "Who was known as the 'Queen of Tejano Music'?",
            "Selena",
            "Shakira",
            "Gloria Estefan",
            "Celia Cruz",
            1
        ))

        musicQuestions.add(QuestionsView(
            63,
            "What is the name of the record label founded by Dr. Dre?",
            "Aftermath Entertainment",
            "Death Row Records",
            "Interscope Records",
            "Bad Boy Records",
            1
        ))

        musicQuestions.add(QuestionsView(
            64,
            "Which famous jazz saxophonist was known as 'Bird'?",
            "Charlie Parker",
            "John Coltrane",
            "Miles Davis",
            "Duke Ellington",
            1
        ))

        musicQuestions.add(QuestionsView(
            65,
            "Who wrote the song 'Purple Haze'?",
            "Jimi Hendrix",
            "Eric Clapton",
            "Jimmy Page",
            "Bob Dylan",
            1
        ))

        musicQuestions.add(QuestionsView(
            66,
            "What is the name of the electronic music festival held annually in Belgium?",
            "Tomorrowland",
            "Ultra Music Festival",
            "Coachella",
            "Electric Daisy Carnival",
            1
        ))

        musicQuestions.add(QuestionsView(
            67,
            "Which musical instrument does Eric Johnson, known for 'Cliffs of Dover,' play?",
            "Guitar",
            "Violin",
            "Piano",
            "Drums",
            1
        ))

        musicQuestions.add(QuestionsView(
            68,
            "What year did Michael Jackson release his album 'Thriller'?",
            "1982",
            "1984",
            "1980",
            "1986",
            1
        ))

        musicQuestions.add(QuestionsView(
            69,
            "Who is known as the 'Guitar God'?",
            "Jimi Hendrix",
            "Eric Clapton",
            "Jimmy Page",
            "Eddie Van Halen",
            1
        ))

        musicQuestions.add(QuestionsView(
            70,
            "What is the name of the music festival in the Nevada desert known for its large wooden effigy?",
            "Burning Man",
            "Coachella",
            "Lollapalooza",
            "Glastonbury",
            1
        ))

        musicQuestions.add(QuestionsView(
            71,
            "Which composer is famous for his '1812 Overture'?",
            "Pyotr Ilyich Tchaikovsky",
            "Ludwig van Beethoven",
            "Wolfgang Amadeus Mozart",
            "Claude Debussy",
            1
        ))

        musicQuestions.add(QuestionsView(
            72,
            "What is the name of the lead singer of the band Radiohead?",
            "Thom Yorke",
            "Chris Martin",
            "Eddie Vedder",
            "Brandon Flowers",
            1
        ))

        musicQuestions.add(QuestionsView(
            73,
            "Which musical genre is characterized by its focus on storytelling through song?",
            "Country",
            "Blues",
            "Jazz",
            "R&B",
            1
        ))

        musicQuestions.add(QuestionsView(
            74,
            "Who wrote the soundtrack for the film 'The Lion King'?",
            "Hans Zimmer",
            "Elton John",
            "Alan Menken",
            "John Williams",
            1
        ))

        musicQuestions.add(QuestionsView(
            75,
            "Which rock band is known for the concept album 'The Dark Side of the Moon'?",
            "Pink Floyd",
            "The Rolling Stones",
            "Led Zeppelin",
            "The Who",
            1
        ))

        musicQuestions.add(QuestionsView(
            76,
            "What is the name of the famous festival that took place in 1969 and featured Jimi Hendrix's iconic performance?",
            "Woodstock",
            "Monterey Pop Festival",
            "Isle of Wight Festival",
            "Altamont Free Concert",
            1
        ))

        musicQuestions.add(QuestionsView(
            76,
            "What is the name of the famous festival that took place in 1969 and featured Jimi Hendrix's iconic performance?",
            "Woodstock",
            "Monterey Pop Festival",
            "Isle of Wight Festival",
            "Altamont Free Concert",
            1
        ))

        musicQuestions.add(QuestionsView(
            78,
            "Who is known as the 'Empress of Soul'?",
            "Gladys Knight",
            "Diana Ross",
            "Aretha Franklin",
            "Patti LaBelle",
            2
        ))

        musicQuestions.add(QuestionsView(
            79,
            "Which rapper famously declared, 'I'm not a businessman, I'm a business, man'?",
            "Jay-Z",
            "Eminem",
            "Kanye West",
            "Drake",
            1
        ))

        musicQuestions.add(QuestionsView(
            80,
            "What is the name of the famous musical based on the songs of ABBA?",
            "Mamma Mia!",
            "Grease",
            "Les Misérables",
            "The Phantom of the Opera",
            1
        ))

        musicQuestions.add(QuestionsView(
            81,
            "Who is known as the 'Godmother of Punk'?",
            "Patti Smith",
            "Joan Jett",
            "Debbie Harry",
            "Siouxsie Sioux",
            1
        ))

        musicQuestions.add(QuestionsView(
            82,
            "In which year did Elvis Presley make his first appearance on 'The Ed Sullivan Show'?",
            "1956",
            "1958",
            "1960",
            "1954",
            1
        ))

        musicQuestions.add(QuestionsView(
            83,
            "What is the name of the lead singer of the band Pearl Jam?",
            "Eddie Vedder",
            "Chris Cornell",
            "Kurt Cobain",
            "Dave Grohl",
            1
        ))

        musicQuestions.add(QuestionsView(
            84,
            "Which famous jazz pianist and composer is known as the 'High Priestess of Soul'?",
            "Nina Simone",
            "Ella Fitzgerald",
            "Billie Holiday",
            "Sarah Vaughan",
            1
        ))

        musicQuestions.add(QuestionsView(
            85,
            "What is the name of the rock band known for the hit song 'Stairway to Heaven'?",
            "Led Zeppelin",
            "The Rolling Stones",
            "The Who",
            "Pink Floyd",
            1
        ))

        musicQuestions.add(QuestionsView(
            86,
            "Who is known as the 'Queen of Jazz'?",
            "Ella Fitzgerald",
            "Billie Holiday",
            "Nina Simone",
            "Sarah Vaughan",
            1
        ))

        musicQuestions.add(QuestionsView(
            87,
            "Which hip-hop group released the iconic album 'Straight Outta Compton'?",
            "N.W.A",
            "Public Enemy",
            "Wu-Tang Clan",
            "A Tribe Called Quest",
            1
        ))

        musicQuestions.add(QuestionsView(
            88,
            "What is the name of the lead singer of the band Fleetwood Mac?",
            "Stevie Nicks",
            "Christine McVie",
            "Lindsey Buckingham",
            "Mick Fleetwood",
            1
        ))

        musicQuestions.add(QuestionsView(
            89,
            "Which musical artist is known for the hit song 'Wannabe' and is part of the Spice Girls?",
            "Mel B",
            "Emma Bunton",
            "Geri Halliwell",
            "Victoria Beckham",
            3
        ))

        musicQuestions.add(QuestionsView(
            90,
            "What is the name of the first album released by The Beatles?",
            "Please Please Me",
            "A Hard Day's Night",
            "Rubber Soul",
            "Revolver",
            1
        ))

        musicQuestions.add(QuestionsView(
            91,
            "Which composer is known for his 'Water Music' and 'Music for the Royal Fireworks'?",
            "George Frideric Handel",
            "Johann Sebastian Bach",
            "Antonio Vivaldi",
            "Franz Joseph Haydn",
            1
        ))

        musicQuestions.add(QuestionsView(
            92,
            "Who is known as the 'Queen of Hip-Hop Soul'?",
            "Mary J. Blige",
            "Alicia Keys",
            "Janet Jackson",
            "Whitney Houston",
            1
        ))

        musicQuestions.add(QuestionsView(
            93,
            "Which band is known for the hit song 'Sweet Child o' Mine'?",
            "Guns N' Roses",
            "AC/DC",
            "Metallica",
            "Nirvana",
            1
        ))

        musicQuestions.add(QuestionsView(
            94,
            "What is the name of the famous opera by Giuseppe Verdi that features the 'La donna è mobile' aria?",
            "Rigoletto",
            "La Traviata",
            "Aida",
            "Il Trovatore",
            1
        ))

        musicQuestions.add(QuestionsView(
            95,
            "Who composed the soundtrack for the movie 'The Lion King'?",
            "Hans Zimmer",
            "Elton John",
            "Alan Menken",
            "John Williams",
            2
        ))

        musicQuestions.add(QuestionsView(
            96,
            "Which singer is known for hits like 'Uptown Funk' and '24K Magic'?",
            "Bruno Mars",
            "Justin Timberlake",
            "Ed Sheeran",
            "The Weeknd",
            1
        ))

        musicQuestions.add(QuestionsView(
            97,
            "What is the name of the legendary music festival that took place in 1969, featuring artists like Jimi Hendrix and Janis Joplin?",
            "Woodstock",
            "Monterey Pop Festival",
            "Isle of Wight Festival",
            "Altamont Free Concert",
            1
        ))

        musicQuestions.add(QuestionsView(
            98,
            "Who is known as the 'High Priest of Soul'?",
            "Ray Charles",
            "James Brown",
            "Sam Cooke",
            "Otis Redding",
            2
        ))

        musicQuestions.add(QuestionsView(
            99,
            "Which country is the birthplace of the tango dance?",
            "Argentina",
            "Spain",
            "Italy",
            "Brazil",
            1
        ))

        musicQuestions.add(QuestionsView(
            100,
            "What is the name of the lead singer of the band Aerosmith?",
            "Steven Tyler",
            "Joe Perry",
            "Tom Hamilton",
            "Brad Whitford",
            1
        ))

        // Add more music questions as needed
        return musicQuestions
    }

    private fun createSportsQuestions(): ArrayList<QuestionsView> {
        val sportsQuestions = ArrayList<QuestionsView>()

        sportsQuestions.add(QuestionsView(
            1,
            "Which country won the FIFA World Cup in 2018?",
            "France",
            "Germany",
            "Brazil",
            "Argentina",
            1
        ))

        sportsQuestions.add(QuestionsView(
            2,
            "In which city were the 2016 Summer Olympics held?",
            "Rio de Janeiro",
            "Tokyo",
            "London",
            "Beijing",
            1
        ))

        sportsQuestions.add(QuestionsView(
            3,
            "Who holds the record for the most Grand Slam singles titles in tennis?",
            "Roger Federer",
            "Rafael Nadal",
            "Serena Williams",
            "Novak Djokovic",
            1
        ))

        sportsQuestions.add(QuestionsView(
            4,
            "Which NBA player is known as 'The Greek Freak'?",
            "Giannis Antetokounmpo",
            "LeBron James",
            "Kevin Durant",
            "Stephen Curry",
            1
        ))

        sportsQuestions.add(QuestionsView(
            5,
            "In which sport can you perform a 'hat-trick'?",
            "Cricket",
            "Soccer",
            "Ice Hockey",
            "Golf",
            1
        ))

        sportsQuestions.add(QuestionsView(
            6,
            "Who is the all-time leading scorer in NBA history?",
            "Kareem Abdul-Jabbar",
            "LeBron James",
            "Kobe Bryant",
            "Michael Jordan",
            1
        ))

        sportsQuestions.add(QuestionsView(
            7,
            "Which country won the Rugby World Cup in 2019?",
            "South Africa",
            "New Zealand",
            "Australia",
            "England",
            1
        ))

        sportsQuestions.add(QuestionsView(
            8,
            "What is the nickname of the New York Yankees in Major League Baseball (MLB)?",
            "The Bronx Bombers",
            "The Big Apple Sluggers",
            "The Empire State Warriors",
            "The Gotham Goliaths",
            1
        ))

        sportsQuestions.add(QuestionsView(
            9,
            "Which golfer is often referred to as 'Lefty'?",
            "Phil Mickelson",
            "Tiger Woods",
            "Rory McIlroy",
            "Jordan Spieth",
            1
        ))

        sportsQuestions.add(QuestionsView(
            10,
            "Who won the Super Bowl in 2020?",
            "Kansas City Chiefs",
            "San Francisco 49ers",
            "New England Patriots",
            "Los Angeles Rams",
            1
        ))

        sportsQuestions.add(QuestionsView(
            11,
            "In which country did the sport of curling originate?",
            "Scotland",
            "Canada",
            "Sweden",
            "Norway",
            1
        ))

        sportsQuestions.add(QuestionsView(
            12,
            "Which tennis player is known as the 'King of Clay'?",
            "Rafael Nadal",
            "Roger Federer",
            "Novak Djokovic",
            "Andy Murray",
            1
        ))

        sportsQuestions.add(QuestionsView(
            13,
            "Who is the most decorated Olympian of all time?",
            "Michael Phelps",
            "Usain Bolt",
            "Simone Biles",
            "Carl Lewis",
            1
        ))

        sportsQuestions.add(QuestionsView(
            14,
            "Which team won the UEFA Champions League in the 2020-2021 season?",
            "Chelsea",
            "Manchester City",
            "Real Madrid",
            "Bayern Munich",
            1
        ))

        sportsQuestions.add(QuestionsView(
            15,
            "What is the name of the annual horse race that is part of the U.S. Triple Crown?",
            "Kentucky Derby",
            "Belmont Stakes",
            "Preakness Stakes",
            "Dubai World Cup",
            1
        ))

        sportsQuestions.add(QuestionsView(
            16,
            "Which boxer is nicknamed 'Money'?",
            "Floyd Mayweather",
            "Manny Pacquiao",
            "Mike Tyson",
            "Muhammad Ali",
            1
        ))

        sportsQuestions.add(QuestionsView(
            17,
            "What is the term used for a perfect score of 10 in gymnastics?",
            "Perfect 10",
            "Flawless Score",
            "Gymnastic Perfect",
            "Elite Score",
            1
        ))

        sportsQuestions.add(QuestionsView(
            18,
            "In American football, how many points is a touchdown worth?",
            "6",
            "3",
            "7",
            "2",
            1
        ))

        sportsQuestions.add(QuestionsView(
            19,
            "Which country has won the most medals in the history of the Summer Olympics?",
            "United States",
            "Soviet Union",
            "China",
            "Germany",
            1
        ))

        sportsQuestions.add(QuestionsView(
            20,
            "Who holds the record for the most goals scored in a single FIFA World Cup tournament?",
            "Just Fontaine",
            "Pele",
            "Gerd Muller",
            "Diego Maradona",
            1
        ))

        sportsQuestions.add(QuestionsView(
            21,
            "Which NFL quarterback is known as 'The Sheriff'?",
            "Peyton Manning",
            "Tom Brady",
            "Drew Brees",
            "Aaron Rodgers",
            1
        ))

        sportsQuestions.add(QuestionsView(
            22,
            "In which year did the first modern Olympic Games take place?",
            "1896",
            "1900",
            "1888",
            "1912",
            1
        ))

        sportsQuestions.add(QuestionsView(
            23,
            "Who won the 2021 Wimbledon Men's Singles title?",
            "Novak Djokovic",
            "Roger Federer",
            "Rafael Nadal",
            "Andy Murray",
            1
        ))

        sportsQuestions.add(QuestionsView(
            24,
            "Which country hosted the 2014 FIFA World Cup?",
            "Brazil",
            "Germany",
            "South Africa",
            "Russia",
            1
        ))

        sportsQuestions.add(QuestionsView(
            25,
            "Who is the all-time leading scorer in the history of the NHL (National Hockey League)?",
            "Wayne Gretzky",
            "Mario Lemieux",
            "Jaromir Jagr",
            "Gordie Howe",
            1
        ))

        sportsQuestions.add(QuestionsView(
            26,
            "Which country has won the most FIFA World Cup titles?",
            "Brazil",
            "Germany",
            "Italy",
            "Argentina",
            1
        ))

        sportsQuestions.add(QuestionsView(
            27,
            "In which city did the first modern Olympic Games take place?",
            "Athens",
            "Paris",
            "London",
            "Rome",
            1
        ))

        sportsQuestions.add(QuestionsView(
            28,
            "Who is the only player to have won FIFA World Player of the Year, Ballon d'Or, and Golden Foot awards?",
            "Lionel Messi",
            "Cristiano Ronaldo",
            "Zinedine Zidane",
            "Andres Iniesta",
            1
        ))

        sportsQuestions.add(QuestionsView(
            29,
            "Which boxer is known as 'Iron Mike'?",
            "Mike Tyson",
            "Evander Holyfield",
            "Muhammad Ali",
            "George Foreman",
            1
        ))

        sportsQuestions.add(QuestionsView(
            30,
            "What is the highest possible break in a game of snooker?",
            "147",
            "155",
            "136",
            "162",
            1
        ))

        sportsQuestions.add(QuestionsView(
            31,
            "Which country won the UEFA European Championship in 2021?",
            "Italy",
            "England",
            "Spain",
            "Germany",
            1
        ))

        sportsQuestions.add(QuestionsView(
            32,
            "Who holds the record for the most career home runs in Major League Baseball (MLB)?",
            "Barry Bonds",
            "Hank Aaron",
            "Babe Ruth",
            "Alex Rodriguez",
            1
        ))

        sportsQuestions.add(QuestionsView(
            33,
            "Which NBA team won the most championships in the 1990s?",
            "Chicago Bulls",
            "Los Angeles Lakers",
            "Boston Celtics",
            "San Antonio Spurs",
            1
        ))

        sportsQuestions.add(QuestionsView(
            34,
            "In which year did the first edition of the Tour de France take place?",
            "1903",
            "1910",
            "1920",
            "1935",
            1
        ))

        sportsQuestions.add(QuestionsView(
            35,
            "Who is the most decorated Olympian in terms of total medals (gold, silver, and bronze)?",
            "Michael Phelps",
            "Usain Bolt",
            "Simone Biles",
            "Carl Lewis",
            1
        ))

        sportsQuestions.add(QuestionsView(
            36,
            "Which country hosted the 2016 Summer Olympics?",
            "Brazil",
            "China",
            "Russia",
            "United States",
            1
        ))

        sportsQuestions.add(QuestionsView(
            37,
            "Who holds the record for the most points scored in a single NBA game?",
            "Wilt Chamberlain",
            "Kobe Bryant",
            "Michael Jordan",
            "LeBron James",
            1
        ))

        sportsQuestions.add(QuestionsView(
            38,
            "What is the diameter of a standard basketball hoop in inches?",
            "18",
            "20",
            "22",
            "24",
            1
        ))

        sportsQuestions.add(QuestionsView(
            39,
            "Which country has won the most Rugby World Cup titles?",
            "New Zealand",
            "South Africa",
            "Australia",
            "England",
            1
        ))

        sportsQuestions.add(QuestionsView(
            40,
            "Who won the 2020 NBA Finals MVP (Most Valuable Player) award?",
            "LeBron James",
            "Anthony Davis",
            "Jimmy Butler",
            "Kevin Durant",
            1
        ))

        sportsQuestions.add(QuestionsView(
            41,
            "What is the distance of a marathon race in kilometers?",
            "42.195",
            "39.5",
            "45.0",
            "50.0",
            1
        ))

        sportsQuestions.add(QuestionsView(
            42,
            "Which country won the Copa America in 2021?",
            "Argentina",
            "Brazil",
            "Uruguay",
            "Chile",
            1
        ))

        sportsQuestions.add(QuestionsView(
            43,
            "Who is the all-time leading scorer in the history of the Premier League?",
            "Alan Shearer",
            "Wayne Rooney",
            "Thierry Henry",
            "Frank Lampard",
            1
        ))

        sportsQuestions.add(QuestionsView(
            44,
            "What is the nickname of the Los Angeles Lakers' home arena?",
            "Staples Center",
            "Madison Square Garden",
            "United Center",
            "Chase Center",
            1
        ))

        sportsQuestions.add(QuestionsView(
            45,
            "In which year did the first Rugby World Cup take place?",
            "1987",
            "1991",
            "1975",
            "2003",
            1
        ))

        sportsQuestions.add(QuestionsView(
            46,
            "Who won the 2021 Australian Open Men's Singles title?",
            "Novak Djokovic",
            "Rafael Nadal",
            "Roger Federer",
            "Dominic Thiem",
            1
        ))

        sportsQuestions.add(QuestionsView(
            47,
            "What is the highest possible score in a single game of bowling?",
            "300",
            "250",
            "200",
            "400",
            1
        ))

        sportsQuestions.add(QuestionsView(
            48,
            "Which country hosted the 2018 Winter Olympics?",
            "South Korea",
            "Canada",
            "Russia",
            "Norway",
            1
        ))

        sportsQuestions.add(QuestionsView(
            49,
            "Who won the 2021 French Open Women's Singles title?",
            "Barbora Krejčíková",
            "Iga Świątek",
            "Simona Halep",
            "Ashleigh Barty",
            1
        ))

        sportsQuestions.add(QuestionsView(
            50,
            "Which tennis player is known for his 'between-the-legs' shots and is nicknamed 'The Magician'?",
            "Roger Federer",
            "Novak Djokovic",
            "Rafael Nadal",
            "Nick Kyrgios",
            1
        ))

        sportsQuestions.add(QuestionsView(
            51,
            "Who won the 2020 UEFA European Championship Golden Boot for being the tournament's top scorer?",
            "Cristiano Ronaldo",
            "Kylian Mbappé",
            "Romelu Lukaku",
            "Harry Kane",
            1
        ))

        sportsQuestions.add(QuestionsView(
            52,
            "In which city is the headquarters of the International Olympic Committee (IOC) located?",
            "Lausanne",
            "Geneva",
            "Zurich",
            "Bern",
            1
        ))

        sportsQuestions.add(QuestionsView(
            53,
            "Which athlete is known as the 'Fastest Man on Earth'?",
            "Usain Bolt",
            "Carl Lewis",
            "Michael Johnson",
            "Tyson Gay",
            1
        ))

        sportsQuestions.add(QuestionsView(
            54,
            "What is the term used for a tie-breaking method in soccer, where each team takes turns attempting to score from the penalty spot?",
            "Penalty Shootout",
            "Sudden Death",
            "Extra Time",
            "Golden Goal",
            1
        ))

        sportsQuestions.add(QuestionsView(
            55,
            "Which country has won the most Winter Olympic gold medals in history?",
            "Norway",
            "United States",
            "Germany",
            "Russia",
            1
        ))

        sportsQuestions.add(QuestionsView(
            56,
            "Who is the all-time leading scorer in the history of the NBA?",
            "Kareem Abdul-Jabbar",
            "LeBron James",
            "Kobe Bryant",
            "Michael Jordan",
            1
        ))

        sportsQuestions.add(QuestionsView(
            57,
            "In which year did the first official Paralympic Games take place?",
            "1960",
            "1972",
            "1980",
            "1996",
            1
        ))

        sportsQuestions.add(QuestionsView(
            58,
            "Which country won the 2021 Copa America?",
            "Argentina",
            "Brazil",
            "Uruguay",
            "Colombia",
            1
        ))

        sportsQuestions.add(QuestionsView(
            59,
            "Who holds the record for the most Olympic gold medals in swimming?",
            "Michael Phelps",
            "Ian Thorpe",
            "Ryan Lochte",
            "Katie Ledecky",
            1
        ))

        sportsQuestions.add(QuestionsView(
            60,
            "Which city will host the 2024 Summer Olympics?",
            "Paris",
            "Los Angeles",
            "Tokyo",
            "Rome",
            1
        ))

        sportsQuestions.add(QuestionsView(
            61,
            "Who is the only footballer to have won the FIFA World Player of the Year award six times?",
            "Lionel Messi",
            "Cristiano Ronaldo",
            "Zinedine Zidane",
            "Neymar",
            1
        ))

        sportsQuestions.add(QuestionsView(
            62,
            "What is the traditional color of the jersey worn by the leader of the Tour de France?",
            "Yellow",
            "Green",
            "Polka Dot",
            "White",
            1
        ))

        sportsQuestions.add(QuestionsView(
            63,
            "Which city is home to the Baseball Hall of Fame?",
            "Cooperstown",
            "New York",
            "Chicago",
            "Los Angeles",
            1
        ))

        sportsQuestions.add(QuestionsView(
            64,
            "Who won the 2021 FIFA Club World Cup?",
            "Bayern Munich",
            "Real Madrid",
            "Liverpool",
            "Chelsea",
            1
        ))

        sportsQuestions.add(QuestionsView(
            65,
            "In which sport did Jesse Owens win four gold medals at the 1936 Berlin Olympics?",
            "Athletics (Track and Field)",
            "Swimming",
            "Boxing",
            "Gymnastics",
            1
        ))

        sportsQuestions.add(QuestionsView(
            66,
            "Which country won the most medals at the 2021 Summer Olympics?",
            "United States",
            "China",
            "Russia",
            "Japan",
            1
        ))

        sportsQuestions.add(QuestionsView(
            67,
            "Who is the all-time leading scorer in the history of the NFL?",
            "Jerry Rice",
            "Emmitt Smith",
            "Tom Brady",
            "Peyton Manning",
            1
        ))

        sportsQuestions.add(QuestionsView(
            68,
            "What is the name of the horse that won the Triple Crown in 2018?",
            "Justify",
            "American Pharoah",
            "Secretariat",
            "Seattle Slew",
            1
        ))

        sportsQuestions.add(QuestionsView(
            69,
            "Which tennis player holds the record for the most Grand Slam singles titles in women's tennis?",
            "Margaret Court",
            "Serena Williams",
            "Steffi Graf",
            "Martina Navratilova",
            1
        ))

        sportsQuestions.add(QuestionsView(
            70,
            "What is the name of the trophy awarded to the winner of the Stanley Cup in ice hockey?",
            "Lord Stanley's Cup",
            "Hart Trophy",
            "Conn Smythe Trophy",
            "Norris Trophy",
            1
        ))

        sportsQuestions.add(QuestionsView(
            71,
            "Who won the 2021 Women's T20 Cricket World Cup?",
            "Australia",
            "England",
            "India",
            "South Africa",
            1
        ))

        sportsQuestions.add(QuestionsView(
            72,
            "Which country is known as the 'Land of the Rising Sun' and hosted the 2020 Summer Olympics?",
            "Japan",
            "China",
            "South Korea",
            "Australia",
            1
        ))

        sportsQuestions.add(QuestionsView(
            73,
            "Who holds the record for the most career goals in the history of the NHL (National Hockey League)?",
            "Wayne Gretzky",
            "Alex Ovechkin",
            "Jaromir Jagr",
            "Mario Lemieux",
            1
        ))

        sportsQuestions.add(QuestionsView(
            74,
            "What is the official ball used in the sport of squash?",
            "Dunlop",
            "Wilson",
            "Head",
            "Prince",
            1
        ))

        sportsQuestions.add(QuestionsView(
            75,
            "Who is the only player to have won the FIFA World Player of the Year award while playing for an MLS (Major League Soccer) club?",
            "Luka Modric",
            "David Beckham",
            "Andres Iniesta",
            "Thierry Henry",
            1
        ))

        sportsQuestions.add(QuestionsView(
            76,
            "Which country hosted the 2016 UEFA European Championship?",
            "France",
            "Germany",
            "Spain",
            "Italy",
            1
        ))

        sportsQuestions.add(QuestionsView(
            77,
            "Who is the all-time leading scorer in the history of the English Premier League?",
            "Alan Shearer",
            "Wayne Rooney",
            "Thierry Henry",
            "Andrew Cole",
            1
        ))

        sportsQuestions.add(QuestionsView(
            78,
            "In which city did the first modern Olympic Winter Games take place?",
            "Chamonix",
            "St. Moritz",
            "Innsbruck",
            "Lake Placid",
            1
        ))

        sportsQuestions.add(QuestionsView(
            79,
            "Which athlete is known as the 'Flying Finn'?",
            "Paavo Nurmi",
            "Sebastian Coe",
            "Hannes Kolehmainen",
            "Lasse Viren",
            1
        ))

        sportsQuestions.add(QuestionsView(
            80,
            "What is the term used in baseball for a batter hitting a home run, a triple, a double, and a single in the same game?",
            "Cycle",
            "Grand Slam",
            "Perfect Game",
            "No-Hitter",
            1
        ))

        sportsQuestions.add(QuestionsView(
            81,
            "Who is the only female tennis player to achieve a Golden Slam, winning all four Grand Slam titles and an Olympic gold medal in a single calendar year?",
            "Steffi Graf",
            "Serena Williams",
            "Margaret Court",
            "Martina Navratilova",
            1
        ))

        sportsQuestions.add(QuestionsView(
            82,
            "In which year did the first official Cricket World Cup take place?",
            "1975",
            "1983",
            "1992",
            "2003",
            1
        ))

        sportsQuestions.add(QuestionsView(
            83,
            "Which Formula 1 driver holds the record for the most World Drivers' Championships?",
            "Lewis Hamilton",
            "Michael Schumacher",
            "Ayrton Senna",
            "Niki Lauda",
            1
        ))

        sportsQuestions.add(QuestionsView(
            84,
            "What is the name of the annual race that takes place at Churchill Downs and is the first leg of the U.S. Triple Crown?",
            "Kentucky Derby",
            "Belmont Stakes",
            "Preakness Stakes",
            "Breeders' Cup",
            1
        ))

        sportsQuestions.add(QuestionsView(
            85,
            "Which NFL team won the first-ever Super Bowl?",
            "Green Bay Packers",
            "Kansas City Chiefs",
            "New England Patriots",
            "Pittsburgh Steelers",
            1
        ))

        sportsQuestions.add(QuestionsView(
            86,
            "Who holds the record for the most career goals in the history of women's soccer?",
            "Abby Wambach",
            "Marta",
            "Birgit Prinz",
            "Alex Morgan",
            1
        ))

        sportsQuestions.add(QuestionsView(
            87,
            "In which city did the 2018 Commonwealth Games take place?",
            "Gold Coast",
            "Melbourne",
            "Glasgow",
            "Delhi",
            1
        ))

        sportsQuestions.add(QuestionsView(
            88,
            "Which tennis player is known for his powerful serve and is nicknamed 'Dr. Ivo'?",
            "Ivo Karlovic",
            "Novak Djokovic",
            "Roger Federer",
            "Rafael Nadal",
            1
        ))

        sportsQuestions.add(QuestionsView(
            89,
            "Who is the all-time leading scorer in the history of the NBA All-Star Game?",
            "LeBron James",
            "Kobe Bryant",
            "Michael Jordan",
            "Kareem Abdul-Jabbar",
            1
        ))

        sportsQuestions.add(QuestionsView(
            90,
            "Which country won the most medals at the 2018 Winter Olympics?",
            "Norway",
            "Germany",
            "United States",
            "Canada",
            1
        ))

        sportsQuestions.add(QuestionsView(
            91,
            "Who is the only player to have won the FIFA World Cup both as a player and a manager?",
            "Franz Beckenbauer",
            "Diego Maradona",
            "Pele",
            "Zinedine Zidane",
            1
        ))

        sportsQuestions.add(QuestionsView(
            92,
            "What is the term used in golf for a score of one stroke under par on a hole?",
            "Birdie",
            "Eagle",
            "Bogey",
            "Albatross",
            1
        ))

        sportsQuestions.add(QuestionsView(
            93,
            "Who is the only boxer to have won world titles in eight different weight classes?",
            "Manny Pacquiao",
            "Floyd Mayweather",
            "Oscar De La Hoya",
            "Mike Tyson",
            1
        ))

        sportsQuestions.add(QuestionsView(
            94,
            "In which year did the first Rugby World Cup for women take place?",
            "1991",
            "1999",
            "2003",
            "2007",
            1
        ))

        sportsQuestions.add(QuestionsView(
            95,
            "Which country won the first-ever Cricket T20 World Cup in 2007?",
            "India",
            "Australia",
            "Pakistan",
            "England",
            1
        ))

        sportsQuestions.add(QuestionsView(
            96,
            "What is the name of the trophy awarded to the winner of the NBA Finals?",
            "Larry O'Brien Championship Trophy",
            "Bill Russell NBA Finals MVP Award",
            "Naismith Trophy",
            "Jordan Trophy",
            1
        ))

        sportsQuestions.add(QuestionsView(
            97,
            "Who is the all-time leading scorer in the history of the NHL (National Hockey League)?",
            "Wayne Gretzky",
            "Mario Lemieux",
            "Jaromir Jagr",
            "Alex Ovechkin",
            1
        ))

        sportsQuestions.add(QuestionsView(
            98,
            "What is the name of the annual golf tournament held at Augusta National Golf Club?",
            "The Masters",
            "The Open Championship",
            "U.S. Open",
            "PGA Championship",
            1
        ))

        sportsQuestions.add(QuestionsView(
            99,
            "Who is the only player to have won the Ballon d'Or, FIFA World Player of the Year, and UEFA Best Player in Europe Award in the same year?",
            "Lionel Messi",
            "Cristiano Ronaldo",
            "Andres Iniesta",
            "Zinedine Zidane",
            1
        ))

        return sportsQuestions
    }

    private fun createArtQuestions(): ArrayList<QuestionsView> {
        val artQuestions = ArrayList<QuestionsView>()

        artQuestions.add(QuestionsView(
            101,
            "Who painted the Mona Lisa?",
            "Leonardo da Vinci",
            "Vincent van Gogh",
            "Pablo Picasso",
            "Claude Monet",
            1
        ))

        artQuestions.add(QuestionsView(
            102,
            "Which artist is known for his 'Starry Night' painting?",
            "Vincent van Gogh",
            "Leonardo da Vinci",
            "Pablo Picasso",
            "Claude Monet",
            1
        ))

        artQuestions.add(QuestionsView(
            103,
            "Who sculpted the Statue of David?",
            "Michelangelo",
            "Leonardo da Vinci",
            "Pablo Picasso",
            "Donatello",
            1
        ))

        artQuestions.add(QuestionsView(
            104,
            "Which art movement is characterized by geometric shapes and primary colors?",
            "Cubism",
            "Surrealism",
            "Abstract Expressionism",
            "Bauhaus",
            4
        ))

        artQuestions.add(QuestionsView(
            105,
            "Who is considered the father of modern sculpture?",
            "Auguste Rodin",
            "Pablo Picasso",
            "Michelangelo",
            "Donatello",
            1
        ))

        artQuestions.add(QuestionsView(
            106,
            "Which famous painter was known for cutting off his own ear?",
            "Vincent van Gogh",
            "Pablo Picasso",
            "Claude Monet",
            "Salvador Dalí",
            1
        ))

        artQuestions.add(QuestionsView(
            107,
            "Who painted 'The Persistence of Memory,' featuring melting clocks?",
            "Salvador Dalí",
            "Pablo Picasso",
            "Claude Monet",
            "Vincent van Gogh",
            1
        ))

        artQuestions.add(QuestionsView(
            108,
            "Which art style is characterized by distorted and exaggerated depictions of the human form?",
            "Expressionism",
            "Impressionism",
            "Realism",
            "Surrealism",
            1
        ))

        artQuestions.add(QuestionsView(
            109,
            "Who created the famous painting 'Guernica,' depicting the horrors of war?",
            "Pablo Picasso",
            "Vincent van Gogh",
            "Salvador Dalí",
            "Claude Monet",
            1
        ))

        artQuestions.add(QuestionsView(
            110,
            "In which city is the Louvre Museum located?",
            "Paris",
            "Rome",
            "London",
            "New York",
            1
        ))

        artQuestions.add(QuestionsView(
            111,
            "Who is known for creating the 'Campbell's Soup Cans' artwork?",
            "Andy Warhol",
            "Jackson Pollock",
            "Roy Lichtenstein",
            "Claude Monet",
            1
        ))

        artQuestions.add(QuestionsView(
            112,
            "Which artist is associated with the technique of pointillism?",
            "Georges Seurat",
            "Claude Monet",
            "Pierre-Auguste Renoir",
            "Edgar Degas",
            1
        ))

        artQuestions.add(QuestionsView(
            113,
            "Who painted 'The Starry Night'?",
            "Vincent van Gogh",
            "Pablo Picasso",
            "Claude Monet",
            "Salvador Dalí",
            1
        ))

        artQuestions.add(QuestionsView(
            114,
            "Which Renaissance artist is known for his frescoes in the Sistine Chapel?",
            "Michelangelo",
            "Leonardo da Vinci",
            "Raphael",
            "Donatello",
            1
        ))

        artQuestions.add(QuestionsView(
            115,
            "Which artistic movement emerged in the early 20th century and is known for its irrational and dreamlike imagery?",
            "Surrealism",
            "Cubism",
            "Abstract Expressionism",
            "Pop Art",
            1
        ))

        artQuestions.add(QuestionsView(
            116,
            "Who painted 'Water Lilies'?",
            "Claude Monet",
            "Vincent van Gogh",
            "Pablo Picasso",
            "Salvador Dalí",
            1
        ))

        artQuestions.add(QuestionsView(
            117,
            "Which artist is known for his 'Whaam!' painting, a depiction of a fighter plane being hit?",
            "Roy Lichtenstein",
            "Andy Warhol",
            "Jackson Pollock",
            "Pablo Picasso",
            1
        ))

        artQuestions.add(QuestionsView(
            118,
            "Who sculpted 'The Thinker'?",
            "Auguste Rodin",
            "Pablo Picasso",
            "Michelangelo",
            "Donatello",
            1
        ))

        artQuestions.add(QuestionsView(
            119,
            "Which artist is associated with the concept of 'readymades,' everyday objects presented as art?",
            "Marcel Duchamp",
            "Salvador Dalí",
            "Andy Warhol",
            "Pablo Picasso",
            1
        ))

        artQuestions.add(QuestionsView(
            120,
            "In which country was the famous painter Frida Kahlo born?",
            "Mexico",
            "Spain",
            "Italy",
            "France",
            1
        ))

        artQuestions.add(QuestionsView(
            121,
            "Who painted 'American Gothic,' featuring a farmer and his daughter with a pitchfork?",
            "Grant Wood",
            "Edward Hopper",
            "Andrew Wyeth",
            "Georgia O'Keeffe",
            1
        ))

        artQuestions.add(QuestionsView(
            122,
            "Which art movement is known for its use of geometric shapes and bold colors, often in non-representational compositions?",
            "Abstract Expressionism",
            "Cubism",
            "Pop Art",
            "Suprematism",
            3
        ))

        artQuestions.add(QuestionsView(
            123,
            "Who created the iconic 'The Birth of Venus' painting?",
            "Sandro Botticelli",
            "Leonardo da Vinci",
            "Raphael",
            "Michelangelo",
            1
        ))

        artQuestions.add(QuestionsView(
            124,
            "What is the name of the famous avenue in Paris known for its theaters, cafes, and shops, featured in many artworks?",
            "Champs-Élysées",
            "Rue de la Paix",
            "Boulevard Saint-Germain",
            "Avenue Montaigne",
            1
        ))

        artQuestions.add(QuestionsView(
            125,
            "Who is considered the pioneer of abstract art?",
            "Wassily Kandinsky",
            "Piet Mondrian",
            "Kazimir Malevich",
            "Marc Chagall",
            1
        ))

        artQuestions.add(QuestionsView(
            126,
            "Who painted 'The Girl with a Pearl Earring'?",
            "Johannes Vermeer",
            "Rembrandt",
            "Vincent van Gogh",
            "Claude Monet",
            1
        ))

        artQuestions.add(QuestionsView(
            127,
            "Which artist is known for his large-scale environmental works, such as 'The Gates' in Central Park?",
            "Christo",
            "Anish Kapoor",
            "Jeff Koons",
            "Yayoi Kusama",
            1
        ))

        artQuestions.add(QuestionsView(
            128,
            "In which city is the Guggenheim Museum designed by Frank Lloyd Wright located?",
            "New York",
            "Paris",
            "London",
            "Berlin",
            1
        ))

        artQuestions.add(QuestionsView(
            129,
            "Who painted 'The Scream'?",
            "Edvard Munch",
            "Gustav Klimt",
            "Pablo Picasso",
            "Henri Matisse",
            1
        ))

        artQuestions.add(QuestionsView(
            130,
            "Which artist is known for his sculptures of balloon animals?",
            "Jeff Koons",
            "Banksy",
            "Damien Hirst",
            "Yayoi Kusama",
            1
        ))

        artQuestions.add(QuestionsView(
            131,
            "Who created the sculpture 'The Thinker'?",
            "Auguste Rodin",
            "Michelangelo",
            "Donatello",
            "Pablo Picasso",
            1
        ))

        artQuestions.add(QuestionsView(
            132,
            "In which art movement does artists use everyday objects in their works, blurring the line between art and reality?",
            "Pop Art",
            "Dadaism",
            "Minimalism",
            "Surrealism",
            1
        ))

        artQuestions.add(QuestionsView(
            133,
            "Which famous artist is known for his unique mustache and self-portraits?",
            "Salvador Dalí",
            "Frida Kahlo",
            "René Magritte",
            "Yves Klein",
            2
        ))

        artQuestions.add(QuestionsView(
            134,
            "Who is the creator of the famous 'Campbell's Soup Cans' artwork?",
            "Andy Warhol",
            "Roy Lichtenstein",
            "Jackson Pollock",
            "Pablo Picasso",
            1
        ))

        artQuestions.add(QuestionsView(
            135,
            "Which art movement sought to portray the inner workings of the mind through distorted and dreamlike imagery?",
            "Surrealism",
            "Expressionism",
            "Cubism",
            "Fauvism",
            1
        ))

        artQuestions.add(QuestionsView(
            136,
            "Who is known for the 'Blue Period' and 'Rose Period' in his paintings?",
            "Pablo Picasso",
            "Vincent van Gogh",
            "Claude Monet",
            "Edgar Degas",
            1
        ))

        artQuestions.add(QuestionsView(
            137,
            "In which century did the Renaissance art movement flourish?",
            "15th and 16th centuries",
            "14th and 15th centuries",
            "16th and 17th centuries",
            "17th and 18th centuries",
            1
        ))

        artQuestions.add(QuestionsView(
            138,
            "Who painted 'The Birth of Venus'?",
            "Sandro Botticelli",
            "Leonardo da Vinci",
            "Raphael",
            "Michelangelo",
            1
        ))

        artQuestions.add(QuestionsView(
            139,
            "Which artist is known for his abstract expressionist 'drip paintings'?",
            "Jackson Pollock",
            "Willem de Kooning",
            "Mark Rothko",
            "Franz Kline",
            1
        ))

        artQuestions.add(QuestionsView(
            140,
            "Who is considered the founder of the Cubist movement?",
            "Pablo Picasso",
            "Georges Braque",
            "Fernand Léger",
            "Juan Gris",
            1
        ))

        artQuestions.add(QuestionsView(
            141,
            "Which artist is associated with the design of the Sydney Opera House?",
            "Jørn Utzon",
            "Frank Gehry",
            "Zaha Hadid",
            "I. M. Pei",
            1
        ))

        artQuestions.add(QuestionsView(
            142,
            "Who painted 'The Night Watch'?",
            "Rembrandt",
            "Vermeer",
            "Van Gogh",
            "Hals",
            1
        ))

        artQuestions.add(QuestionsView(
            143,
            "In which country did the art movement known as Fauvism originate?",
            "France",
            "Spain",
            "Italy",
            "Germany",
            1
        ))

        artQuestions.add(QuestionsView(
            144,
            "Which artist is known for creating 'The Persistence of Memory'?",
            "Salvador Dalí",
            "René Magritte",
            "Giorgio de Chirico",
            "Max Ernst",
            1
        ))

        artQuestions.add(QuestionsView(
            145,
            "Who painted 'Whistler's Mother'?",
            "James McNeill Whistler",
            "John Singer Sargent",
            "Winslow Homer",
            "Thomas Eakins",
            1
        ))

        artQuestions.add(QuestionsView(
            146,
            "In which movement does art often depict scenes of everyday life in a realistic manner?",
            "Realism",
            "Impressionism",
            "Post-Impressionism",
            "Baroque",
            1
        ))

        artQuestions.add(QuestionsView(
            147,
            "Who is known for his large-scale outdoor installation 'The Gates' in Central Park?",
            "Christo",
            "Anish Kapoor",
            "Jeff Koons",
            "Yayoi Kusama",
            1
        ))

        artQuestions.add(QuestionsView(
            148,
            "Which artist is associated with the 'mobile,' a type of kinetic sculpture?",
            "Alexander Calder",
            "Barbara Hepworth",
            "Henry Moore",
            "Isamu Noguchi",
            1
        ))

        artQuestions.add(QuestionsView(
            149,
            "Who is known for his cut-out collages, such as 'Blue Nude II'?",
            "Henri Matisse",
            "Georges Braque",
            "Juan Gris",
            "Fernand Léger",
            1
        ))

        artQuestions.add(QuestionsView(
            150,
            "In which city is the famous painting 'The Kiss' by Gustav Klimt displayed?",
            "Vienna",
            "Paris",
            "Florence",
            "Amsterdam",
            1
        ))

        artQuestions.add(QuestionsView(
            151,
            "Who painted 'The Garden of Earthly Delights'?",
            "Hieronymus Bosch",
            "Pieter Bruegel the Elder",
            "Sandro Botticelli",
            "Leonardo da Vinci",
            1
        ))

        artQuestions.add(QuestionsView(
            152,
            "In which city is the Uffizi Gallery, housing a renowned collection of Renaissance art?",
            "Florence",
            "Rome",
            "Venice",
            "Milan",
            1
        ))

        artQuestions.add(QuestionsView(
            153,
            "Which art movement emphasized spontaneous, automatic, or subconscious creation, often using techniques like scribbling?",
            "Abstract Expressionism",
            "Surrealism",
            "Dadaism",
            "Cubism",
            2
        ))

        artQuestions.add(QuestionsView(
            154,
            "Who is known for his avant-garde designs in the Art Nouveau movement, including the iconic 'Metro' entrance in Paris?",
            "Hector Guimard",
            "Antoni Gaudí",
            "Louis Comfort Tiffany",
            "Alphonse Mucha",
            1
        ))

        artQuestions.add(QuestionsView(
            155,
            "Which artist is known for his paintings of water lilies and Japanese bridges?",
            "Claude Monet",
            "Edgar Degas",
            "Auguste Renoir",
            "Camille Pissarro",
            1
        ))

        artQuestions.add(QuestionsView(
            156,
            "Who is considered the pioneer of abstract photography, known for his 'Photograms'?",
            "Man Ray",
            "Ansel Adams",
            "Edward Weston",
            "Dorothea Lange",
            1
        ))

        artQuestions.add(QuestionsView(
            157,
            "In which country was the artist Frida Kahlo born?",
            "Mexico",
            "Spain",
            "Italy",
            "France",
            1
        ))

        artQuestions.add(QuestionsView(
            158,
            "Who painted 'The Night Cafe,' featuring a vivid and distorted depiction of a cafe interior?",
            "Vincent van Gogh",
            "Pablo Picasso",
            "Salvador Dalí",
            "Claude Monet",
            1
        ))

        artQuestions.add(QuestionsView(
            159,
            "Which art movement is known for its use of bold colors, geometric shapes, and a focus on depicting the emotional and spiritual?",
            "Fauvism",
            "Cubism",
            "Expressionism",
            "Surrealism",
            3
        ))

        artQuestions.add(QuestionsView(
            160,
            "Who is known for his works such as 'The Birth of the Virgin' and 'Primavera'?",
            "Sandro Botticelli",
            "Raphael",
            "Leonardo da Vinci",
            "Titian",
            1
        ))

        artQuestions.add(QuestionsView(
            161,
            "In which city is the iconic statue 'The Little Mermaid' located?",
            "Copenhagen",
            "Stockholm",
            "Oslo",
            "Helsinki",
            1
        ))

        artQuestions.add(QuestionsView(
            162,
            "Who created the iconic 'LOVE' sculpture, featuring the word in capital letters arranged in a square?",
            "Robert Indiana",
            "Keith Haring",
            "Yayoi Kusama",
            "Jean-Michel Basquiat",
            1
        ))

        artQuestions.add(QuestionsView(
            163,
            "Which art movement sought to depict scenes of daily life in a realistic and unidealized manner?",
            "Realism",
            "Impressionism",
            "Baroque",
            "Post-Impressionism",
            1
        ))

        artQuestions.add(QuestionsView(
            164,
            "Who painted 'The Hay Wain,' depicting a rural scene with a cart in a river?",
            "John Constable",
            "J.M.W. Turner",
            "Thomas Gainsborough",
            "William Blake",
            1
        ))

        artQuestions.add(QuestionsView(
            165,
            "Which artist is known for his pop art depictions of Campbell's Soup cans?",
            "Andy Warhol",
            "Roy Lichtenstein",
            "Jasper Johns",
            "Robert Rauschenberg",
            1
        ))

        artQuestions.add(QuestionsView(
            166,
            "Who is known for his 'Woman I' painting, featuring an abstract portrayal of a woman?",
            "Willem de Kooning",
            "Jackson Pollock",
            "Mark Rothko",
            "Franz Kline",
            1
        ))

        artQuestions.add(QuestionsView(
            167,
            "In which city is the Museum of Modern Art (MoMA) located?",
            "New York",
            "Paris",
            "London",
            "Berlin",
            1
        ))

        artQuestions.add(QuestionsView(
            168,
            "Who is known for his large, colorful sculptures, including 'Balloon Dog'?",
            "Jeff Koons",
            "Anish Kapoor",
            "Damien Hirst",
            "Yayoi Kusama",
            1
        ))

        artQuestions.add(QuestionsView(
            169,
            "Which art movement emerged in the early 20th century, emphasizing geometric forms and a rejection of ornamentation?",
            "De Stijl",
            "Suprematism",
            "Bauhaus",
            "Abstract Expressionism",
            1
        ))

        artQuestions.add(QuestionsView(
            170,
            "Who is known for his 'Blue Rider' paintings and is considered a pioneer of abstract art?",
            "Wassily Kandinsky",
            "Piet Mondrian",
            "Kazimir Malevich",
            "Marc Chagall",
            1
        ))

        artQuestions.add(QuestionsView(
            171,
            "In which art movement does art often focus on the subconscious mind, dreams, and irrational imagery?",
            "Surrealism",
            "Expressionism",
            "Dadaism",
            "Cubism",
            1
        ))

        artQuestions.add(QuestionsView(
            172,
            "Who is known for his 'Red Room' painting, depicting a vibrant interior scene?",
            "Henri Matisse",
            "Pablo Picasso",
            "Edgar Degas",
            "Camille Pissarro",
            1
        ))

        artQuestions.add(QuestionsView(
            173,
            "Which artist is known for his sculptures made of found objects, such as 'Bicycle Wheel'?",
            "Marcel Duchamp",
            "Jean Arp",
            "Man Ray",
            "Joan Miró",
            1
        ))

        artQuestions.add(QuestionsView(
            175,
            "Who painted 'The Arnolfini Portrait,' a detailed depiction of a couple in a domestic setting?",
            "Jan van Eyck",
            "Hieronymus Bosch",
            "Pieter Bruegel the Elder",
            "Sandro Botticelli",
            1
        ))

        artQuestions.add(QuestionsView(
            176,
            "In which city is the famous painting 'The Last Supper' by Leonardo da Vinci located?",
            "Milan",
            "Rome",
            "Florence",
            "Venice",
            1
        ))

        artQuestions.add(QuestionsView(
            177,
            "Who is known for his mobiles, hanging sculptures that move with air currents?",
            "Alexander Calder",
            "Barbara Hepworth",
            "Henry Moore",
            "Isamu Noguchi",
            1
        ))

        artQuestions.add(QuestionsView(
            178,
            "Which artist is associated with the creation of the iconic 'We Can Do It!' poster during World War II?",
            "J. Howard Miller",
            "Norman Rockwell",
            "Grant Wood",
            "Andrew Wyeth",
            1
        ))

        artQuestions.add(QuestionsView(
            179,
            "In which art movement does the artist create works using assemblage and collage techniques?",
            "Dadaism",
            "Cubism",
            "Surrealism",
            "Pop Art",
            1
        ))

        artQuestions.add(QuestionsView(
            180,
            "Who painted 'The Son of Man,' featuring a man in a bowler hat with an apple covering his face?",
            "René Magritte",
            "Salvador Dalí",
            "Giorgio de Chirico",
            "Max Ernst",
            1
        ))

        artQuestions.add(QuestionsView(
            181,
            "In which country was the artist Gustav Klimt born?",
            "Austria",
            "Germany",
            "Switzerland",
            "Hungary",
            1
        ))

        artQuestions.add(QuestionsView(
            182,
            "Who created the sculptural installation 'The Gates' in Central Park, New York City?",
            "Christo and Jeanne-Claude",
            "Anish Kapoor",
            "Jeff Koons",
            "Yayoi Kusama",
            1
        ))

        artQuestions.add(QuestionsView(
            183,
            "Which artist is known for his use of readymades, ordinary objects presented as art?",
            "Marcel Duchamp",
            "Man Ray",
            "Yves Klein",
            "Joan Miró",
            1
        ))

        artQuestions.add(QuestionsView(
            184,
            "Who is known for his large-scale outdoor artworks, such as 'Wrapped Reichstag'?",
            "Christo and Jeanne-Claude",
            "Anselm Kiefer",
            "Damien Hirst",
            "Yayoi Kusama",
            1
        ))

        artQuestions.add(QuestionsView(
            185,
            "Which artist is associated with the design of the Sydney Opera House?",
            "Jørn Utzon",
            "Frank Gehry",
            "Zaha Hadid",
            "I. M. Pei",
            1
        ))

        artQuestions.add(QuestionsView(
            186,
            "Who is known for his use of chiaroscuro, creating dramatic lighting contrasts in his paintings?",
            "Caravaggio",
            "Rembrandt",
            "Titian",
            "Vermeer",
            1
        ))

        artQuestions.add(QuestionsView(
            187,
            "In which city is the famous painting 'American Gothic' by Grant Wood displayed?",
            "Chicago",
            "New York",
            "Los Angeles",
            "Cedar Rapids",
            1
        ))

        artQuestions.add(QuestionsView(
            188,
            "Who painted 'Liberty Leading the People,' an allegorical depiction of the July Revolution of 1830?",
            "Eugène Delacroix",
            "Jean-Léon Gérôme",
            "Jacques-Louis David",
            "Édouard Manet",
            1
        ))

        artQuestions.add(QuestionsView(
            189,
            "Which artist is known for his 'Cut-Outs' series, created by cutting and arranging colored paper?",
            "Henri Matisse",
            "Pablo Picasso",
            "Claude Monet",
            "Edgar Degas",
            1
        ))

        artQuestions.add(QuestionsView(
            190,
            "Who is considered the founder of the Italian Renaissance?",
            "Giotto di Bondone",
            "Leonardo da Vinci",
            "Sandro Botticelli",
            "Michelangelo Buonarroti",
            1
        ))

        artQuestions.add(QuestionsView(
            191,
            "In which city is the famous painting 'The Birth of Venus' by Sandro Botticelli displayed?",
            "Florence",
            "Rome",
            "Milan",
            "Venice",
            1
        ))

        artQuestions.add(QuestionsView(
            192,
            "Who painted 'The Swing,' a Rococo masterpiece featuring a woman on a swing?",
            "Jean-Honoré Fragonard",
            "Jacques-Louis David",
            "Antoine Watteau",
            "Élisabeth Louise Vigée Le Brun",
            1
        ))

        artQuestions.add(QuestionsView(
            193,
            "Which artist is known for his 'Blue Period' and 'Rose Period' paintings?",
            "Pablo Picasso",
            "Vincent van Gogh",
            "Claude Monet",
            "Edgar Degas",
            1
        ))

        artQuestions.add(QuestionsView(
            194,
            "In which country did the art movement known as Suprematism originate?",
            "Russia",
            "France",
            "Germany",
            "Italy",
            1
        ))

        artQuestions.add(QuestionsView(
            195,
            "Who painted 'Nighthawks,' depicting a late-night diner scene?",
            "Edward Hopper",
            "Grant Wood",
            "Andrew Wyeth",
            "Georgia O'Keeffe",
            1
        ))

        artQuestions.add(QuestionsView(
            196,
            "Which artist is known for his sculptures of dancers, including 'The Little Fourteen-Year-Old Dancer'?",
            "Edgar Degas",
            "Auguste Rodin",
            "Camille Claudel",
            "Henri Matisse",
            1
        ))

        artQuestions.add(QuestionsView(
            197,
            "Who painted 'The Kiss,' depicting a couple embracing amid a golden background?",
            "Gustav Klimt",
            "Egon Schiele",
            "Oskar Kokoschka",
            "Franz von Stuck",
            1
        ))

        return artQuestions
    }

    private fun createPoliticsQuestions(): ArrayList<QuestionsView> {
        val politicsQuestions = ArrayList<QuestionsView>()

        politicsQuestions.add(QuestionsView(
            201,
            "Who is the current President of the United States?",
            "Joe Biden",
            "Donald Trump",
            "Barack Obama",
            "George W. Bush",
            1
        ))

        politicsQuestions.add(QuestionsView(
            202,
            "In which country is Angela Merkel known for her role as the Chancellor?",
            "Germany",
            "France",
            "Italy",
            "United Kingdom",
            1
        ))

        politicsQuestions.add(QuestionsView(
            203,
            "What is the capital city of Canada?",
            "Ottawa",
            "Toronto",
            "Vancouver",
            "Montreal",
            1
        ))

        politicsQuestions.add(QuestionsView(
            204,
            "Who is the Prime Minister of the United Kingdom?",
            "Boris Johnson",
            "Theresa May",
            "David Cameron",
            "Tony Blair",
            1
        ))

        politicsQuestions.add(QuestionsView(
            205,
            "Which country is often referred to as the 'Land of the Rising Sun'?",
            "Japan",
            "China",
            "South Korea",
            "Vietnam",
            1
        ))

        politicsQuestions.add(QuestionsView(
            206,
            "What is the official currency of the European Union?",
            "Euro",
            "Pound Sterling",
            "Dollar",
            "Yen",
            1
        ))

        politicsQuestions.add(QuestionsView(
            207,
            "Who is the current President of France?",
            "Emmanuel Macron",
            "Nicolas Sarkozy",
            "François Hollande",
            "Jacques Chirac",
            1
        ))

        politicsQuestions.add(QuestionsView(
            208,
            "Which political ideology advocates for the abolition of private property and a classless society?",
            "Communism",
            "Capitalism",
            "Socialism",
            "Liberalism",
            1
        ))

        politicsQuestions.add(QuestionsView(
            209,
            "In which year did the United States declare its independence from Great Britain?",
            "1776",
            "1789",
            "1800",
            "1865",
            1
        ))

        politicsQuestions.add(QuestionsView(
            210,
            "Who is the leader of Russia?",
            "Vladimir Putin",
            "Dmitry Medvedev",
            "Boris Yeltsin",
            "Mikhail Gorbachev",
            1
        ))

        politicsQuestions.add(QuestionsView(
            211,
            "What is the largest democratic country in the world by population?",
            "India",
            "China",
            "United States",
            "Brazil",
            1
        ))

        politicsQuestions.add(QuestionsView(
            212,
            "Which international organization promotes peace and security among nations?",
            "United Nations",
            "European Union",
            "NATO",
            "ASEAN",
            1
        ))

        politicsQuestions.add(QuestionsView(
            213,
            "Who is the head of state in Canada?",
            "Queen Elizabeth II",
            "Justin Trudeau",
            "Andrew Scheer",
            "Stephen Harper",
            1
        ))

        politicsQuestions.add(QuestionsView(
            214,
            "Which political figure is associated with the 'Iron Lady' nickname?",
            "Margaret Thatcher",
            "Angela Merkel",
            "Hillary Clinton",
            "Indira Gandhi",
            1
        ))

        politicsQuestions.add(QuestionsView(
            215,
            "In which country did the Arab Spring movement begin in 2010?",
            "Tunisia",
            "Egypt",
            "Syria",
            "Libya",
            1
        ))

        politicsQuestions.add(QuestionsView(
            216,
            "Who is the current Prime Minister of Japan?",
            "Yoshihide Suga",
            "Shinzo Abe",
            "Naoto Kan",
            "Junichiro Koizumi",
            1
        ))

        politicsQuestions.add(QuestionsView(
            217,
            "Which political system is characterized by a single-party government with centralized control?",
            "Authoritarianism",
            "Democracy",
            "Oligarchy",
            "Anarchy",
            1
        ))

        politicsQuestions.add(QuestionsView(
            218,
            "What is the official language of Brazil?",
            "Portuguese",
            "Spanish",
            "French",
            "Italian",
            1
        ))

        politicsQuestions.add(QuestionsView(
            219,
            "Who was the first President of the United States?",
            "George Washington",
            "Thomas Jefferson",
            "John Adams",
            "James Madison",
            1
        ))

        politicsQuestions.add(QuestionsView(
            220,
            "In which city is the headquarters of the United Nations located?",
            "New York",
            "Geneva",
            "Vienna",
            "Paris",
            1
        ))

        politicsQuestions.add(QuestionsView(
            221,
            "What is the political system of the United States?",
            "Presidential Republic",
            "Parliamentary Democracy",
            "Constitutional Monarchy",
            "Authoritarianism",
            1
        ))

        politicsQuestions.add(QuestionsView(
            222,
            "Who is the President of China?",
            "Xi Jinping",
            "Hu Jintao",
            "Jiang Zemin",
            "Deng Xiaoping",
            1
        ))

        politicsQuestions.add(QuestionsView(
            223,
            "Which U.S. political party is often associated with the color blue?",
            "Democrats",
            "Republicans",
            "Green Party",
            "Libertarians",
            1
        ))

        politicsQuestions.add(QuestionsView(
            224,
            "In which country did the Velvet Revolution lead to the end of communist rule?",
            "Czechoslovakia",
            "Poland",
            "Hungary",
            "East Germany",
            1
        ))

        politicsQuestions.add(QuestionsView(
            225,
            "Who is the Chancellor of Germany known for her role in handling the Eurozone crisis?",
            "Angela Merkel",
            "Gerhard Schröder",
            "Helmut Kohl",
            "Willy Brandt",
            1
        ))

        politicsQuestions.add(QuestionsView(
            226,
            "What is the capital city of Australia?",
            "Canberra",
            "Sydney",
            "Melbourne",
            "Brisbane",
            1
        ))

        politicsQuestions.add(QuestionsView(
            227,
            "Who is the current President of Brazil?",
            "Jair Bolsonaro",
            "Luiz Inácio Lula da Silva",
            "Dilma Rousseff",
            "Fernando Henrique Cardoso",
            1
        ))

        politicsQuestions.add(QuestionsView(
            228,
            "In which country is the ANC (African National Congress) a prominent political party?",
            "South Africa",
            "Nigeria",
            "Kenya",
            "Ghana",
            1
        ))

        politicsQuestions.add(QuestionsView(
            229,
            "Who is the Prime Minister of India?",
            "Narendra Modi",
            "Manmohan Singh",
            "Indira Gandhi",
            "Rajiv Gandhi",
            1
        ))

        politicsQuestions.add(QuestionsView(
            230,
            "Which U.S. state is known as the 'Sunshine State'?",
            "Florida",
            "California",
            "Texas",
            "Hawaii",
            1
        ))

        politicsQuestions.add(QuestionsView(
            231,
            "Who is the current President of South Korea?",
            "Moon Jae-in",
            "Park Geun-hye",
            "Lee Myung-bak",
            "Kim Dae-jung",
            1
        ))

        politicsQuestions.add(QuestionsView(
            232,
            "What is the official currency of China?",
            "Renminbi (Yuan)",
            "Yen",
            "Won",
            "Ringgit",
            1
        ))

        politicsQuestions.add(QuestionsView(
            233,
            "Who was the first woman to serve as the Prime Minister of the United Kingdom?",
            "Margaret Thatcher",
            "Theresa May",
            "Indira Gandhi",
            "Angela Merkel",
            1
        ))

        politicsQuestions.add(QuestionsView(
            234,
            "In which country did the Arab Spring protests result in the overthrow of Hosni Mubarak?",
            "Egypt",
            "Tunisia",
            "Libya",
            "Syria",
            1
        ))

        politicsQuestions.add(QuestionsView(
            235,
            "What is the name of the official residence and workplace of the President of the United States?",
            "White House",
            "Capitol Hill",
            "Pentagon",
            "Oval Office",
            1
        ))

        politicsQuestions.add(QuestionsView(
            236,
            "Who is the leader of the Labour Party in the United Kingdom?",
            "Keir Starmer",
            "Jeremy Corbyn",
            "Tony Blair",
            "Gordon Brown",
            1
        ))

        politicsQuestions.add(QuestionsView(
            237,
            "Which country is known as the 'Land of the Midnight Sun'?",
            "Norway",
            "Sweden",
            "Finland",
            "Denmark",
            1
        ))

        politicsQuestions.add(QuestionsView(
            238,
            "Who is the current President of Mexico?",
            "Andrés Manuel López Obrador",
            "Enrique Peña Nieto",
            "Felipe Calderón",
            "Vicente Fox",
            1
        ))

        politicsQuestions.add(QuestionsView(
            239,
            "In which city is the headquarters of the African Union located?",
            "Addis Ababa",
            "Nairobi",
            "Johannesburg",
            "Lagos",
            1
        ))

        politicsQuestions.add(QuestionsView(
            240,
            "Who is the current Prime Minister of Canada?",
            "Justin Trudeau",
            "Stephen Harper",
            "Paul Martin",
            "Jean Chrétien",
            1
        ))

        politicsQuestions.add(QuestionsView(
            241,
            "What is the official language of Saudi Arabia?",
            "Arabic",
            "Persian",
            "Turkish",
            "Urdu",
            1
        ))

        politicsQuestions.add(QuestionsView(
            242,
            "Who is the current President of Nigeria?",
            "Muhammadu Buhari",
            "Goodluck Jonathan",
            "Olusegun Obasanjo",
            "Shehu Shagari",
            1
        ))

        politicsQuestions.add(QuestionsView(
            243,
            "In which country did the Tiananmen Square protests take place in 1989?",
            "China",
            "Japan",
            "South Korea",
            "Taiwan",
            1
        ))

        politicsQuestions.add(QuestionsView(
            244,
            "Who is the current Prime Minister of Australia?",
            "Scott Morrison",
            "Malcolm Turnbull",
            "Tony Abbott",
            "Kevin Rudd",
            1
        ))

        politicsQuestions.add(QuestionsView(
            245,
            "What is the official language of Iran?",
            "Persian",
            "Arabic",
            "Turkish",
            "Pashto",
            1
        ))

        politicsQuestions.add(QuestionsView(
            246,
            "Who is the President of the European Commission?",
            "Ursula von der Leyen",
            "Jean-Claude Juncker",
            "José Manuel Barroso",
            "Romano Prodi",
            1
        ))

        politicsQuestions.add(QuestionsView(
            247,
            "Which U.S. state is known as the 'Lone Star State'?",
            "Texas",
            "California",
            "Florida",
            "New York",
            1
        ))

        politicsQuestions.add(QuestionsView(
            248,
            "Who is the current Prime Minister of Israel?",
            "Naftali Bennett",
            "Benjamin Netanyahu",
            "Ehud Barak",
            "Ariel Sharon",
            1
        ))

        politicsQuestions.add(QuestionsView(
            249,
            "In which country is the city of Pretoria the administrative capital?",
            "South Africa",
            "Kenya",
            "Nigeria",
            "Ghana",
            1
        ))

        politicsQuestions.add(QuestionsView(
            250,
            "Who is the current President of Argentina?",
            "Alberto Fernández",
            "Mauricio Macri",
            "Cristina Fernández de Kirchner",
            "Néstor Kirchner",
            1
        ))

        politicsQuestions.add(QuestionsView(
            251,
            "What is the official language of Switzerland?",
            "German",
            "French",
            "Italian",
            "Romansh",
            1
        ))

        politicsQuestions.add(QuestionsView(
            252,
            "Who is the current President of Turkey?",
            "Recep Tayyip Erdoğan",
            "Abdullah Gül",
            "Ahmet Davutoğlu",
            "Binali Yıldırım",
            1
        ))

        politicsQuestions.add(QuestionsView(
            253,
            "In which country is the Parliament known as the 'Bundestag'?",
            "Germany",
            "Austria",
            "Switzerland",
            "Netherlands",
            1
        ))

        politicsQuestions.add(QuestionsView(
            254,
            "Who is the current President of Iran?",
            "Ebrahim Raisi",
            "Hassan Rouhani",
            "Mahmoud Ahmadinejad",
            "Mohammad Khatami",
            1
        ))

        politicsQuestions.add(QuestionsView(
            255,
            "Which U.S. state is known as the 'Granite State'?",
            "New Hampshire",
            "Rhode Island",
            "Vermont",
            "Connecticut",
            1
        ))

        politicsQuestions.add(QuestionsView(
            256,
            "Who is the current Prime Minister of Italy?",
            "Mario Draghi",
            "Giuseppe Conte",
            "Matteo Renzi",
            "Silvio Berlusconi",
            1
        ))

        politicsQuestions.add(QuestionsView(
            257,
            "What is the official language of Indonesia?",
            "Indonesian",
            "Malay",
            "Javanese",
            "Balinese",
            1
        ))

        politicsQuestions.add(QuestionsView(
            258,
            "Who is the Chancellor of Austria?",
            "Karl Nehammer",
            "Sebastian Kurz",
            "Werner Faymann",
            "Wolfgang Schüssel",
            1
        ))

        politicsQuestions.add(QuestionsView(
            259,
            "In which country is the Palace of Westminster, housing the UK Parliament?",
            "United Kingdom",
            "Canada",
            "Australia",
            "New Zealand",
            1
        ))

        politicsQuestions.add(QuestionsView(
            260,
            "Who is the current President of Egypt?",
            "Abdel Fattah el-Sisi",
            "Mohamed Morsi",
            "Hosni Mubarak",
            "Anwar Sadat",
            1
        ))

        politicsQuestions.add(QuestionsView(
            261,
            "Which political figure is known for his 'I Have a Dream' speech during the March on Washington?",
            "Martin Luther King Jr.",
            "Malcolm X",
            "Nelson Mandela",
            "Jesse Jackson",
            1
        ))

        politicsQuestions.add(QuestionsView(
            262,
            "What is the official language of Pakistan?",
            "Urdu",
            "Punjabi",
            "Sindhi",
            "Pashto",
            1
        ))

        politicsQuestions.add(QuestionsView(
            263,
            "Who is the current Prime Minister of New Zealand?",
            "Jacinda Ardern",
            "Bill English",
            "John Key",
            "Helen Clark",
            1
        ))

        politicsQuestions.add(QuestionsView(
            264,
            "In which country is the National Diet the legislative body?",
            "Japan",
            "China",
            "South Korea",
            "Vietnam",
            1
        ))

        politicsQuestions.add(QuestionsView(
            265,
            "Who is the President of the Palestinian Authority?",
            "Mahmoud Abbas",
            "Yasser Arafat",
            "Ismail Haniyeh",
            "Khaled Mashal",
            1
        ))

        politicsQuestions.add(QuestionsView(
            266,
            "What is the official language of Nigeria?",
            "English",
            "Hausa",
            "Yoruba",
            "Igbo",
            1
        ))

        politicsQuestions.add(QuestionsView(
            267,
            "Who is the current Prime Minister of South Africa?",
            "Cyril Ramaphosa",
            "Jacob Zuma",
            "Thabo Mbeki",
            "Nelson Mandela",
            1
        ))

        politicsQuestions.add(QuestionsView(
            268,
            "In which country is the National Assembly the legislative body?",
            "France",
            "Italy",
            "Spain",
            "Portugal",
            1
        ))

        politicsQuestions.add(QuestionsView(
            269,
            "Who is the current President of the Philippines?",
            "Rodrigo Duterte",
            "Benigno Aquino III",
            "Gloria Macapagal-Arroyo",
            "Joseph Estrada",
            1
        ))

        politicsQuestions.add(QuestionsView(
            270,
            "What is the official language of Kenya?",
            "Swahili",
            "English",
            "Kikuyu",
            "Luo",
            1
        ))

        politicsQuestions.add(QuestionsView(
            271,
            "Who is the current Prime Minister of Spain?",
            "Pedro Sánchez",
            "Mariano Rajoy",
            "José Luis Rodríguez Zapatero",
            "Felipe González",
            1
        ))

        politicsQuestions.add(QuestionsView(
            272,
            "In which country is the Kremlin the official residence of the President?",
            "Russia",
            "China",
            "Turkey",
            "Iran",
            1
        ))

        politicsQuestions.add(QuestionsView(
            273,
            "Who is the current Prime Minister of Brazil?",
            "Jair Bolsonaro",
            "Luiz Inácio Lula da Silva",
            "Dilma Rousseff",
            "Fernando Henrique Cardoso",
            1
        ))

        politicsQuestions.add(QuestionsView(
            274,
            "What is the official language of Argentina?",
            "Spanish",
            "Portuguese",
            "Italian",
            "German",
            1
        ))

        politicsQuestions.add(QuestionsView(
            275,
            "Who is the current President of Indonesia?",
            "Joko Widodo",
            "Susilo Bambang Yudhoyono",
            "Megawati Sukarnoputri",
            "Abdurrahman Wahid",
            1
        ))

        politicsQuestions.add(QuestionsView(
            276,
            "In which country is the National Congress the legislative body?",
            "India",
            "Brazil",
            "Argentina",
            "Mexico",
            1
        ))

        politicsQuestions.add(QuestionsView(
            277,
            "Who is the current Chancellor of Germany?",
            "Olaf Scholz",
            "Angela Merkel",
            "Gerhard Schröder",
            "Helmut Kohl",
            1
        ))

        politicsQuestions.add(QuestionsView(
            278,
            "What is the official language of South Africa?",
            "Afrikaans",
            "Zulu",
            "Xhosa",
            "English",
            1
        ))

        politicsQuestions.add(QuestionsView(
            279,
            "Who is the President of the Supreme Court of the United States?",
            "John G. Roberts Jr.",
            "Ruth Bader Ginsburg",
            "Elena Kagan",
            "Antonin Scalia",
            1
        ))

        politicsQuestions.add(QuestionsView(
            280,
            "In which country is the Legislative Yuan the legislative body?",
            "Taiwan",
            "China",
            "Japan",
            "South Korea",
            1
        ))

        politicsQuestions.add(QuestionsView(
            281,
            "Who is the current President of the Republic of Korea (South Korea)?",
            "Moon Jae-in",
            "Park Geun-hye",
            "Lee Myung-bak",
            "Kim Dae-jung",
            1
        ))

        politicsQuestions.add(QuestionsView(
            282,
            "What is the official language of the United Arab Emirates?",
            "Arabic",
            "Persian",
            "Urdu",
            "English",
            1
        ))

        politicsQuestions.add(QuestionsView(
            283,
            "Who is the current Prime Minister of Singapore?",
            "Lee Hsien Loong",
            "Goh Chok Tong",
            "Lee Kuan Yew",
            "Tony Tan Keng Yam",
            1
        ))

        politicsQuestions.add(QuestionsView(
            284,
            "In which country is the National Assembly the legislative body?",
            "South Korea",
            "France",
            "Spain",
            "Italy",
            1
        ))

        politicsQuestions.add(QuestionsView(
            285,
            "Who is the current President of Ukraine?",
            "Volodymyr Zelensky",
            "Petro Poroshenko",
            "Viktor Yanukovych",
            "Yulia Tymoshenko",
            1
        ))

        politicsQuestions.add(QuestionsView(
            286,
            "What is the official language of Malaysia?",
            "Malay",
            "English",
            "Mandarin",
            "Tamil",
            1
        ))

        politicsQuestions.add(QuestionsView(
            287,
            "Who is the current President of South Africa?",
            "Cyril Ramaphosa",
            "Jacob Zuma",
            "Thabo Mbeki",
            "Nelson Mandela",
            1
        ))

        politicsQuestions.add(QuestionsView(
            288,
            "In which country is the Parliament known as the 'Stortinget'?",
            "Norway",
            "Denmark",
            "Sweden",
            "Finland",
            1
        ))

        politicsQuestions.add(QuestionsView(
            289,
            "Who is the current Prime Minister of Denmark?",
            "Mette Frederiksen",
            "Helle Thorning-Schmidt",
            "Lars Løkke Rasmussen",
            "Anders Fogh Rasmussen",
            1
        ))

        politicsQuestions.add(QuestionsView(
            290,
            "What is the official language of Thailand?",
            "Thai",
            "Burmese",
            "Khmer",
            "Laotian",
            1
        ))

        politicsQuestions.add(QuestionsView(
            291,
            "Who is the current Prime Minister of Mexico?",
            "Andrés Manuel López Obrador",
            "Enrique Peña Nieto",
            "Felipe Calderón",
            "Vicente Fox",
            1
        ))

        politicsQuestions.add(QuestionsView(
            292,
            "In which country is the National Congress the legislative body?",
            "Argentina",
            "Brazil",
            "Chile",
            "Colombia",
            1
        ))

        politicsQuestions.add(QuestionsView(
            293,
            "Who is the current President of Venezuela?",
            "Nicolás Maduro",
            "Hugo Chávez",
            "Juan Guaidó",
            "Rafael Caldera",
            1
        ))

        politicsQuestions.add(QuestionsView(
            294,
            "What is the official language of Bangladesh?",
            "Bengali",
            "Hindi",
            "Urdu",
            "Arabic",
            1
        ))

        politicsQuestions.add(QuestionsView(
            295,
            "Who is the current Prime Minister of Pakistan?",
            "Imran Khan",
            "Nawaz Sharif",
            "Benazir Bhutto",
            "Yousaf Raza Gillani",
            1
        ))

        politicsQuestions.add(QuestionsView(
            296,
            "In which country is the National Assembly the legislative body?",
            "Nigeria",
            "South Africa",
            "Kenya",
            "Ghana",
            1
        ))

        politicsQuestions.add(QuestionsView(
            297,
            "Who is the current President of Iraq?",
            "Barham Salih",
            "Nouri al-Maliki",
            "Jalal Talabani",
            "Saddam Hussein",
            1
        ))

        politicsQuestions.add(QuestionsView(
            298,
            "What is the official language of Afghanistan?",
            "Pashto",
            "Dari",
            "Uzbek",
            "Turkmen",
            1
        ))

        politicsQuestions.add(QuestionsView(
            299,
            "Who is the current Prime Minister of Thailand?",
            "Prayuth Chan-o-cha",
            "Yingluck Shinawatra",
            "Abhisit Vejjajiva",
            "Thaksin Shinawatra",
            1
        ))

        politicsQuestions.add(QuestionsView(
            300,
            "In which country is the Parliament known as the 'Knesset'?",
            "Israel",
            "Saudi Arabia",
            "Jordan",
            "Lebanon",
            1
        ))

        return politicsQuestions
    }

    private fun createHistoryQuestions(): ArrayList<QuestionsView> {
        val historyQuestions = ArrayList<QuestionsView>()

        historyQuestions.add(QuestionsView(
            301,
            "Who was the first President of the United States?",
            "George Washington",
            "Thomas Jefferson",
            "John Adams",
            "James Madison",
            1
        ))

        historyQuestions.add(QuestionsView(
            302,
            "In which year did Christopher Columbus reach the Americas?",
            "1492",
            "1453",
            "1517",
            "1607",
            1
        ))

        historyQuestions.add(QuestionsView(
            303,
            "What ancient wonder was located in Alexandria, Egypt?",
            "The Lighthouse of Alexandria",
            "The Hanging Gardens of Babylon",
            "The Colossus of Rhodes",
            "The Great Pyramid of Giza",
            1
        ))

        historyQuestions.add(QuestionsView(
            304,
            "Who wrote 'The Communist Manifesto' with Karl Marx?",
            "Friedrich Engels",
            "Vladimir Lenin",
            "Joseph Stalin",
            "Mao Zedong",
            1
        ))

        historyQuestions.add(QuestionsView(
            305,
            "Which war was fought between the North and the South regions of the United States?",
            "American Civil War",
            "World War I",
            "World War II",
            "Vietnam War",
            1
        ))

        historyQuestions.add(QuestionsView(
            306,
            "What event marked the start of World War I?",
            "Assassination of Archduke Franz Ferdinand",
            "Treaty of Versailles",
            "Battle of the Bulge",
            "D-Day Invasion",
            1
        ))

        historyQuestions.add(QuestionsView(
            307,
            "Who was the Egyptian queen known for her relationships with Julius Caesar and Mark Antony?",
            "Cleopatra",
            "Nefertiti",
            "Hatshepsut",
            "Isis",
            1
        ))

        historyQuestions.add(QuestionsView(
            308,
            "In which year did the Titanic sink?",
            "1912",
            "1905",
            "1923",
            "1931",
            1
        ))

        historyQuestions.add(QuestionsView(
            309,
            "What was the name of the ship that brought the Pilgrims to America in 1620?",
            "Mayflower",
            "Santa Maria",
            "Endeavour",
            "Nina",
            1
        ))

        historyQuestions.add(QuestionsView(
            310,
            "Who was the first woman to win a Nobel Prize?",
            "Marie Curie",
            "Rosa Parks",
            "Amelia Earhart",
            "Queen Victoria",
            1
        ))

        historyQuestions.add(QuestionsView(
            311,
            "What event marked the end of the Cold War?",
            "Fall of the Berlin Wall",
            "Cuban Missile Crisis",
            "Space Race",
            "Vietnam War",
            1
        ))

        historyQuestions.add(QuestionsView(
            312,
            "Who was the first Emperor of China?",
            "Qin Shi Huang",
            "Confucius",
            "Sun Tzu",
            "Mao Zedong",
            1
        ))

        historyQuestions.add(QuestionsView(
            313,
            "What city was the capital of the Byzantine Empire?",
            "Constantinople",
            "Rome",
            "Athens",
            "Jerusalem",
            1
        ))

        historyQuestions.add(QuestionsView(
            314,
            "Who was the leader of the Soviet Union during the Cuban Missile Crisis?",
            "Nikita Khrushchev",
            "Joseph Stalin",
            "Leon Trotsky",
            "Vladimir Lenin",
            1
        ))

        historyQuestions.add(QuestionsView(
            315,
            "In which year did World War II end?",
            "1945",
            "1939",
            "1941",
            "1942",
            1
        ))

        historyQuestions.add(QuestionsView(
            316,
            "Who was the famous nurse during the Crimean War, known for her work in nursing and sanitation?",
            "Florence Nightingale",
            "Clara Barton",
            "Mary Seacole",
            "Dorothea Dix",
            1
        ))

        historyQuestions.add(QuestionsView(
            317,
            "What was the name of the first human to orbit the Earth?",
            "Yuri Gagarin",
            "Neil Armstrong",
            "Buzz Aldrin",
            "John Glenn",
            1
        ))

        historyQuestions.add(QuestionsView(
            318,
            "Who was the president of the United States during the Civil War?",
            "Abraham Lincoln",
            "Andrew Johnson",
            "Ulysses S. Grant",
            "Jefferson Davis",
            1
        ))

        historyQuestions.add(QuestionsView(
            319,
            "What ancient city was destroyed by a volcanic eruption in 79 AD?",
            "Pompeii",
            "Athens",
            "Rome",
            "Carthage",
            1
        ))

        historyQuestions.add(QuestionsView(
            320,
            "Who is known as the 'Father of Modern Physics'?",
            "Albert Einstein",
            "Isaac Newton",
            "Galileo Galilei",
            "Niels Bohr",
            1
        ))

        historyQuestions.add(QuestionsView(
            321,
            "What was the name of the ship that carried the Pilgrims to America in 1620?",
            "Mayflower",
            "Santa Maria",
            "Endeavour",
            "Nina",
            1
        ))

        historyQuestions.add(QuestionsView(
            322,
            "Which famous document declared the American colonies' independence from British rule?",
            "Declaration of Independence",
            "Constitution",
            "Bill of Rights",
            "Magna Carta",
            1
        ))

        historyQuestions.add(QuestionsView(
            323,
            "Who was the leader of the Soviet Union during World War II?",
            "Joseph Stalin",
            "Vladimir Lenin",
            "Nikita Khrushchev",
            "Leon Trotsky",
            1
        ))

        historyQuestions.add(QuestionsView(
            324,
            "In which year did the Berlin Wall fall, symbolizing the end of the Cold War?",
            "1989",
            "1991",
            "1985",
            "1993",
            1
        ))

        historyQuestions.add(QuestionsView(
            325,
            "What ancient civilization built the pyramids at Giza?",
            "Ancient Egyptians",
            "Mayans",
            "Greeks",
            "Romans",
            1
        ))

        historyQuestions.add(QuestionsView(
            326,
            "Who was the founder of the Mongol Empire?",
            "Genghis Khan",
            "Kublai Khan",
            "Attila the Hun",
            "Timur",
            1
        ))

        historyQuestions.add(QuestionsView(
            327,
            "In which year did the French Revolution begin?",
            "1789",
            "1804",
            "1750",
            "1832",
            1
        ))

        historyQuestions.add(QuestionsView(
            328,
            "What ancient civilization built the city of Machu Picchu?",
            "Inca Empire",
            "Aztec Empire",
            "Mayan Civilization",
            "Roman Empire",
            1
        ))

        historyQuestions.add(QuestionsView(
            329,
            "Who was the first emperor of Rome?",
            "Augustus",
            "Julius Caesar",
            "Caligula",
            "Nero",
            1
        ))

        historyQuestions.add(QuestionsView(
            330,
            "What event is known as the 'Night of Broken Glass'?",
            "Kristallnacht",
            "The Boston Tea Party",
            "The Gunpowder Plot",
            "The Spanish Inquisition",
            1
        ))

        historyQuestions.add(QuestionsView(
            331,
            "Who wrote 'The Art of War'?",
            "Sun Tzu",
            "Machiavelli",
            "Hannibal",
            "Alexander the Great",
            1
        ))

        historyQuestions.add(QuestionsView(
            332,
            "What was the name of the ship that carried the Pilgrims to America?",
            "Mayflower",
            "Santa Maria",
            "Endeavour",
            "Nina",
            1
        ))

        historyQuestions.add(QuestionsView(
            333,
            "Who was the longest-reigning monarch in British history?",
            "Queen Victoria",
            "Queen Elizabeth II",
            "Queen Elizabeth I",
            "King George III",
            1
        ))

        historyQuestions.add(QuestionsView(
            334,
            "What was the name of the first successful permanent English settlement in North America?",
            "Jamestown",
            "Plymouth",
            "Roanoke",
            "St. Augustine",
            1
        ))

        historyQuestions.add(QuestionsView(
            335,
            "Who was the last pharaoh of ancient Egypt?",
            "Cleopatra VII",
            "Hatshepsut",
            "Ramesses II",
            "Akhenaten",
            1
        ))

        historyQuestions.add(QuestionsView(
            336,
            "What was the major event that led to the start of World War II?",
            "Invasion of Poland",
            "Battle of Stalingrad",
            "Pearl Harbor attack",
            "D-Day",
            1
        ))

        historyQuestions.add(QuestionsView(
            337,
            "Who was the first woman to win a Nobel Prize?",
            "Marie Curie",
            "Rosa Parks",
            "Amelia Earhart",
            "Queen Victoria",
            1
        ))

        historyQuestions.add(QuestionsView(
            338,
            "In which year did the Renaissance begin?",
            "14th century",
            "15th century",
            "16th century",
            "17th century",
            1
        ))

        historyQuestions.add(QuestionsView(
            339,
            "Who was the first European explorer to reach India by sea?",
            "Vasco da Gama",
            "Christopher Columbus",
            "Ferdinand Magellan",
            "John Cabot",
            1
        ))

        historyQuestions.add(QuestionsView(
            340,
            "What event is often considered the start of the Great Depression?",
            "Wall Street Crash of 1929",
            "Dust Bowl",
            "Prohibition",
            "Roaring Twenties",
            1
        ))

        historyQuestions.add(QuestionsView(
            341,
            "Who was the leader of the Soviet Union during the Cuban Missile Crisis?",
            "Nikita Khrushchev",
            "Joseph Stalin",
            "Leon Trotsky",
            "Vladimir Lenin",
            1
        ))

        historyQuestions.add(QuestionsView(
            342,
            "What ancient wonder was located in Babylon?",
            "The Hanging Gardens of Babylon",
            "The Lighthouse of Alexandria",
            "The Colossus of Rhodes",
            "The Great Pyramid of Giza",
            1
        ))

        historyQuestions.add(QuestionsView(
            343,
            "Who was the architect of the Great Wall of China?",
            "Qin Shi Huang",
            "Sun Tzu",
            "Mao Zedong",
            "Confucius",
            1
        ))

        historyQuestions.add(QuestionsView(
            344,
            "What was the name of the ship that brought the Pilgrims to America in 1620?",
            "Mayflower",
            "Santa Maria",
            "Endeavour",
            "Nina",
            1
        ))

        historyQuestions.add(QuestionsView(
            345,
            "In which year did the Battle of Gettysburg take place during the American Civil War?",
            "1863",
            "1861",
            "1865",
            "1867",
            1
        ))

        historyQuestions.add(QuestionsView(
            346,
            "Who was the leader of the Soviet Union during the Russian Revolution?",
            "Vladimir Lenin",
            "Joseph Stalin",
            "Leon Trotsky",
            "Nikita Khrushchev",
            1
        ))

        historyQuestions.add(QuestionsView(
            347,
            "What was the main cause of the Irish Potato Famine in the 19th century?",
            "Potato blight",
            "Drought",
            "Economic collapse",
            "British colonization",
            1
        ))

        historyQuestions.add(QuestionsView(
            348,
            "Who was the leader of the Bolshevik Party during the October Revolution in Russia?",
            "Vladimir Lenin",
            "Joseph Stalin",
            "Leon Trotsky",
            "Nikita Khrushchev",
            1
        ))

        historyQuestions.add(QuestionsView(
            349,
            "What ancient civilization built the city of Troy?",
            "Ancient Greeks",
            "Hittites",
            "Persians",
            "Phoenicians",
            1
        ))

        historyQuestions.add(QuestionsView(
            350,
            "Who was the President of the United States during the Korean War?",
            "Harry S. Truman",
            "Dwight D. Eisenhower",
            "John F. Kennedy",
            "Lyndon B. Johnson",
            1
        ))

        historyQuestions.add(QuestionsView(
            351,
            "Who was the famous general of Carthage during the Second Punic War?",
            "Hannibal",
            "Scipio Africanus",
            "Julius Caesar",
            "Alexander the Great",
            1
        ))

        historyQuestions.add(QuestionsView(
            352,
            "What was the name of the ship that carried the Pilgrims to America in 1620?",
            "Mayflower",
            "Santa Maria",
            "Endeavour",
            "Nina",
            1
        ))

        historyQuestions.add(QuestionsView(
            353,
            "Which civilization is credited with the invention of the wheel?",
            "Sumerians",
            "Ancient Egyptians",
            "Indus Valley Civilization",
            "Mayans",
            1
        ))

        historyQuestions.add(QuestionsView(
            354,
            "In which year did the Industrial Revolution begin?",
            "18th century",
            "19th century",
            "17th century",
            "20th century",
            1
        ))

        historyQuestions.add(QuestionsView(
            355,
            "Who was the first woman to fly solo across the Atlantic Ocean?",
            "Amelia Earhart",
            "Bessie Coleman",
            "Jacqueline Cochran",
            "Harriet Quimby",
            1
        ))

        historyQuestions.add(QuestionsView(
            356,
            "Which city was the capital of the Byzantine Empire?",
            "Constantinople",
            "Rome",
            "Athens",
            "Jerusalem",
            1
        ))

        historyQuestions.add(QuestionsView(
            357,
            "What famous document, signed in 1215, limited the powers of the English monarch?",
            "Magna Carta",
            "Bill of Rights",
            "Petition of Right",
            "English Constitution",
            1
        ))

        historyQuestions.add(QuestionsView(
            358,
            "Who was the leader of the Soviet Union during the 1980s and early 1990s?",
            "Mikhail Gorbachev",
            "Leonid Brezhnev",
            "Nikita Khrushchev",
            "Joseph Stalin",
            1
        ))

        historyQuestions.add(QuestionsView(
            359,
            "Which ancient civilization is known for the Hanging Gardens?",
            "Babylonians",
            "Assyrians",
            "Sumerians",
            "Persians",
            1
        ))

        historyQuestions.add(QuestionsView(
            360,
            "What famous speech did Martin Luther King Jr. deliver in 1963?",
            "I Have a Dream",
            "Letter from Birmingham Jail",
            "Beyond Vietnam",
            "Mountaintop",
            1
        ))

        historyQuestions.add(QuestionsView(
            361,
            "In which year did the United States declare its independence from Great Britain?",
            "1776",
            "1789",
            "1812",
            "1607",
            1
        ))

        historyQuestions.add(QuestionsView(
            362,
            "Who was the first human to orbit the Earth?",
            "Yuri Gagarin",
            "Neil Armstrong",
            "Buzz Aldrin",
            "John Glenn",
            1
        ))

        historyQuestions.add(QuestionsView(
            363,
            "What event is known as the 'Trail of Tears'?",
            "Forced relocation of Native Americans",
            "California Gold Rush",
            "Oregon Trail",
            "Lewis and Clark Expedition",
            1
        ))

        historyQuestions.add(QuestionsView(
            364,
            "Which ancient civilization built the city of Petra?",
            "Nabataeans",
            "Persians",
            "Assyrians",
            "Sumerians",
            1
        ))

        historyQuestions.add(QuestionsView(
            365,
            "Who was the first President of the United States to be impeached?",
            "Andrew Johnson",
            "Bill Clinton",
            "Richard Nixon",
            "Donald Trump",
            1
        ))

        historyQuestions.add(QuestionsView(
            366,
            "What was the name of the ship that carried the Pilgrims to America in 1620?",
            "Mayflower",
            "Santa Maria",
            "Endeavour",
            "Nina",
            1
        ))

        historyQuestions.add(QuestionsView(
            367,
            "Who was the famous nurse during the Crimean War, known for her work in nursing and sanitation?",
            "Florence Nightingale",
            "Clara Barton",
            "Mary Seacole",
            "Dorothea Dix",
            1
        ))

        historyQuestions.add(QuestionsView(
            368,
            "What was the primary cause of the Opium Wars between China and Britain?",
            "Opium trade",
            "Silk trade",
            "Tea trade",
            "Spice trade",
            1
        ))

        historyQuestions.add(QuestionsView(
            369,
            "Who was the first President of the United States?",
            "George Washington",
            "John Adams",
            "Thomas Jefferson",
            "James Madison",
            1
        ))

        historyQuestions.add(QuestionsView(
            370,
            "What was the name of the ship that carried the Pilgrims to America in 1620?",
            "Mayflower",
            "Santa Maria",
            "Endeavour",
            "Nina",
            1
        ))

        historyQuestions.add(QuestionsView(
            371,
            "Which battle is considered the turning point of the Pacific Theater in World War II?",
            "Battle of Midway",
            "Battle of Guadalcanal",
            "Battle of Iwo Jima",
            "Battle of Okinawa",
            1
        ))

        historyQuestions.add(QuestionsView(
            372,
            "Who was the famous admiral of the Byzantine Empire during the 7th century?",
            "Leo III the Isaurian",
            "Basil II",
            "Heraclius",
            "Belisarius",
            1
        ))

        historyQuestions.add(QuestionsView(
            373,
            "What ancient civilization is known for its terracotta army?",
            "Qin Dynasty (China)",
            "Mesoamerica",
            "Ancient Greeks",
            "Persians",
            1
        ))

        historyQuestions.add(QuestionsView(
            374,
            "In which century did the Black Death (Bubonic Plague) occur in Europe?",
            "14th century",
            "15th century",
            "13th century",
            "16th century",
            1
        ))

        historyQuestions.add(QuestionsView(
            375,
            "Who was the first woman to win a Nobel Prize?",
            "Marie Curie",
            "Rosa Parks",
            "Amelia Earhart",
            "Queen Victoria",
            1
        ))

        historyQuestions.add(QuestionsView(
            376,
            "What event is known as the 'Boston Tea Party'?",
            "Protest against British taxation",
            "Tea trade agreement",
            "Tea appreciation ceremony",
            "Tea plantation riot",
            1
        ))

        historyQuestions.add(QuestionsView(
            377,
            "Who was the founder of the Roman Empire?",
            "Augustus (Octavian)",
            "Julius Caesar",
            "Mark Antony",
            "Constantine the Great",
            1
        ))

        historyQuestions.add(QuestionsView(
            378,
            "In which year did the U.S. enter World War I?",
            "1917",
            "1914",
            "1919",
            "1920",
            1
        ))

        historyQuestions.add(QuestionsView(
            379,
            "Which ancient civilization is known for the Code of Hammurabi?",
            "Babylonians",
            "Sumerians",
            "Assyrians",
            "Persians",
            1
        ))

        historyQuestions.add(QuestionsView(
            380,
            "Who was the famous queen of ancient Egypt known for her alliances with Julius Caesar and Mark Antony?",
            "Cleopatra VII",
            "Nefertiti",
            "Hatshepsut",
            "Isis",
            1
        ))

        historyQuestions.add(QuestionsView(
            381,
            "What event marked the end of the Napoleonic Wars?",
            "Battle of Waterloo",
            "Battle of Leipzig",
            "Battle of Austerlitz",
            "Battle of Borodino",
            1
        ))

        historyQuestions.add(QuestionsView(
            382,
            "Which famous document begins with the words 'When in the Course of human events...'?",
            "Declaration of Independence",
            "U.S. Constitution",
            "Magna Carta",
            "Bill of Rights",
            1
        ))

        historyQuestions.add(QuestionsView(
            383,
            "Who was the leader of the Soviet Union during the Cuban Missile Crisis?",
            "Nikita Khrushchev",
            "Joseph Stalin",
            "Leon Trotsky",
            "Vladimir Lenin",
            1
        ))

        historyQuestions.add(QuestionsView(
            384,
            "In which year did the Renaissance begin?",
            "14th century",
            "15th century",
            "16th century",
            "17th century",
            1
        ))

        historyQuestions.add(QuestionsView(
            385,
            "Who was the famous nurse during the Crimean War, known for her work in nursing and sanitation?",
            "Florence Nightingale",
            "Clara Barton",
            "Mary Seacole",
            "Dorothea Dix",
            1
        ))

        historyQuestions.add(QuestionsView(
            386,
            "What was the primary cause of the Irish Potato Famine in the 19th century?",
            "Potato blight",
            "Drought",
            "Economic collapse",
            "British colonization",
            1
        ))

        historyQuestions.add(QuestionsView(
            387,
            "Who was the first woman to win a Nobel Prize?",
            "Marie Curie",
            "Rosa Parks",
            "Amelia Earhart",
            "Queen Victoria",
            1
        ))

        historyQuestions.add(QuestionsView(
            388,
            "In which year did the Berlin Wall fall, symbolizing the end of the Cold War?",
            "1989",
            "1991",
            "1985",
            "1993",
            1
        ))

        historyQuestions.add(QuestionsView(
            389,
            "What ancient civilization built the city of Machu Picchu?",
            "Inca Empire",
            "Aztec Empire",
            "Mayan Civilization",
            "Roman Empire",
            1
        ))

        historyQuestions.add(QuestionsView(
            390,
            "Who was the famous pirate and privateer known for attacking Spanish ships during the Elizabethan era?",
            "Sir Francis Drake",
            "Blackbeard",
            "Captain Kidd",
            "Anne Bonny",
            1
        ))

        historyQuestions.add(QuestionsView(
            391,
            "Which battle is considered the turning point of the American Civil War?",
            "Battle of Gettysburg",
            "Battle of Antietam",
            "Battle of Bull Run",
            "Battle of Shiloh",
            1
        ))

        historyQuestions.add(QuestionsView(
            392,
            "In which century did the Black Death (Bubonic Plague) occur in Europe?",
            "14th century",
            "15th century",
            "13th century",
            "16th century",
            1
        ))

        historyQuestions.add(QuestionsView(
            393,
            "Who was the last pharaoh of ancient Egypt?",
            "Cleopatra VII",
            "Hatshepsut",
            "Ramesses II",
            "Akhenaten",
            1
        ))

        historyQuestions.add(QuestionsView(
            394,
            "What was the name of the ship that carried the Pilgrims to America in 1620?",
            "Mayflower",
            "Santa Maria",
            "Endeavour",
            "Nina",
            1
        ))

        historyQuestions.add(QuestionsView(
            395,
            "Who was the famous ruler of the Mali Empire known for his wealth and pilgrimage to Mecca?",
            "Mansa Musa",
            "Sundiata Keita",
            "Askia the Great",
            "Sunni Ali",
            1
        ))

        historyQuestions.add(QuestionsView(
            396,
            "What event is known as the 'Trail of Tears'?",
            "Forced relocation of Native Americans",
            "California Gold Rush",
            "Oregon Trail",
            "Lewis and Clark Expedition",
            1
        ))

        historyQuestions.add(QuestionsView(
            397,
            "Which ancient wonder was located in Ephesus?",
            "The Temple of Artemis",
            "The Lighthouse of Alexandria",
            "The Colossus of Rhodes",
            "The Great Pyramid of Giza",
            1
        ))

        historyQuestions.add(QuestionsView(
            398,
            "Who was the architect of the Parthenon in Athens?",
            "Iktinos and Kallikrates",
            "Phidias",
            "Pericles",
            "Pythagoras",
            1
        ))

        historyQuestions.add(QuestionsView(
            399,
            "What event marked the end of the Hundred Years' War between England and France?",
            "Battle of Castillon",
            "Battle of Agincourt",
            "Battle of Orleans",
            "Treaty of Paris",
            1
        ))

        historyQuestions.add(QuestionsView(
            400,
            "Who was the famous queen of ancient Carthage known for her role in the Second Punic War?",
            "Dido",
            "Cleopatra",
            "Boudica",
            "Hatshepsut",
            1
        ))

        return historyQuestions
    }

    private fun createScienceQuestions(): ArrayList<QuestionsView> {
        val scienceQuestions = ArrayList<QuestionsView>()

        scienceQuestions.add(QuestionsView(
            401,
            "What is the chemical symbol for water?",
            "H2O",
            "CO2",
            "O2",
            "NaCl",
            1
        ))

        scienceQuestions.add(QuestionsView(
            402,
            "Which planet is known as the 'Red Planet'?",
            "Mars",
            "Venus",
            "Jupiter",
            "Saturn",
            1
        ))

        scienceQuestions.add(QuestionsView(
            403,
            "What is the smallest unit of matter?",
            "Atom",
            "Molecule",
            "Cell",
            "Nucleus",
            1
        ))

        scienceQuestions.add(QuestionsView(
            404,
            "What is the powerhouse of the cell?",
            "Mitochondria",
            "Nucleus",
            "Endoplasmic Reticulum",
            "Golgi Apparatus",
            1
        ))

        scienceQuestions.add(QuestionsView(
            405,
            "What gas do plants absorb during photosynthesis?",
            "Carbon Dioxide (CO2)",
            "Oxygen (O2)",
            "Nitrogen (N2)",
            "Hydrogen (H2)",
            1
        ))

        scienceQuestions.add(QuestionsView(
            406,
            "Which element has the chemical symbol 'O'?",
            "Oxygen",
            "Osmium",
            "Ozone",
            "Oganesson",
            1
        ))

        scienceQuestions.add(QuestionsView(
            407,
            "What is the largest planet in our solar system?",
            "Jupiter",
            "Saturn",
            "Neptune",
            "Uranus",
            1
        ))

        scienceQuestions.add(QuestionsView(
            408,
            "What is the process by which plants make their own food?",
            "Photosynthesis",
            "Respiration",
            "Transpiration",
            "Fermentation",
            1
        ))

        scienceQuestions.add(QuestionsView(
            409,
            "Which gas do humans exhale when they breathe?",
            "Carbon Dioxide (CO2)",
            "Oxygen (O2)",
            "Nitrogen (N2)",
            "Hydrogen (H2)",
            1
        ))

        scienceQuestions.add(QuestionsView(
            410,
            "What is the chemical symbol for gold?",
            "Au",
            "Ag",
            "Fe",
            "Cu",
            1
        ))

        scienceQuestions.add(QuestionsView(
            411,
            "What is the force that pulls objects toward the center of the Earth?",
            "Gravity",
            "Magnetism",
            "Friction",
            "Tension",
            1
        ))

        scienceQuestions.add(QuestionsView(
            412,
            "What is the largest organ in the human body?",
            "Skin",
            "Liver",
            "Heart",
            "Brain",
            1
        ))

        scienceQuestions.add(QuestionsView(
            413,
            "What is the chemical symbol for table salt?",
            "NaCl",
            "H2O",
            "CO2",
            "O2",
            1
        ))

        scienceQuestions.add(QuestionsView(
            414,
            "What is the speed of light?",
            "299,792 kilometers per second",
            "150,000 kilometers per second",
            "450,000 kilometers per second",
            "600,000 kilometers per second",
            1
        ))

        scienceQuestions.add(QuestionsView(
            415,
            "What is the Earth's primary source of energy for the water cycle?",
            "Sun",
            "Moon",
            "Stars",
            "Planets",
            1
        ))

        scienceQuestions.add(QuestionsView(
            416,
            "Which gas makes up the majority of the Earth's atmosphere?",
            "Nitrogen (N2)",
            "Oxygen (O2)",
            "Carbon Dioxide (CO2)",
            "Argon (Ar)",
            1
        ))

        scienceQuestions.add(QuestionsView(
            417,
            "What is the process by which plants lose water through small pores?",
            "Transpiration",
            "Photosynthesis",
            "Respiration",
            "Evaporation",
            1
        ))

        scienceQuestions.add(QuestionsView(
            418,
            "What is the largest organ inside the human body?",
            "Liver",
            "Heart",
            "Lung",
            "Stomach",
            1
        ))

        scienceQuestions.add(QuestionsView(
            419,
            "What is the chemical symbol for hydrogen?",
            "H",
            "He",
            "O",
            "N",
            1
        ))

        scienceQuestions.add(QuestionsView(
            420,
            "What is the chemical formula for methane?",
            "CH4",
            "CO2",
            "H2O",
            "O2",
            1
        ))

        scienceQuestions.add(QuestionsView(
            421,
            "What is the main function of red blood cells in the human body?",
            "Transport oxygen",
            "Digest food",
            "Produce hormones",
            "Fight infections",
            1
        ))

        scienceQuestions.add(QuestionsView(
            422,
            "What is the chemical symbol for iron?",
            "Fe",
            "Au",
            "Ag",
            "Cu",
            1
        ))

        scienceQuestions.add(QuestionsView(
            423,
            "What is the primary function of the kidneys in the human body?",
            "Filter and excrete waste",
            "Digest food",
            "Produce insulin",
            "Pump blood",
            1
        ))

        scienceQuestions.add(QuestionsView(
            424,
            "What is the process by which an organism develops from a fertilized egg?",
            "Embryogenesis",
            "Metamorphosis",
            "Osmosis",
            "Mitosis",
            1
        ))

        scienceQuestions.add(QuestionsView(
            425,
            "Which gas do plants release during photosynthesis?",
            "Oxygen (O2)",
            "Carbon Dioxide (CO2)",
            "Nitrogen (N2)",
            "Methane (CH4)",
            1
        ))

        scienceQuestions.add(QuestionsView(
            426,
            "What is the chemical symbol for silver?",
            "Ag",
            "Au",
            "Cu",
            "Fe",
            1
        ))

        scienceQuestions.add(QuestionsView(
            427,
            "Which gas is responsible for the Earth's greenhouse effect?",
            "Carbon Dioxide (CO2)",
            "Oxygen (O2)",
            "Methane (CH4)",
            "Nitrogen (N2)",
            1
        ))

        scienceQuestions.add(QuestionsView(
            428,
            "What is the largest planet in our solar system?",
            "Jupiter",
            "Saturn",
            "Neptune",
            "Uranus",
            1
        ))

        scienceQuestions.add(QuestionsView(
            429,
            "What is the chemical symbol for helium?",
            "He",
            "H",
            "O",
            "N",
            1
        ))

        scienceQuestions.add(QuestionsView(
            430,
            "What is the process by which plants convert light energy into chemical energy?",
            "Photosynthesis",
            "Respiration",
            "Transpiration",
            "Fermentation",
            1
        ))

        scienceQuestions.add(QuestionsView(
            431,
            "Which layer of the Earth's atmosphere protects us from harmful solar radiation?",
            "Ozone layer",
            "Stratosphere",
            "Troposphere",
            "Mesosphere",
            1
        ))

        scienceQuestions.add(QuestionsView(
            432,
            "What is the chemical formula for water?",
            "H2O",
            "CO2",
            "O2",
            "NaCl",
            1
        ))

        scienceQuestions.add(QuestionsView(
            433,
            "Which subatomic particles are found in the nucleus of an atom?",
            "Protons and neutrons",
            "Protons and electrons",
            "Neutrons and electrons",
            "Quarks",
            1
        ))

        scienceQuestions.add(QuestionsView(
            434,
            "What is the SI unit of electric current?",
            "Ampere",
            "Volt",
            "Watt",
            "Ohm",
            1
        ))

        scienceQuestions.add(QuestionsView(
            435,
            "What is the main function of white blood cells in the human body?",
            "Fight infections",
            "Transport oxygen",
            "Digest food",
            "Produce hormones",
            1
        ))

        scienceQuestions.add(QuestionsView(
            436,
            "Which planet is known as the 'Morning Star' or 'Evening Star'?",
            "Venus",
            "Mars",
            "Jupiter",
            "Saturn",
            1
        ))

        scienceQuestions.add(QuestionsView(
            437,
            "What is the chemical symbol for carbon?",
            "C",
            "Ca",
            "Co",
            "Cr",
            1
        ))

        scienceQuestions.add(QuestionsView(
            438,
            "What is the main component of Earth's atmosphere?",
            "Nitrogen (N2)",
            "Oxygen (O2)",
            "Carbon Dioxide (CO2)",
            "Argon (Ar)",
            1
        ))

        scienceQuestions.add(QuestionsView(
            439,
            "What is the chemical symbol for sodium?",
            "Na",
            "Ni",
            "Ne",
            "Nb",
            1
        ))

        scienceQuestions.add(QuestionsView(
            440,
            "Which force opposes the motion of objects through a fluid (liquid or gas)?",
            "Drag",
            "Gravity",
            "Friction",
            "Tension",
            1
        ))

        scienceQuestions.add(QuestionsView(
            441,
            "What is the chemical symbol for nitrogen?",
            "N2",
            "Na",
            "Ni",
            "Ne",
            1
        ))

        scienceQuestions.add(QuestionsView(
            442,
            "Which type of electromagnetic radiation has the shortest wavelength?",
            "Gamma rays",
            "X-rays",
            "Ultraviolet rays",
            "Infrared rays",
            1
        ))

        scienceQuestions.add(QuestionsView(
            443,
            "What is the process by which plants take in water through their roots?",
            "Absorption",
            "Transpiration",
            "Photosynthesis",
            "Respiration",
            1
        ))

        scienceQuestions.add(QuestionsView(
            444,
            "What is the chemical symbol for potassium?",
            "K",
            "Kr",
            "Cl",
            "P",
            1
        ))

        scienceQuestions.add(QuestionsView(
            445,
            "Which gas makes up the majority of the Sun?",
            "Hydrogen (H2)",
            "Helium (He)",
            "Oxygen (O2)",
            "Carbon Dioxide (CO2)",
            1
        ))

        scienceQuestions.add(QuestionsView(
            446,
            "What is the chemical formula for ammonia?",
            "NH3",
            "CO2",
            "O2",
            "H2O",
            1
        ))

        scienceQuestions.add(QuestionsView(
            447,
            "What is the SI unit of temperature?",
            "Kelvin (K)",
            "Celsius (°C)",
            "Fahrenheit (°F)",
            "Rankine (R)",
            1
        ))

        scienceQuestions.add(QuestionsView(
            448,
            "Which part of the human quizlogo is responsible for controlling balance and coordination?",
            "Cerebellum",
            "Cerebrum",
            "Brainstem",
            "Hippocampus",
            1
        ))

        scienceQuestions.add(QuestionsView(
            449,
            "What is the chemical symbol for iron oxide, a compound commonly known as rust?",
            "Fe2O3",
            "FeO",
            "FeCl2",
            "FeS2",
            1
        ))

        scienceQuestions.add(QuestionsView(
            450,
            "What is the process by which an organism develops from a fertilized egg?",
            "Embryogenesis",
            "Metamorphosis",
            "Osmosis",
            "Mitosis",
            1
        ))

        scienceQuestions.add(QuestionsView(
            451,
            "What is the chemical symbol for phosphorus?",
            "P",
            "Ph",
            "Po",
            "Pt",
            1
        ))

        scienceQuestions.add(QuestionsView(
            452,
            "Which gas is produced as a result of the process of cellular respiration in living organisms?",
            "Carbon Dioxide (CO2)",
            "Oxygen (O2)",
            "Methane (CH4)",
            "Nitrogen (N2)",
            1
        ))

        scienceQuestions.add(QuestionsView(
            453,
            "What is the chemical formula for hydrogen peroxide?",
            "H2O2",
            "CO2",
            "O2",
            "H2O",
            1
        ))

        scienceQuestions.add(QuestionsView(
            454,
            "What is the main function of the respiratory system in the human body?",
            "Exchange of gases",
            "Pumping blood",
            "Digestion",
            "Filtering waste",
            1
        ))

        scienceQuestions.add(QuestionsView(
            455,
            "What is the chemical symbol for neon?",
            "Ne",
            "Na",
            "Ni",
            "Nb",
            1
        ))

        scienceQuestions.add(QuestionsView(
            456,
            "Which metal is the best conductor of electricity?",
            "Silver",
            "Copper",
            "Gold",
            "Aluminum",
            1
        ))

        scienceQuestions.add(QuestionsView(
            457,
            "What is the chemical formula for sulfuric acid?",
            "H2SO4",
            "HCl",
            "NaOH",
            "CH4",
            1
        ))

        scienceQuestions.add(QuestionsView(
            458,
            "In the context of physics, what does the term 'acceleration' refer to?",
            "Rate of change of velocity",
            "Force applied to an object",
            "Potential energy",
            "Resistance to motion",
            1
        ))

        scienceQuestions.add(QuestionsView(
            459,
            "What is the chemical symbol for titanium?",
            "Ti",
            "T",
            "Ta",
            "Te",
            1
        ))

        scienceQuestions.add(QuestionsView(
            460,
            "What is the process by which plants convert nitrates into nitrogen gas?",
            "Denitrification",
            "Nitrogen fixation",
            "Ammonification",
            "Nitrification",
            1
        ))

        scienceQuestions.add(QuestionsView(
            461,
            "Which planet is known as the 'Blue Planet'?",
            "Earth",
            "Neptune",
            "Uranus",
            "Mars",
            1
        ))

        scienceQuestions.add(QuestionsView(
            462,
            "What is the chemical symbol for lead?",
            "Pb",
            "Li",
            "Pt",
            "Fe",
            1
        ))

        scienceQuestions.add(QuestionsView(
            463,
            "What is the main function of the enzyme amylase in the digestive system?",
            "Break down starch into sugars",
            "Break down proteins into amino acids",
            "Break down fats into fatty acids",
            "Absorb nutrients",
            1
        ))

        scienceQuestions.add(QuestionsView(
            464,
            "Which gas is responsible for the Earth's protective ozone layer?",
            "Ozone (O3)",
            "Oxygen (O2)",
            "Methane (CH4)",
            "Nitrous oxide (N2O)",
            1
        ))

        scienceQuestions.add(QuestionsView(
            465,
            "What is the chemical formula for glucose?",
            "C6H12O6",
            "H2O",
            "CO2",
            "O2",
            1
        ))

        scienceQuestions.add(QuestionsView(
            466,
            "What is the SI unit of pressure?",
            "Pascal (Pa)",
            "Newton (N)",
            "Joule (J)",
            "Watt (W)",
            1
        ))

        scienceQuestions.add(QuestionsView(
            467,
            "Which planet is known as the 'Ringed Planet'?",
            "Saturn",
            "Jupiter",
            "Uranus",
            "Neptune",
            1
        ))

        scienceQuestions.add(QuestionsView(
            468,
            "What is the process by which an unstable atomic nucleus loses energy by emitting radiation?",
            "Radioactive decay",
            "Nuclear fission",
            "Nuclear fusion",
            "Electromagnetic radiation",
            1
        ))

        scienceQuestions.add(QuestionsView(
            469,
            "What is the chemical symbol for barium?",
            "Ba",
            "Br",
            "Bi",
            "B",
            1
        ))

        scienceQuestions.add(QuestionsView(
            470,
            "In genetics, what is the term for the complete set of genes or genetic material present in a cell or organism?",
            "Genome",
            "Chromosome",
            "Gene",
            "Nucleotide",
            1
        ))

        scienceQuestions.add(QuestionsView(
            471,
            "What is the chemical symbol for radium?",
            "Ra",
            "Rn",
            "Re",
            "Rh",
            1
        ))

        scienceQuestions.add(QuestionsView(
            472,
            "Which gas is commonly known as laughing gas?",
            "Nitrous oxide (N2O)",
            "Carbon dioxide (CO2)",
            "Oxygen (O2)",
            "Methane (CH4)",
            1
        ))

        scienceQuestions.add(QuestionsView(
            473,
            "What is the chemical symbol for mercury?",
            "Hg",
            "Mg",
            "Ma",
            "Me",
            1
        ))

        scienceQuestions.add(QuestionsView(
            474,
            "What is the SI unit of frequency?",
            "Hertz (Hz)",
            "Watt (W)",
            "Newton (N)",
            "Joule (J)",
            1
        ))

        scienceQuestions.add(QuestionsView(
            475,
            "What is the chemical formula for rust?",
            "Fe2O3",
            "FeO",
            "FeCl2",
            "FeS2",
            1
        ))

        scienceQuestions.add(QuestionsView(
            476,
            "What is the chemical symbol for silver iodide, commonly used in cloud seeding?",
            "AgI",
            "SiO2",
            "AI",
            "Ni",
            1
        ))

        scienceQuestions.add(QuestionsView(
            477,
            "Which planet is known as the 'Red Planet'?",
            "Mars",
            "Venus",
            "Jupiter",
            "Saturn",
            1
        ))

        scienceQuestions.add(QuestionsView(
            478,
            "What is the process by which plants release water vapor through small pores on their leaves?",
            "Transpiration",
            "Photosynthesis",
            "Respiration",
            "Evaporation",
            1
        ))

        scienceQuestions.add(QuestionsView(
            479,
            "What is the chemical formula for methane?",
            "CH4",
            "CO2",
            "H2O",
            "O2",
            1
        ))

        scienceQuestions.add(QuestionsView(
            480,
            "What is the main function of the pancreas in the human body?",
            "Regulate blood sugar levels",
            "Produce insulin",
            "Digest food",
            "Filter blood",
            1
        ))

        scienceQuestions.add(QuestionsView(
            481,
            "What is the chemical symbol for iodine?",
            "I",
            "Id",
            "Io",
            "In",
            1
        ))

        scienceQuestions.add(QuestionsView(
            482,
            "In physics, what does the term 'refraction' refer to?",
            "Bending of light",
            "Reflection of light",
            "Scattering of light",
            "Diffraction of light",
            1
        ))

        scienceQuestions.add(QuestionsView(
            483,
            "What is the chemical symbol for copper?",
            "Cu",
            "Co",
            "Ca",
            "Cr",
            1
        ))

        scienceQuestions.add(QuestionsView(
            484,
            "What is the process by which an organism changes its form or structure during its life cycle?",
            "Metamorphosis",
            "Mitosis",
            "Meiosis",
            "Migration",
            1
        ))

        scienceQuestions.add(QuestionsView(
            485,
            "Which gas is responsible for the unique color of the Earth's sky?",
            "Nitrogen (N2)",
            "Oxygen (O2)",
            "Carbon Dioxide (CO2)",
            "Argon (Ar)",
            1
        ))

        scienceQuestions.add(QuestionsView(
            486,
            "What is the chemical symbol for calcium?",
            "Ca",
            "Cu",
            "Cd",
            "C",
            1
        ))

        scienceQuestions.add(QuestionsView(
            487,
            "What is the main function of the large intestine in the digestive system?",
            "Absorb water and salts",
            "Digest proteins",
            "Produce bile",
            "Absorb nutrients",
            1
        ))

        scienceQuestions.add(QuestionsView(
            488,
            "What is the chemical formula for acetic acid, the main component of vinegar?",
            "CH3COOH",
            "HCl",
            "NaOH",
            "H2SO4",
            1
        ))

        scienceQuestions.add(QuestionsView(
            489,
            "Which subatomic particle carries a negative electric charge?",
            "Electron",
            "Proton",
            "Neutron",
            "Positron",
            1
        ))

        scienceQuestions.add(QuestionsView(
            490,
            "What is the SI unit of electric charge?",
            "Coulomb (C)",
            "Volt (V)",
            "Ampere (A)",
            "Ohm (Ω)",
            1
        ))

        scienceQuestions.add(QuestionsView(
            491,
            "Which gas is produced during the process of cellular respiration in cells?",
            "Carbon Dioxide (CO2)",
            "Oxygen (O2)",
            "Methane (CH4)",
            "Nitrogen (N2)",
            1
        ))

        scienceQuestions.add(QuestionsView(
            492,
            "What is the chemical symbol for antimony?",
            "Sb",
            "As",
            "Al",
            "Ar",
            1
        ))

        scienceQuestions.add(QuestionsView(
            493,
            "In astronomy, what is a 'light year'?",
            "The distance light travels in one year",
            "The time it takes for a star to shine",
            "The brightness of a star",
            "The mass of a star",
            1
        ))

        scienceQuestions.add(QuestionsView(
            494,
            "What is the chemical formula for table sugar (sucrose)?",
            "C12H22O11",
            "H2O",
            "CO2",
            "O2",
            1
        ))

        scienceQuestions.add(QuestionsView(
            495,
            "Which gas is the most abundant in Earth's atmosphere?",
            "Nitrogen (N2)",
            "Oxygen (O2)",
            "Carbon Dioxide (CO2)",
            "Argon (Ar)",
            1
        ))

        scienceQuestions.add(QuestionsView(
            496,
            "What is the main function of the gallbladder in the human body?",
            "Store and release bile",
            "Produce insulin",
            "Digest proteins",
            "Absorb nutrients",
            1
        ))

        scienceQuestions.add(QuestionsView(
            497,
            "What is the chemical symbol for sulfur?",
            "S",
            "Su",
            "So",
            "Sl",
            1
        ))

        scienceQuestions.add(QuestionsView(
            498,
            "Which gas is commonly known as 'laughing gas'?",
            "Nitrous oxide (N2O)",
            "Carbon Dioxide (CO2)",
            "Oxygen (O2)",
            "Methane (CH4)",
            1
        ))

        scienceQuestions.add(QuestionsView(
            499,
            "What is the process by which an organism converts light energy into chemical energy?",
            "Photosynthesis",
            "Respiration",
            "Transpiration",
            "Fermentation",
            1
        ))

        scienceQuestions.add(QuestionsView(
            500,
            "What is the chemical symbol for tin?",
            "Sn",
            "Ti",
            "T",
            "Te",
            1
        ))

        return scienceQuestions
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