package com.diegocardoza.rickandmortyapiapp.data.response

import com.google.gson.annotations.SerializedName

data class LocationResponse(
    @SerializedName("name") val name: String
)
