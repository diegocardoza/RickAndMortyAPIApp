package com.diegocardoza.rickandmortyapiapp.presentation.screens.main_list

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.diegocardoza.rickandmortyapiapp.data.RickAndMortyRepository
import com.diegocardoza.rickandmortyapiapp.presentation.model.CharacterModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class RickAndMortyListViewModel @Inject constructor(
    rickAndMortyRepository: RickAndMortyRepository
) : ViewModel() {

    val characters: Flow<PagingData<CharacterModel>> = rickAndMortyRepository.getAllCharacters()

}