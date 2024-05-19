package com.example.softdevcapfinal

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.PopupProperties

@Composable
fun SearchField(
    searchFieldColor: androidx.compose.ui.graphics.Color,
    onClick: (query: String) -> Unit
    ) {
    var text by remember { mutableStateOf("") }
    var isDropdownExpanded by remember { mutableStateOf(false) }
    val suggestions = listOf("Settings", "Games", "RockPaperScissors", "Tools", "TicTacToe", "Notepad", "Calculator")
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(searchFieldColor),
    ) {
        TextField(
            value = text,
            textStyle = TextStyle(fontSize = 32.sp),
            placeholder = { Text(text = "Search here", fontSize = 32.sp, color = androidx.compose.ui.graphics.Color.Gray) },
            maxLines = 1,
            modifier = Modifier
                .fillMaxWidth()
                .background(searchFieldColor),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = searchFieldColor,
                focusedContainerColor = searchFieldColor,
                cursorColor = androidx.compose.ui.graphics.Color.Black
            ),
            onValueChange = {
                text = it
                isDropdownExpanded = text.isNotEmpty()
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(onSearch = {
                focusManager.clearFocus()
                isDropdownExpanded = false
                onClick(text)
            }),
        )

        DropdownMenu(
            expanded = isDropdownExpanded,
            onDismissRequest = { isDropdownExpanded = false },
            modifier = Modifier.background(searchFieldColor),
            properties = PopupProperties(focusable = false)
        ) {
            suggestions.filter { it.startsWith(text, ignoreCase = true) }.forEach { suggestion ->
                DropdownMenuItem(
                    text = { Text(suggestion) },
                    onClick = {
                        text = suggestion
                        isDropdownExpanded = false
                        keyboardController?.hide()
                        onClick(text)
                    },
                    modifier = Modifier.background(searchFieldColor)
                )
            }
        }
    }
}