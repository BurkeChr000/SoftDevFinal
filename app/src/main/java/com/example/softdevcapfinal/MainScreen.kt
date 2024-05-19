package com.example.softdevcapfinal


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
@Composable
fun MainScreen(themeColorManager: ThemeColorManager, navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(themeColorManager.backgroundColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.TopCenter)
        ) {
            SearchField(
                searchFieldColor = themeColorManager.searchFieldColor,
                onClick = {query ->
                    when(query.lowercase()) {
                        "settings" -> navController.navigate(Screen.SettingsFolderScreen.route)
                        "games" -> navController.navigate(Screen.GamesFolderScreen.route)
                        "rockpaperscissors" -> navController.navigate(Screen.RockPaperScissorsScreen.route)
                        "tools" -> navController.navigate(Screen.ToolsFolderScreen.route)
                        "tictactoe" -> navController.navigate(Screen.TicTacToeScreen.route)
                        "calculator" -> navController.navigate(Screen.CalculatorScreen.route)
                        "notepad" -> navController.navigate(Screen.NotepadScreen.route)
                    }
                }
                )
            Column(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Row (
                    horizontalArrangement = Arrangement.spacedBy(48.dp),
                ){
                    Folder(name = "Games", onClick = {navController.navigate(Screen.GamesFolderScreen.route)}, folderColor = themeColorManager.folderColor, textColor = themeColorManager.folderTextColor)
                    Folder(name = "Tools", onClick = {navController.navigate(Screen.ToolsFolderScreen.route)}, folderColor = themeColorManager.folderColor, textColor = themeColorManager.folderTextColor)
                }
                Row (
                    horizontalArrangement = Arrangement.spacedBy(48.dp),
                ){
                    Folder(name = "Settings", onClick = {navController.navigate(Screen.SettingsFolderScreen.route)},folderColor = themeColorManager.folderColor, textColor = themeColorManager.folderTextColor)
                }
            }
        }
    }
}