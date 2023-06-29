package com.example.visualnovelproject

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.visualnovelproject.util.ChoiceItem
import com.example.visualnovelproject.util.Utils

class ScenarioViewModel : ViewModel() {
    private var _question = MutableLiveData<String>()
    val question: LiveData<String> = _question

    private var _choices = MutableLiveData<List<ChoiceItem>>()
    val choices: LiveData<List<ChoiceItem>> = _choices

    private var _background = MutableLiveData<Drawable>()
    val background: LiveData<Drawable> = _background

    private var _model = MutableLiveData<Drawable?>()
    val model: LiveData<Drawable?> = _model

    private var _hint = MutableLiveData<String>()
    val hint: LiveData<String> = _hint

    fun flushData() {
        _choices.value = emptyList()
        _model.value = null
        _hint.value = null
        _question.value = null
        _background.value = null
    }

    fun switchPage(context: Context, nextPage: Int) {
        val scenario = Utils.getJsonDataFromAsset(context)

        scenario.forEach { scenarioItem ->
            if (nextPage == scenarioItem.page) {
                val layoutBackground = context.resources.getIdentifier(
                    scenarioItem.background,
                    "drawable",
                    context.packageName
                )
                if (scenarioItem.model != "") {
                    val imageView = context.resources.getIdentifier(
                        scenarioItem.model,
                        "drawable",
                        context.packageName
                    )
                    _model.value = context.getDrawable(imageView)
                }
                _choices.value = scenarioItem.choice
                _question.value = scenarioItem.question
                _background.value = context.getDrawable(layoutBackground)
                _hint.value = scenarioItem.hint
            }
        }
    }
}