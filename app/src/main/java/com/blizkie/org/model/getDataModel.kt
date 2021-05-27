package com.blizkie.org.model

import android.content.Context
import com.google.gson.Gson
import java.io.IOException

class getDataModel {

    /**
     * Получаем JSON из папки assets и конвертируем в объект
     */
    fun getJsonData(context: Context): JsonParty? {

        val jsonToString: String
        val mJsonParty: JsonParty

        try {
            jsonToString = context.assets.open("jsonParty.json").bufferedReader().use {it.readText()}
            mJsonParty = Gson().fromJson<JsonParty>(jsonToString, JsonParty::class.java)
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return mJsonParty
    }
}