package com.diegocardoza.rickandmortyapiapp.presentation.model

data class CharacterModel(
    val id: Int,
    val name: String,
    val isAlive: Boolean,
    val specie: String,
    val lastKnownLocation: String,
    val image: String
)
