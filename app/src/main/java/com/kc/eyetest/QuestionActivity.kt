package com.kc.eyetest

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity(),View.OnClickListener {

    private var mCurrentPosition:Int=1
    private var mQuestionList:ArrayList<Question>?=null
    private var mSelectedOptionPosition:Int=0
    private var mCorrectAnswers:Int=0
    private var mUserName:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        mUserName=intent.getStringExtra(Constants.USER_NAME)
        mQuestionList=Constants.getQuestions()
        setQuestion()
        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)
    }
    private fun setQuestion(){
        val question=mQuestionList!!.get(mCurrentPosition-1)
        defaultOptionsView()
        if(mCurrentPosition==mQuestionList!!.size){
            btn_submit.text="FINISH"
        }else{
            btn_submit.text="SUBMIT"

        }
        tv_progress.text = "$mCurrentPosition" + "/" + "10"

        tv_question.text=question!!.question
        iv_image.setImageResource(question.image)
        tv_option_one.text=question.optionOne
        tv_option_two.text=question.optionTwo
        tv_option_three.text=question.optionThree
        tv_option_four.text=question.optionFour
        // tv_option_four.setBackgroundResource(R.drawable.round_button)
    }

    private fun defaultOptionsView(){
        val options=ArrayList<TextView>()
        options.add(0,tv_option_one)
        options.add(1,tv_option_two)
        options.add(2,tv_option_three)
        options.add(3,tv_option_four)
        for (option in options){
            option.setTextColor(Color.parseColor("#B4FEE7"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(this,
                R.drawable.default_option_border_bg)

        }
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.tv_option_one->{
                selectedOptionView(tv_option_one,1)
            }
            R.id.tv_option_two->{
                selectedOptionView(tv_option_two,2)
            }
            R.id.tv_option_three->{
                selectedOptionView(tv_option_three,3)
            }
            R.id.tv_option_four->{
                selectedOptionView(tv_option_four,4)
            }
            R.id.btn_submit->{
                if(mSelectedOptionPosition==0){
                    mCurrentPosition ++

                    when{
                        mCurrentPosition<=mQuestionList!!.size ->{
                            setQuestion()
                        }else ->{
                           val intent=Intent(this,resultactivity::class.java)
                        intent.putExtra(Constants.USER_NAME,mUserName)
                        intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswers)
                        intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionList!!.size)
                        startActivity(intent)
                        finish()

                        }
                    }
                }else{
                    val question=mQuestionList?.get(mCurrentPosition-1)
                    if(question!!.correctAnswer!=mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition,R.drawable.wrong_option_border_bg)
                    }
                    else{
                        answerView(mSelectedOptionPosition,R.drawable.correct_option_border_bg)
                        mCorrectAnswers++

                    }


                    if(mCurrentPosition==mQuestionList!!.size){
                        btn_submit.text="FINISH"
                    }else{
                        btn_submit.text="NEXT QUESTION"
                    }
                    mSelectedOptionPosition=0



                }


            }
        }
    }
    private fun answerView(answer:Int,drawableView:Int){
        when(answer){
            1->{
                tv_option_one.background=ContextCompat.getDrawable(
                    this,drawableView
                )
            }
            2->{
                tv_option_two.background=ContextCompat.getDrawable(
                    this,drawableView
                )
            }
            3->{
                tv_option_three.background=ContextCompat.getDrawable(
                    this,drawableView
                )
            }
            4->{
                tv_option_four.background=ContextCompat.getDrawable(
                    this,drawableView
                )
            }
        }
    }
    private fun selectedOptionView(tv:TextView,
                                   selectedOptionNum:Int){
        defaultOptionsView()
        mSelectedOptionPosition= selectedOptionNum
        tv.setTextColor(Color.parseColor("#000000"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(this,
            R.drawable.select_option_border)
    }
}