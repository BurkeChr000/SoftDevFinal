package com.example.softdevcapfinal

sealed class Screen(val route: String) {
    data object MainScreen: Screen("mainScreen")
    data object SettingsFolderScreen: Screen("settingsFolderScreen")
    data object GamesFolderScreen: Screen("gamesFolderScreen")
    data object RockPaperScissorsScreen : Screen("rockPaperScissorsScreen")
    data object ToolsFolderScreen : Screen("toolsFolderScreen")
    data object TicTacToeScreen : Screen("ticTacToeScreen")
    data object CalculatorScreen : Screen("calculatorScreen")
    data object NotepadScreen : Screen("notepadScreen")
}