package com.larix.katyakitka

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.larix.katyakitka.MainActivity.Companion.countClicks
import com.larix.katyakitka.MainActivity.Companion.ckicksChange
class Upgrades : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.upg)

        val upgr1 = findViewById<Button>(R.id.but1)
        val upgr2 = findViewById<Button>(R.id.but2)
        val upgr3 = findViewById<Button>(R.id.but3)
        val upgr4 = findViewById<Button>(R.id.but4)
        val upgr5 = findViewById<Button>(R.id.but5)
        val upgr6 = findViewById<Button>(R.id.but6)
        val upgr7 = findViewById<Button>(R.id.but7)
        val returnButton = findViewById<Button>(R.id.back)
        val clicksCount = findViewById<TextView>(R.id.zmakup)

        clicksCount.text = countClicksOnBalance(resources)

        upgr1.setOnClickListener {
            upgradeFun(25,1)
            clicksCount.text = countClicksOnBalance(resources)
        }
        upgr2.setOnClickListener {
            upgradeFun(100,3)
            clicksCount.text = countClicksOnBalance(resources)
        }
        upgr3.setOnClickListener {
            upgradeFun(500,10)
            clicksCount.text = countClicksOnBalance(resources)
        }
        upgr4.setOnClickListener {
            upgradeFun(1500,30)
            clicksCount.text = countClicksOnBalance(resources)
        }
        upgr5.setOnClickListener {
            upgradeFun(2500,50)
            clicksCount.text = countClicksOnBalance(resources)
        }
        upgr6.setOnClickListener {
            upgradeFun(4000,150)
            clicksCount.text = countClicksOnBalance(resources)
        }
        upgr7.setOnClickListener {
            upgradeFun(20000,500)
            clicksCount.text = countClicksOnBalance(resources)
        }

        returnButton.setOnClickListener{
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