package com.example.softdevcapfinal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun NotepadScreen(themeColorManager: ThemeColorManager, navController: NavController) {
    var text by remember { mutableStateOf(NotebookText.notebookText)}
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(themeColorManager.backgroundColor)
    ) {
        Column(
            Modifier.fillMaxWidth()
        ) {
            BackArrow(
                onClick = { navController.navigate(Screen.ToolsFolderScreen.route) },
                color = themeColorManager.themeLogoColor
            )
            TextField(
                value = text,
                onValueChange = {
                    NotebookText.notebookText = it
                    text = NotebookText.notebookText
                },
                placeholder = { Text(text = "Type notepad here", color = Color.Gray) },
                textStyle = TextStyle(color = themeColorManager.folderTextColor),
                modifier = Modifier
                    .fillMaxSize(),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = themeColorManager.backgroundColor,
                    focusedContainerColor = themeColorManager.backgroundColor,
                    cursorColor = themeColorManager.folderTextColor
            ),
            )
        }
    }
}