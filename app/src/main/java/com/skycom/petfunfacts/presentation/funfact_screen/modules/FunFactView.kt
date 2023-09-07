package com.skycom.petfunfacts.presentation.funfact_screen.modules

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.skycom.petfunfacts.presentation.funfact_screen.FunFactViewModel

class FunFactView {
    companion object {
        @Composable
        fun FunFactView(viewModel: FunFactViewModel){

            val imageData by viewModel.imageData.collectAsState(null)
            val factData by viewModel.funFact.collectAsState("")

            LaunchedEffect(Unit) {
                viewModel.fetchRandomCatImage()
                viewModel.fetchRandomCatFact()
            }

            Surface(
                modifier = Modifier
                    .padding(16.dp)) {
                Card(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.surface),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Column(
                        Modifier.fillMaxWidth()
                            .padding(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        if (imageData == null || factData.isEmpty()) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(50.dp)
                                    .align(Alignment.CenterHorizontally)
                            )
                        } else {
                            FunPicture.FunPic(imageData = imageData)
                            FunFact.FunFact(fact = factData)
                        }
                    }
                }
            }
        }
    }
}