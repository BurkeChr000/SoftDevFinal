package com.example.softdevcapfinal

import android.widget.ImageView.ScaleType
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Folder(
    name: String,
    onClick: () -> Unit,
    folderColor: Color,
    textColor: Color
) {
    Column(
        Modifier.clickable{ onClick() }
    ) {
        Image(
            painter = painterResource(id = R.drawable.baseline_folder_24),
            contentDescription = "$name folder",
            colorFilter = ColorFilter.tint(folderColor),
            modifier = Modifier
                .size(112.dp, 112.dp)
                .padding(bottom = 0.dp),
            )
        Text(
            text = name,
            color = textColor,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            modifier = Modifier
                .width(112.dp)
                .padding(top = 0.dp)
        )
    }
}