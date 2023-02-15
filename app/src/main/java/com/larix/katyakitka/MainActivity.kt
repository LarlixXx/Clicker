package com.larix.katyakitka

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var textCountClicks: TextView
    lateinit var textClicksForClick: TextView

    companion object {
        var countClicks = 0
        var ckicksChange = 1
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initGeo()
        initPhone()
        initLink()

        val imgCat = findViewById<ImageButton>(R.id.kitka)
        textCountClicks = findViewById(R.id.text)
        val toUpgradeButton = findViewById<Button>(R.id.b1)
        textClicksForClick = findViewById(R.id.textmini)



        val sharPref = getSharedPreferences("mynum", Activity.MODE_PRIVATE)
        val editor = sharPref.edit()
        val clicksSaved: Int = sharPref.getInt("kol_vo", 0)
        val clicksChangeSaved: Int = sharPref.getInt("za_raz", 1)
        countClicks = clicksSaved
        ckicksChange = clicksChangeSaved

        imgCat.setOnClickListener {
            countClicks += ckicksChange
            textCountClicks.text = Upgrades.countClicksOnBalance(resources)
            textClicksForClick.text = Upgrades.countClicksForClicks(resources)

            editor.putInt("clicksCountSaved", countClicks)
            editor.putInt("clicksForClickSaved", ckicksChange)
            editor.apply()

        }
        toUpgradeButton.setOnClickListener {
            val upgradeIntent = Intent(this, Upgrades::class.java)
            startActivity(upgradeIntent)
        }
    }

    private fun initGeo() {
        val geolocationButton = findViewById<Button>(R.id.bot2)
        geolocationButton.setOnClickListener {
            val geoIntent = Intent(Intent.ACTION_VIEW)
            geoIntent.data = Uri.parse("geo:55.754283,37.62002")
            startActivity(geoIntent)
        }
    }
    private fun initLink() {
        val siteButton = findViewById<Button>(R.id.bot1)
        siteButton.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://vk.com/iknowallaboutyouu")))
        }
    }

    private fun initPhone() {
        val numberButton = findViewById<Button>(R.id.bot3)
        numberButton.setOnClickListener {
            val phoneIntent = Intent(Intent.ACTION_DIAL)
            phoneIntent.data = Uri.parse("tel:89872618801")
            startActivity(phoneIntent)
        }

    }

    override fun onResume() {
        super.onResume()
        textCountClicks.text = Upgrades.countClicksOnBalance(resources)
        textClicksForClick.text = Upgrades.countClicksForClicks(resources)
    }
}