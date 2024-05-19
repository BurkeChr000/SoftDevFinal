package com.example.softdevcapfinal

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun TicTacToeScreen(themeColorManager: ThemeColorManager, navController: NavController) {
    var gameState by remember { mutableStateOf(GameState(
        board = List(3) {List(3) {""} },
        currentPlayer = "X"
    )) }
    var text by remember { mutableStateOf<String?>(null) }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(themeColorManager.backgroundColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            BackArrow(
                onClick = { navController.navigate(Screen.GamesFolderScreen.route) },
                color = themeColorManager.themeLogoColor
            )
            Row(
                modifier = Modifier
                    .height(77.dp)
                    .align(Alignment.CenterHorizontally),
            ){ text?.let { Text(text = it, fontSize = 32.sp, textAlign = TextAlign.Center) } }
            Column(
                modifier = Modifier
                    .padding(top = 24.dp)
                    .align(Alignment.CenterHorizontally),
                verticalArrangement = Arrangement.spacedBy(10.dp)) {
                gameState.board.forEachIndexed { rowIndex, row ->
                    Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        row.forEachIndexed { colIndex, cell ->
                            Box(
                              modifier = Modifier
                                  .size(100.dp)
                                  .background(
                                      themeColorManager.folderColor,
                                      RoundedCornerShape(8.dp)
                                  )
                                  .clickable(enabled = cell.isEmpty() && text == null) {
                                      gameState = gameState.copy(
                                          board = gameState.board.mapIndexed { r, row ->
                                              row.mapIndexed { c, col ->
                                                  if (r == rowIndex && c == colIndex) gameState.currentPlayer else col
                                              }
                                          },
                                          currentPlayer = if (gameState.currentPlayer == "X") "O" else "X"
                                      )
                                      text = checkGame(gameState.board, gameState.currentPlayer)
                                  }
                            ){
                                Box(
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                ){ Text(
                                    text = cell,
                                    fontSize = 64.sp,
                                    color = themeColorManager.textColor
                                )}
                            }
                        }
                    }
                }
            }
            Row(Modifier.align(Alignment.CenterHorizontally)){
                Button(
                    onClick = {
                          gameState = gameState.copy(
                              board = gameState.board.map {row ->
                                  row.map {""}
                              },
                              currentPlayer = "X"
                          )
                        text = null
                    },
                    Modifier.padding(top = 24.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = themeColorManager.tttButtonColor
                    )
                ) {
                    Text(text = "Reset", fontSize = 32.sp)
                }
            }
        }
    }
}

data class GameState(
    val board: List<List<String>>,
    val currentPlayer: String
)

fun checkGame(board : List<List<String>>, currentPlayer: String): String?{
    for(row in board) {
        if (row[0].isNotEmpty() && row.all { it == row[0]}) { return confirmWin(currentPlayer) }
    }
    for (col in 0..2){
        if(board[0][col].isNotEmpty() && board.all { it[col] == board[0][col]}) { return confirmWin(currentPlayer) }
    }
    if (board[0][0].isNotEmpty() && board[1][1] == board[0][0] && board[2][2] == board[0][0]) {  return confirmWin(currentPlayer) }
    if (board[0][2].isNotEmpty() && board[1][1] == board[0][2] && board[2][0] == board[0][2]) { return confirmWin(currentPlayer) }
    if (board[0].all { it.isNotEmpty()} && board[1].all { it.isNotEmpty() } && board[2].all { it.isNotEmpty() }){
        return "This time\n no one wins"
    }
    return null
}

fun confirmWin(currentPlayer: String): String{
    if(currentPlayer == "X") {return "Congrats! Player O\nis the Winner"}
    return "Congrats! Player X\nis the Winner"
}