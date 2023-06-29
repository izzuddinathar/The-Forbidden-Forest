package com.example.visualnovelproject.util

import com.google.gson.annotations.SerializedName

data class ScenarioResponse(

    @field:SerializedName("scenario")
    val scenario: List<ScenarioItem>
)

data class ScenarioItem(

    @field:SerializedName("question")
    val question: String,

    @field:SerializedName("background")
    val background: String,

    @field:SerializedName("page")
    val page: Int,

    @field:SerializedName("choice")
    val choice: List<ChoiceItem>,

    @field:SerializedName("model")
    val model: String? = null,

    @field:SerializedName("hint")
    val hint: String? = null
)

data class ChoiceItem(

    @field:SerializedName("pageNext")
    val pageNext: Int,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("index")
    val index: Int
)
