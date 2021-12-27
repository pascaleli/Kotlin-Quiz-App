package com.example.quizapp

import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.Color.parseColor
import android.graphics.Typeface
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import org.w3c.dom.Text
import kotlin.math.log


class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {


    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>?= null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswer: Int = 0
    private var mUserName: String? = null





    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUserName = intent.getStringExtra(Constants.USERNAME)

        val tvOption1 = findViewById<TextView>(R.id.tv_option_one)
        val tvOption2 = findViewById<TextView>(R.id.tv_option_two)
        val tvOption3 = findViewById<TextView>(R.id.tv_option_three)
        val tvOption4 = findViewById<TextView>(R.id.tv_option_four)
        val btnSubmit = findViewById<Button>(R.id.submit_button)

        mQuestionList = Constants.getQuestions()
        setQuestion()

        tvOption1.setOnClickListener(this)
        tvOption2.setOnClickListener(this)
        tvOption3.setOnClickListener(this)
        tvOption4.setOnClickListener(this)
        btnSubmit.setOnClickListener(this)



    }
    private fun setQuestion(){
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val ivImage = findViewById<ImageView>(R.id.iv_image)
        val tvProgress = findViewById<TextView>(R.id.tv_progress)
        val tvQuestion = findViewById<TextView>(R.id.tv_question)
        val tvOption1 = findViewById<TextView>(R.id.tv_option_one)
        val tvOption2 = findViewById<TextView>(R.id.tv_option_two)
        val tvOption3 = findViewById<TextView>(R.id.tv_option_three)
        val tvOption4 = findViewById<TextView>(R.id.tv_option_four)
        val btnSubmit = findViewById<Button>(R.id.submit_button)



        Log.i("Question size","${mQuestionList!!.size}")
        val question: Question? = mQuestionList!![mCurrentPosition - 1]

        defaultOptionsView()

        if (mCurrentPosition == mQuestionList!!.size){btnSubmit.text = "FINISH"}else{btnSubmit.text = "SUBMIT"}
        progressBar.progress = mCurrentPosition
        tvProgress.text = "$mCurrentPosition" + "/" + progressBar.max

        tvQuestion.text = question!!.question
        ivImage.setImageResource(question.image)
        tvOption1.text = question!!.optionOne
        tvOption2.text = question!!.optionTwo
        tvOption3.text = question!!.optionThree
        tvOption4.text = question!!.optionFour
    }

    private fun defaultOptionsView(){
        val tvOption1 = findViewById<TextView>(R.id.tv_option_one)
        val tvOption2 = findViewById<TextView>(R.id.tv_option_two)
        val tvOption3 = findViewById<TextView>(R.id.tv_option_three)
        val tvOption4 = findViewById<TextView>(R.id.tv_option_four)


       val options = ArrayList<TextView>()

        options.add(0,tvOption1)
        options.add(1,tvOption2)
        options.add(2,tvOption3)
        options.add(3,tvOption4)

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
        }
    }

    override fun onClick(v: View?) {
        val tvOption1 = findViewById<TextView>(R.id.tv_option_one)
        val tvOption2 = findViewById<TextView>(R.id.tv_option_two)
        val tvOption3 = findViewById<TextView>(R.id.tv_option_three)
        val tvOption4 = findViewById<TextView>(R.id.tv_option_four)
        val btnSubmit = findViewById<Button>(R.id.submit_button)

        when(v?.id){


            R.id.tv_option_one ->{ selectedOptionView(tvOption1,1)}
            R.id.tv_option_two ->{selectedOptionView(tvOption2,2)}
            R.id.tv_option_three ->{selectedOptionView(tvOption3,3)}
            R.id.tv_option_four->{selectedOptionView(tvOption4,4)}
            R.id.submit_button ->{
                if (mSelectedOptionPosition == 0){ mCurrentPosition++

                    when{
                        mCurrentPosition <=mQuestionList!!.size ->{setQuestion()}else -> {
                        //Toast.makeText(this, "You have successfully completed the text", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this,ResultActivity::class.java)
                                intent.putExtra(Constants.USERNAME, mUserName)
                                intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswer)
                                intent.putExtra(Constants.Total_Questions,mQuestionList!!.size)
                                startActivity(intent)
                                finish()
                        }
                    }
                }else{
                    val question= mQuestionList?.get(mCurrentPosition - 1)
                    if (question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }else{mCorrectAnswer++}
                    answerView(question!!.correctAnswer, R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mQuestionList!!.size){btnSubmit.text = "FINISHED"}else{btnSubmit.text = "GO TO NEXT QUESTION"}

                    mSelectedOptionPosition =0
                }

            }

        }

    }

    private fun answerView(answer: Int,drawableView: Int){
        val tvOption1 = findViewById<TextView>(R.id.tv_option_one)
        val tvOption2 = findViewById<TextView>(R.id.tv_option_two)
        val tvOption3 = findViewById<TextView>(R.id.tv_option_three)
        val tvOption4 = findViewById<TextView>(R.id.tv_option_four)

        when (answer)
        {
            1 -> tvOption1.background = ContextCompat.getDrawable(this,drawableView)
            2 -> tvOption2.background = ContextCompat.getDrawable(this, drawableView)
            3 -> tvOption3.background = ContextCompat.getDrawable(this, drawableView)
            4 -> tvOption4.background = ContextCompat.getDrawable(this, drawableView)
        }


    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int){
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,R.drawable.selected_option_border_bg)

    }

}