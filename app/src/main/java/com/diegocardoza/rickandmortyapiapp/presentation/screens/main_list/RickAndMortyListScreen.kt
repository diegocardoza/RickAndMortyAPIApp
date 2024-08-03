package com.diegocardoza.rickandmortyapiapp.presentation.screens.main_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import com.diegocardoza.rickandmortyapiapp.presentation.model.CharacterModel

@Composable
fun RickAndMortyListScreen(
    modifier: Modifier = Modifier,
    rickAndMortyListViewModel: RickAndMortyListViewModel = hiltViewModel()
) {
    val characters = rickAndMortyListViewModel.characters.collectAsLazyPagingItems()
    CharacterList(modifier, characters)
}

@Composable
fun CharacterList(
    modifier: Modifier,
    characters: LazyPagingItems<CharacterModel>
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(characters.itemCount) {
            characters[it]?.let { characterModel ->
                CharacterItem(characterModel)
            }
        }
    }
}

@Composable
fun CharacterItem(characterModel: CharacterModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(12.dp))
            .height(150.dp)
            .background(Color.Black)
    ) {
        AsyncImage(
            model = characterModel.image,
            contentDescription = "character image",
            modifier = Modifier
                .weight(1f),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .background(Color(0xFF3D3C3C))
                .padding(12.dp)
                .weight(1.5f),
            verticalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = characterModel.name,
                    color = Color.White,
                    fontWeight = FontWeight.Black,
                    fontSize = 20.sp,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val dotColor = if (characterModel.isAlive) Color.Green else Color.Red
                    val isAliveText = if (characterModel.isAlive) "Alive" else "Dead"
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .clip(CircleShape)
                            .background(color = dotColor)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "$isAliveText - ${characterModel.specie}",
                        color = Color.White,
                        fontSize = 13.sp,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )
                }
            }
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Last known location:",
                    color = Color(0xFFBDBBBB),
                    fontSize = 14.sp,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = characterModel.lastKnownLocation,
                    color = Color.White,
                    fontSize = 16.sp,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCharacterItem() {
    CharacterItem(
        characterModel = CharacterModel(
            1,
            "Rick Sanchez",
            true,
            "Human",
            "Citadel of Ricks",
            ""
        )
    )
}
