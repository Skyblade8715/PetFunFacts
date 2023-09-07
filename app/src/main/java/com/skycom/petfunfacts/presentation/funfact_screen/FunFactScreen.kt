package com.skycom.petfunfacts.presentation.funfact_screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import com.skycom.petfunfacts.presentation.funfact_screen.modules.FunFactView
import com.skycom.petfunfacts.ui.theme.PetFunFactsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FunFactScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PetFunFactsTheme {
                val viewModel = hiltViewModel<FunFactViewModel>()
                FunFactView.FunFactView(viewModel = viewModel)

            }
        }
    }
}