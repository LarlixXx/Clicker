package com.larix.katyakitka

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import com.larix.katyakitka.MainActivity.Companion.changeClicksForClick
import com.larix.katyakitka.MainActivity.Companion.countClicks

open class SharedPreferencesManager(context: Context) {

    val clicksCount_key: String = "clicksCount"
    val clicksForClick_key: String = "clickForClick"
    val myClicks_key: String = "myClicks"

    val sharPreff: SharedPreferences = context.getSharedPreferences(myClicks_key, 0)
    val editor = sharPreff.edit()


    val clicksSaved: Int = sharPreff.getInt(clicksCount_key, 0)
    val clicksChangeSaved: Int = sharPreff.getInt(clicksForClick_key, 1)

    fun saveClicksCount(key:String,value:Int){
        editor.putInt(key, value)
        editor.apply()
    }
    fun saveClicksForClick(key:String,value: Int){
        editor.putInt(key, value)
        editor.apply()
    }

}