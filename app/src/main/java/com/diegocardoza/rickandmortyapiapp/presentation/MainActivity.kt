package com.diegocardoza.rickandmortyapiapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.diegocardoza.rickandmortyapiapp.presentation.components.TopBar
import com.diegocardoza.rickandmortyapiapp.presentation.screens.main_list.RickAndMortyListScreen
import com.diegocardoza.rickandmortyapiapp.presentation.ui.theme.RickAndMortyAPIAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RickAndMortyAPIAppTheme(
                darkTheme = true
            ) {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize(),
                    topBar = {
                        CenterAlignedTopAppBar(title = {
                            TopBar()
                        })
                    }
                ) {
                    RickAndMortyListScreen(
                        modifier = Modifier.padding(it)
                    )
                }
            }
        }
    }
}