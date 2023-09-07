package com.skycom.petfunfacts.presentation.main_screen

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.skycom.petfunfacts.presentation.funfact_screen.FunFactScreen
import com.skycom.petfunfacts.ui.theme.PetFunFactsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val i = Intent(this@MainActivity, FunFactScreen::class.java)
        setContent {
            PetFunFactsTheme {

                val buttonsModifier = Modifier
                    .fillMaxWidth(0.8F)
                    .height(80.dp)
                    .padding(bottom = 32.dp)

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 64.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom,
                ) {
                    Button(
                        onClick = {
                            startActivity(i.putExtra("CatFact", true))
                        },
                        modifier = buttonsModifier

                    ) {
                        Text(text = "Cat day..?")
                    }
                    Button(
                        onClick = {
                            startActivity(i.putExtra("CatFact", false))
                        },
                        modifier = buttonsModifier
                    ) {
                        Text(text = "Dog day..?")
                    }
                }
            }
        }
    }
}
