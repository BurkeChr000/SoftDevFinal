package com.example.softdevcapfinal

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val themeColorManager = remember { ThemeColorManager() }

    NavHost(navController = navController, startDestination = Screen.MainScreen.route){
        composable(Screen.MainScreen.route){
            MainScreen(themeColorManager, navController)
        }
        composable(Screen.SettingsFolderScreen.route){
            SettingsFolderScreen(themeColorManager, navController)
        }
        composable(Screen.GamesFolderScreen.route){
            GamesFolderScreen(themeColorManager,navController)
        }
        composable(Screen.RockPaperScissorsScreen.route){
            RockPaperScissorsScreen(themeColorManager, navController)
        }
        composable(Screen.ToolsFolderScreen.route){
            ToolsFolderScreen(themeColorManager, navController)
        }
        composable(Screen.NotepadScreen.route){
            NotepadScreen(themeColorManager, navController)
        }
        composable(Screen.CalculatorScreen.route){
            CalculatorScreen(themeColorManager, navController)
        }
        composable(Screen.TicTacToeScreen.route){
            TicTacToeScreen(themeColorManager, navController)
        }
    }
}