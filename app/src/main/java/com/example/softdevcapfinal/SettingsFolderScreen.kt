package com.example.softdevcapfinal

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun SettingsFolderScreen(themeColorManager: ThemeColorManager, navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(themeColorManager.backgroundColor)
    ){
        Column(
            Modifier.fillMaxWidth()
        ) {
            BackArrow (onClick = { navController.navigate(Screen.MainScreen.route) }, color = themeColorManager.themeLogoColor)
            Image(
                painter = painterResource(id = themeColorManager.themeLogo),
                contentDescription = "light/dark theme toggle",
                colorFilter = ColorFilter.tint(themeColorManager.themeLogoColor),
                modifier = Modifier
                    .size(450.dp, 450.dp)
                    .padding(top = 128.dp)
                    .clickable {
                        themeColorManager.updateTheme(!themeColorManager.darkTheme)
                    }
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}