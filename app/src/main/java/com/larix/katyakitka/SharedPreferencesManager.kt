package com.larix.katyakitka

import android.content.Context
import android.content.SharedPreferences

open class SharedPreferencesManager(context: Context) {

    val clicksCount_key: String = "clicksCount"
    val clicksForClick_key: String = "clickForClick"
    val myClicks_key: String = "myClicks"


    val sharPreff: SharedPreferences = context.getSharedPreferences(myClicks_key, 0)
    val editor = sharPreff.edit()

    var clicksSaved: Int = sharPreff.getInt(clicksCount_key, 0)
    var clicksChangeSaved: Int = sharPreff.getInt(clicksForClick_key, 1)

    fun saveClicksCount(_key: String, value: Int) {
        editor.putInt(_key, value).apply()
    }

    fun saveClicksForClick(_key: String, value: Int) {
        editor.putInt(_key, value).apply()
    }

}