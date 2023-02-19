package com.larix.katyakitka

import android.app.Activity
import android.content.SharedPreferences
import android.content.res.Resources
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.larix.katyakitka.MainActivity.Companion.changeClicksForClick


import com.larix.katyakitka.MainActivity.Companion.countClicks

class Upgrades : AppCompatActivity() {

    private val clicksCount_key: String = "clicksCount"
    private val clicksForClick_key: String = "clickForClick"
    private val myClicks_key: String = "myClicks"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.upg)

        val sharPref: SharedPreferences = getSharedPreferences(myClicks_key, Activity.MODE_PRIVATE)
        val editor = sharPref.edit()

        val clicksSaved: Int = sharPref.getInt(clicksCount_key, 0)
        val clicksChangeSaved: Int = sharPref.getInt(clicksForClick_key, 1)

        val upgr1 = findViewById<Button>(R.id.upg1_button)
        val upgr2 = findViewById<Button>(R.id.upg2_button)
        val upgr3 = findViewById<Button>(R.id.upg3_button)
        val upgr4 = findViewById<Button>(R.id.upg4_button)
        val upgr5 = findViewById<Button>(R.id.upg5_button)
        val upgr6 = findViewById<Button>(R.id.upg6_button)
        val upgr7 = findViewById<Button>(R.id.upg7_button)
        val returnButton = findViewById<Button>(R.id.back_to_main_button)
        val clicksCount = findViewById<TextView>(R.id.clicks_count_upg_text)

        clicksCount.text = countClicksOnBalance(resources)

        fun saveClicks() {
            editor.putInt(clicksCount_key, countClicks)
            editor.putInt(clicksForClick_key, changeClicksForClick)
            editor.apply()
        }

        upgr1.setOnClickListener {
            upgradeFun(25, 1)
            clicksCount.text = countClicksOnBalance(resources)
            saveClicks()
        }
        upgr2.setOnClickListener {
            upgradeFun(100, 3)
            clicksCount.text = countClicksOnBalance(resources)
            saveClicks()
        }
        upgr3.setOnClickListener {
            upgradeFun(500, 10)
            clicksCount.text = countClicksOnBalance(resources)
            saveClicks()
        }
        upgr4.setOnClickListener {
            upgradeFun(1500, 30)
            clicksCount.text = countClicksOnBalance(resources)
            saveClicks()
        }
        upgr5.setOnClickListener {
            upgradeFun(2500, 50)
            clicksCount.text = countClicksOnBalance(resources)
            saveClicks()
        }
        upgr6.setOnClickListener {
            upgradeFun(4000, 150)
            clicksCount.text = countClicksOnBalance(resources)
            saveClicks()
        }
        upgr7.setOnClickListener {
            upgradeFun(20000, 500)
            clicksCount.text = countClicksOnBalance(resources)
            saveClicks()
        }

        returnButton.setOnClickListener {
            onBackPressed()
        }
    }

    companion object {
        fun countClicksOnBalance(resources: Resources): String {
            return resources.getString(
                R.string.clicks_on_balance,
                resources.getQuantityString(
                    R.plurals.clicks,
                    countClicks,
                    countClicks
                )
            )
        }

        fun countClicksForClicks(resources: Resources): String {
            return resources.getString(
                R.string.clicks_for_click,
                resources.getQuantityString(
                    R.plurals.clicks,
                    changeClicksForClick,
                    changeClicksForClick
                )
            )
        }
    }

    private fun upgradeFun(summ: Int, izm: Int) {
        if (countClicks >= summ) {
            changeClicksForClick += izm
            countClicks -= summ
        }
    }
}