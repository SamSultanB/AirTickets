package com.test.search.offers.data.local

import android.content.Context
import com.test.common.utils.Constants

class Preferences(context: Context) {

    private val pref = context.getSharedPreferences(Constants.PREF_NAME, Context.MODE_PRIVATE)

    fun getStart(): String?{
        return pref.getString(Constants.KEY_LAST_DESTINATION, "")
    }

    fun getDestination(): String?{
        return pref.getString(Constants.KEY_DESTINATION, "")
    }

}