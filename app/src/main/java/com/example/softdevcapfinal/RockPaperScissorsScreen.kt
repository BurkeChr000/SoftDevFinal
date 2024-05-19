package com.example.softdevcapfinal

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlin.random.Random

@Composable
fun RockPaperScissorsScreen(themeColorManager: ThemeColorManager, navController: NavController) {
    var text by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(themeColorManager.backgroundColor)
    ){
        Column (
            Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(24.dp),
        ){
            BackArrow(onClick = { navController.navigate(Screen.GamesFolderScreen.route) }, color = themeColorManager.themeLogoColor)
            Row(Modifier.align(Alignment.CenterHorizontally)){Text(text = text, color = themeColorManager.folderTextColor, fontSize = 32.sp)}
            Image(
                painter = painterResource(id = R.drawable.rock),
                contentDescription = "Rock",
                colorFilter = ColorFilter.tint(themeColorManager.folderColor),
                modifier = Modifier
                    .size(112.dp, 112.dp)
                    .align(Alignment.CenterHorizontally)
                    .clickable {
                        val num = Random.nextInt(1, 4)
                        when(num){
                            1 -> text = "Congrats! You won"
                            2 -> text = "Sorry... You Lost"
                            3 -> text = "Draw: Try again?"
                        }
                    }
            )
            Image(
                painter = painterResource(id = R.drawable.paper),
                contentDescription = "Paper",
                colorFilter = ColorFilter.tint(themeColorManager.folderColor),
                modifier = Modifier
                    .size(112.dp, 112.dp)
                    .align(Alignment.CenterHorizontally)
                    .clickable {
                        val num = Random.nextInt(1, 4)
                        when(num){
                            1 -> text = "Congrats! You won"
                            2 -> text = "Sorry... You Lost"
                            3 -> text = "Draw: Try again?"
                        }
                    }
            )
            Image(
                painter = painterResource(id = R.drawable.scissors),
                contentDescription = "Scissors",
                colorFilter = ColorFilter.tint(themeColorManager.folderColor),
                modifier = Modifier
                    .size(112.dp, 112.dp)
                    .align(Alignment.CenterHorizontally)
                    .clickable {
                        val num = Random.nextInt(1, 4)
                        when(num){
                            1 -> text = "Congrats! You won"
                            2 -> text = "Sorry... You Lost"
                            3 -> text = "Draw: Try again?"
                        }
                    }
            )
        }
    }

}