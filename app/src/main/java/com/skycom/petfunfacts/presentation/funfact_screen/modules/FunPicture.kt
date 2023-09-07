package com.skycom.petfunfacts.presentation.funfact_screen.modules

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp


class FunPicture {

    companion object {
        @Composable
        fun FunPic(imageData: ByteArray?) {
            if (imageData != null) {
                val bitmap =
                    BitmapFactory.decodeByteArray(imageData, 0, imageData.size).asImageBitmap()
                Image (
                    painter = remember { BitmapPainter(bitmap) },
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                )
            } else {
                // Placeholder or error handling
            }
        }
    }
}