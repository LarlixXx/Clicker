package com.larix.katyakitka

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.larix.katyakitka.SharedPreferencesManager.*




open class MainActivity : AppCompatActivity() {
    lateinit var textCountClicks: TextView
    lateinit var textClicksForClick: TextView
    lateinit var manager: SharedPreferencesManager
    companion object {
        var countClicks = 0
        var changeClicksForClick = 1
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initGeo()
        initPhone()
        initLink()


        val imgCat = findViewById<ImageButton>(R.id.cat_img)
        textCountClicks = findViewById(R.id.clicks_count_main_text)
        val toUpgradeButton = findViewById<Button>(R.id.button_click_upg)
        textClicksForClick = findViewById(R.id.clicks_for_clicks_text)


        imgCat.setOnClickListener {
            countClicks += changeClicksForClick

            textCountClicks.text = Upgrades.countClicksOnBalance(resources)
            textClicksForClick.text = Upgrades.countClicksForClicks(resources)

            saveClicksCount(clicksCount_key, changeClicksForClick)

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

    override fun onPause() {
        super.onPause()

    }

}