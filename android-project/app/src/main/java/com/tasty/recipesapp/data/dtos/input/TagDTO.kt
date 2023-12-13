package com.tasty.recipesapp.data.dtos.input

import com.google.gson.annotations.SerializedName

data class TagDTO (
    @SerializedName("root_tag_type")
    val rootTagType : String,
    val name : String,
    val id : Int,
    @SerializedName("display_name")
    val displayName : String,
    val type : String
)