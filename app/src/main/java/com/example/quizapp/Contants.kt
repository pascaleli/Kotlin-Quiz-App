package com.example.quizapp

object Constants{

    const val USERNAME: String= "user_name"
    const val Total_Questions: String = "total_question"
    const val CORRECT_ANSWERS: String = "Correct_Answer"
    fun getQuestions(): ArrayList<Question>{


        val questionList = ArrayList<Question>()


        val que1 = Question(1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Kuwait",
            "Brazil",
        "India",
            1)

        questionList.add(que1)

        val que2 = Question(1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Argentina",
            "Australia",
            "Brazil",
            "India",
            2)

        questionList.add(que2)

        val que3 = Question(1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Argentina",
            "Australia",
            "Belgium",
            "India",
            3)

        questionList.add(que3)

        val que4 = Question(1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Argentina",
            "Australia",
            "Brazil",
            "India",
            3)

        questionList.add(que4)

        val que5 = Question(1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Argentina",
            "Australia",
            "Brazil",
            "Fifi",
            4)

        questionList.add(que5)



        val que6 = Question(1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Denmark",
            "Australia",
            "Brazil",
            "India",
            1)

        questionList.add(que6)

        val que7 = Question(1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Denmark",
            "Australia",
            "Brazil",
            "Germany",
            4)

        questionList.add(que7)

        val que8 = Question(1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Denmark",
            "Australia",
            "Brazil",
            "India",
            4)

        questionList.add(que8)

        val que9 = Question(1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Denmark",
            "Australia",
            "Brazil",
            "New_zealand",
            4)

        questionList.add(que9)
        return questionList
    }

}