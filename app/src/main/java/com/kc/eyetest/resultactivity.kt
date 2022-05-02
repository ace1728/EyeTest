package com.kc.eyetest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_question.*
import kotlinx.android.synthetic.main.activity_resultactivity.*

class resultactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultactivity)

        val username=intent.getStringExtra(Constants.USER_NAME)
        tv_name.text=username
        val total=intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correct=intent.getIntExtra(Constants.CORRECT_ANSWERS,0)
        tv_score.text="Your score is $correct out of $total"
        btn_finish.setOnClickListener{
            startActivity(Intent(this,getLocation::class.java))
            finish()
        }

    }
}