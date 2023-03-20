package com.example.musicwiki.models

import com.google.gson.annotations.SerializedName

//data class RecyclerList (val topTags: ArrayList<RecyclerData1>)
//data class RecyclerData1 (val tag: ArrayList<RecyclerData>)
//data class RecyclerData(val name: String, val count: Int, val reach : Int)


data class TopTagsResponse(
    @SerializedName("toptags")
    val topTags: TopTags
)

data class TopTags(

    @SerializedName("tag")
    val tagName: ArrayList<TagName>
)

data class TagName(
    @SerializedName("name")
    val name: String,
    val count: Int,
    val reach: Int
)
