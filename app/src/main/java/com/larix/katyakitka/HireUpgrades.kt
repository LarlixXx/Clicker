package com.larix.katyakitka

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.larix.katyakitka.Upgrades.Companion.countClicksOnBalance

class HireUpgrades : AppCompatActivity() {
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

            clicksCount.text = countClicksOnBalance(resources)
        }
        upgr2.setOnClickListener {

            clicksCount.text = countClicksOnBalance(resources)
        }
        upgr3.setOnClickListener {

            clicksCount.text = countClicksOnBalance(resources)
        }
        upgr4.setOnClickListener {

            clicksCount.text = countClicksOnBalance(resources)
        }
        upgr5.setOnClickListener {

            clicksCount.text = countClicksOnBalance(resources)
        }
        upgr6.setOnClickListener {

            clicksCount.text = countClicksOnBalance(resources)
        }
        upgr7.setOnClickListener {

            clicksCount.text = countClicksOnBalance(resources)
        }

        returnButton.setOnClickListener {
            onBackPressed()
        }
    }
}