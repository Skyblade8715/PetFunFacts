package com.skycom.petfunfacts.presentation.funfact_screen.modules

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

class FunFact {

    companion object {
        @Composable
        fun FunFact(fact: String?) {
            if (fact != null) {
                Text (
                    text = fact,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(16.dp),
                    textAlign = TextAlign.Center
                )
            } else {
                // Placeholder or error handling
            }
        }
    }
}