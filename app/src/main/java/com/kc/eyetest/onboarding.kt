package com.kc.eyetest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_onboarding.*
import java.text.FieldPosition

class onboarding : AppCompatActivity() {

    private lateinit var onboardingItemsAdapter: OnboardingItemsAdapter
    private lateinit var indicatorsContainer:LinearLayout
    private var mUserName:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)
        setOnboardingItems()
        setupIndicators()
        setCurrentIndicator(0)
        mUserName=intent.getStringExtra(Constants.USER_NAME)

        buttonGetStarted.setOnClickListener {
            val intent= Intent(this,QuestionActivity::class.java)
            intent.putExtra(Constants.USER_NAME,mUserName)
            startActivity(intent)
            finish()



        }
        skip.setOnClickListener {
            val intent = Intent(this, QuestionActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun setOnboardingItems() {
        onboardingItemsAdapter = OnboardingItemsAdapter(
            listOf(
                OnboardingItem(
                    onboardingImage = R.drawable.on2,
                    title = "Distance Yourself",
                    description = "Viewed from 50cm, " +
                            "this app helps determine how well you can" +
                            " see letters and shapes."
                ),
                OnboardingItem(
                    onboardingImage = R.drawable.on3,
                    title = "Cover Eye",
                    description = "You'll read out loud the letters you " +
                            "see with your uncovered eye. "
                ),
                OnboardingItem(
                    onboardingImage = R.drawable.on2,
                    title = "Distance Yourself",
                    description = " During the test, " +
                            "you'll sit or stand a specific distance " +
                            "away from the device and cover one eye"
                ),
                OnboardingItem(
                    onboardingImage = R.drawable.on3,
                    title = "Cover Eye",
                    description = " You'll repeat " +
                            "this process with your other eye."
                )
            )

        )
        val onboardingViewPager = findViewById<ViewPager2>(R.id.onboardindViewPager)
        onboardingViewPager.adapter = onboardingItemsAdapter
        onboardingViewPager.registerOnPageChangeCallback(object :
        ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })
        (onboardingViewPager.getChildAt(0) as RecyclerView).overScrollMode=
            RecyclerView.OVER_SCROLL_NEVER

    }

    private fun setupIndicators(){
        indicatorsContainer=findViewById(R.id.indicatorsContainer)
        val indicators= arrayOfNulls<ImageView>(onboardingItemsAdapter.itemCount)
        val layoutParams:LinearLayout.LayoutParams=
            LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        layoutParams.setMargins(8,0,8,0)
        for(i in indicators.indices){
            indicators[i]= ImageView(applicationContext)
            indicators[i]?.let {
                it.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive_background
                    )
                )
                it.layoutParams=layoutParams
                indicatorsContainer.addView(it)
            }
        }
    }
    private fun setCurrentIndicator(position: Int){
        val childCount=indicatorsContainer.childCount
        for(i in 0 until childCount){
            val imageView=indicatorsContainer.getChildAt(i) as ImageView
            if(i==position){
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active_background
                    )
                )
            } else{
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive_background
                    )

                )
            }
        }
    }
}