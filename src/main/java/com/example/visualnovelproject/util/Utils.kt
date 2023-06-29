package com.example.visualnovelproject.util

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException
import java.util.*

object Utils {
    const val NAME = "name"
    val pages = Stack<Int>()

    init {
        pages.add(1)
    }

    fun getJsonDataFromAsset(context: Context): List<ScenarioItem> {
        val jsonString: String

        return try {
            jsonString = context.assets.open("scenario.json").bufferedReader().use { it.readText() }
            val gson = Gson()
            val listScenario = object : TypeToken<ScenarioResponse>() {}.type

            val scenarioJson: ScenarioResponse = gson.fromJson(jsonString, listScenario)

            scenarioJson.scenario

        } catch (e: IOException) {
            e.printStackTrace()
            emptyList()
        }
    }

    fun pageTracker(context: Context, choiceIndex: Int?): Int {
        val scenario = getJsonDataFromAsset(context)

        val currentPage = pages.lastElement()

        scenario.forEach { scenarioItem ->
            if (currentPage == scenarioItem.page) {
                scenarioItem.choice.forEachIndexed { index, choiceItem ->
                    if (index == choiceIndex) {
                        pages.push(choiceItem.pageNext)
                    }
                }
            }
        }
        return if (pages.empty()) 1 else pages.lastElement()
    }
}