package com.example.softdevcapfinal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ToolsFolderScreen(themeColorManager: ThemeColorManager, navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(themeColorManager.backgroundColor)
    ){
        Column(
            Modifier.fillMaxWidth()
        ) {
            BackArrow (onClick = { navController.navigate(Screen.MainScreen.route) }, color = themeColorManager.themeLogoColor)
            Column(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 32.dp)
            ) {
                Row (
                    horizontalArrangement = Arrangement.spacedBy(48.dp),
                ){
                    GameLogo(
                        name = "Calculator",
                        onClick = { navController.navigate(Screen.CalculatorScreen.route) },
                        logo = painterResource(id = R.drawable.calculator),
                        logoColor = themeColorManager.folderColor,
                        textColor = themeColorManager.folderTextColor
                    )

                    GameLogo(
                        name = "Notepad",
                        onClick = { navController.navigate(Screen.NotepadScreen.route) },
                        logo = painterResource(id = R.drawable.notepad),
                        logoColor = themeColorManager.folderColor,
                        textColor = themeColorManager.folderTextColor
                    )
                }
            }
        }
    }
}