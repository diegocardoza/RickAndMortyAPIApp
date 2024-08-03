package com.diegocardoza.rickandmortyapiapp.data.response

import com.diegocardoza.rickandmortyapiapp.presentation.model.CharacterModel
import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("status") val status: String,
    @SerializedName("species") val species: String,
    @SerializedName("location") val location: LocationResponse,
    @SerializedName("image") val image: String
) {
    fun toPresentation(): CharacterModel =
        CharacterModel(
            id = id,
            name = name,
            isAlive = status == "Alive",
            specie = species,
            lastKnownLocation = location.name,
            image = image
        )
}
