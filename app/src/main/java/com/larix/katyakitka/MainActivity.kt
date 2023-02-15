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

        val imgCat = findViewById<ImageButton>(R.id.cat_img)
        textCountClicks = findViewById(R.id.clicks_count_main_text)
        val toUpgradeButton = findViewById<Button>(R.id.button_upgrade)
        textClicksForClick = findViewById(R.id.clicks_for_clicks_text)

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
        val geolocationButton = findViewById<Button>(R.id.my_office_button)
        geolocationButton.setOnClickListener {
            val geoIntent = Intent(Intent.ACTION_VIEW)
            geoIntent.data = Uri.parse("geo:55.754283,37.62002")
            startActivity(geoIntent)
        }
    }

    private fun initLink() {
        val siteButton = findViewById<Button>(R.id.my_vk_button)
        siteButton.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://vk.com/iknowallaboutyouu")))
        }
    }

    private fun initPhone() {
        val numberButton = findViewById<Button>(R.id.my_phone_number_button)
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