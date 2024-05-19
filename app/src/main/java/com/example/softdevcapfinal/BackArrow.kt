package com.example.softdevcapfinal

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun BackArrow( onClick: () -> Unit, color: Color ) {
    Image(
        painter = painterResource(id = R.drawable.back_arrow),
        contentDescription = "Back arrow",
        colorFilter = ColorFilter.tint(color),
        modifier = Modifier
            .size(64.dp, 64.dp)
            .clickable { onClick() }
    )
}