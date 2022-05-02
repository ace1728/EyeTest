package com.kc.eyetest

object Constants{
    const val USER_NAME:String ="user_name"
    const val TOTAL_QUESTIONS:String="total_question"
    const val CORRECT_ANSWERS:String="correct_answers"

    fun getQuestions(): ArrayList<Question>{
        val questionsList =ArrayList<Question>()
        val que1=Question(
            1,
            "Indicate the direction of the Alphabet ?",
            R.drawable.a1,
            " ↑ ",
            "↓",
            "→",
            "←",
            4
            )
        questionsList.add(que1)
        // 2
        val que2 = Question(
            2,
            "Indicate the direction of the Alphabet ?",
            R.drawable.a2,
            " ↑ ",
            "↓",
            "→",
            "←",
            3
        )

        questionsList.add(que2)

        // 3
        val que3 = Question(
            3,
            "Indicate the direction of the Alphabet ?",
            R.drawable.a3,
            " ↑ ",
            "↓",
            "→",
            "←",
            1
        )

        questionsList.add(que3)

        // 4
        val que4 = Question(
            4,
            "Indicate the direction of the Alphabet ?",
            R.drawable.a4,
            " ↑ ",
            "↓",
            "→",
            "←",
            3
        )

        questionsList.add(que4)

        // 5
        val que5 = Question(
            5, "Indicate the direction of the Alphabet ?",
            R.drawable.a5,
            " ↑ ",
            "↓",
            "→",
            "←",
            2
        )

        questionsList.add(que5)

        // 6
        val que6 = Question(
            6, "Indicate the direction of the Alphabet ?",
            R.drawable.a6,
            " ↑ ",
            "↓",
            "→",
            "←",
            3
        )

        questionsList.add(que6)

        // 7
        val que7 = Question(
            7, "Indicate the direction of the Alphabet ?",
            R.drawable.a7,
            " ↑ ",
            "↓",
            "→",
            "←",
            2
        )

        questionsList.add(que7)

        // 8
        val que8 = Question(
            8, "Indicate the direction of the Alphabet ?",
            R.drawable.a8,
            " ↑ ",
            "↓",
            "→",
            "←",
            4
        )

        questionsList.add(que8)

        // 9
        val que9 = Question(
            9, "Indicate the direction of the Alphabet ?",
            R.drawable.a9,
            " ↑ ",
            "↓",
            "→",
            "←",
            1
        )

        questionsList.add(que9)

        // 10
        val que10 = Question(
            10, "Indicate the direction of the Alphabet ?",
            R.drawable.a10,
            " ↑ ",
            "↓",
            "→",
            "←",
            3
        )

        questionsList.add(que10)




        return questionsList
    }

}