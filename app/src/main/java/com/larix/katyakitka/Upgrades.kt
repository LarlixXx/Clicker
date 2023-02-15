package com.larix.katyakitka

import android.content.res.Resources
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.larix.katyakitka.MainActivity.Companion.ckicksChange
import com.larix.katyakitka.MainActivity.Companion.countClicks

class Upgrades : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.upg)

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

        upgr1.setOnClickListener {
            upgradeFun(25, 1)
            clicksCount.text = countClicksOnBalance(resources)
        }
        upgr2.setOnClickListener {
            upgradeFun(100, 3)
            clicksCount.text = countClicksOnBalance(resources)
        }
        upgr3.setOnClickListener {
            upgradeFun(500, 10)
            clicksCount.text = countClicksOnBalance(resources)
        }
        upgr4.setOnClickListener {
            upgradeFun(1500, 30)
            clicksCount.text = countClicksOnBalance(resources)
        }
        upgr5.setOnClickListener {
            upgradeFun(2500, 50)
            clicksCount.text = countClicksOnBalance(resources)
        }
        upgr6.setOnClickListener {
            upgradeFun(4000, 150)
            clicksCount.text = countClicksOnBalance(resources)
        }
        upgr7.setOnClickListener {
            upgradeFun(20000, 500)
            clicksCount.text = countClicksOnBalance(resources)
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
                    ckicksChange,
                    ckicksChange
                )
            )
        }
    }

    private fun upgradeFun(summ: Int, izm: Int) {
        if (countClicks >= summ) {
            ckicksChange += izm
            countClicks -= summ
        }
    }
}