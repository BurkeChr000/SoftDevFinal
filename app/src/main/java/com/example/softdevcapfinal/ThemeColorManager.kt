package com.example.softdevcapfinal

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

class ThemeColorManager {
    private val darkBackgroundColor = Color.DarkGray
    private val lightBackgroundColor = Color.LightGray
    private val darkSearchFieldColor = Color.LightGray
    private val lightSearchFieldColor = Color.DarkGray
    private val darkFolderColor = Color.Gray
    private val lightFolderColor = Color.Gray
    private val darkFolderTextColor = Color.White
    private val lightFolderTextColor = Color.Black
    private val darkTextColor = Color.Black
    private val lightTextColor = Color.White
    private val darkThemeLogo = R.drawable.light_theme
    private val lightThemeLogo = R.drawable.dark_theme
    private val darkThemeLogoColor = Color.White
    private val lightThemeLogoColor= Color.Black
    private val darkTttButtonColor = Color(0xFF7b15a3)
    private val lightTttButtonColor = Color(0xFFd569ff)
    private val darkNumberButtonColor = Color(0xFF4f4f4f)
    private val lightNumberButtonColor = Color(0xFF7d7d7d)
    private val darkFunctionButtonColor = Color(0xFF9e9e9e)
    private val lightFunctionButtonColor = Color(0xFF8c8c8c)

    var backgroundColor by mutableStateOf(darkBackgroundColor)
        private set
    var searchFieldColor by mutableStateOf(darkSearchFieldColor)
        private set
    var folderColor by mutableStateOf(darkFolderColor)
        private set
    var folderTextColor by mutableStateOf(darkFolderTextColor)
        private set
    var themeLogo by mutableIntStateOf(darkThemeLogo)
        private set
    var darkTheme by mutableStateOf(true)
        private set
    var themeLogoColor by mutableStateOf(darkThemeLogoColor)
        private set
    var textColor by mutableStateOf(darkTextColor)
        private set
    var tttButtonColor by mutableStateOf(darkTttButtonColor)
        private set
    var numberButtonColor by mutableStateOf(darkNumberButtonColor)
        private set
    var functionButtonColor by mutableStateOf(darkFunctionButtonColor)
        private set

    fun updateTheme(isDarkTheme: Boolean) {
        backgroundColor = if (isDarkTheme) darkBackgroundColor else lightBackgroundColor
        searchFieldColor = if (isDarkTheme) darkSearchFieldColor else lightSearchFieldColor
        folderColor = if (isDarkTheme) darkFolderColor else lightFolderColor
        folderTextColor = if (isDarkTheme) darkFolderTextColor else lightFolderTextColor
        themeLogo = if (isDarkTheme) darkThemeLogo else lightThemeLogo
        darkTheme = (isDarkTheme)
        themeLogoColor = if (isDarkTheme) darkThemeLogoColor else lightThemeLogoColor
        textColor = if (isDarkTheme) darkTextColor else lightTextColor
        tttButtonColor = if (isDarkTheme) darkTttButtonColor else lightTttButtonColor
        numberButtonColor = if (isDarkTheme) darkNumberButtonColor else lightNumberButtonColor
        functionButtonColor = if (isDarkTheme) darkFunctionButtonColor else lightFunctionButtonColor
    }
}