package com.example.softdevcapfinal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun CalculatorScreen(themeColorManager: ThemeColorManager, navController : NavController) {
    val buttonSpacing = 8.dp
    val viewModel = viewModel<CalculatorViewModel>()
    val state = viewModel.state
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(themeColorManager.backgroundColor)
    ) {
        BackArrow(
            onClick = { navController.navigate(Screen.ToolsFolderScreen.route) },
            color = themeColorManager.themeLogoColor
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
        ) {
            Row(
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(end = 20.dp)
            ){
                Text(
                    text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                    color = themeColorManager.folderTextColor,
                    fontSize = 48.sp,
                    maxLines = 1
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ) {
                    CalculatorButton(
                        symbol = "AC",
                        buttonColor = themeColorManager.functionButtonColor,
                        textColor = themeColorManager.folderTextColor,
                        buttonType = 2f,
                        onClick = { viewModel.onAction(CalculatorAction.Clear) },
                        modifier = Modifier
                            .weight(2f)
                    )
                    CalculatorButton(
                        symbol = "Del",
                        buttonColor = themeColorManager.functionButtonColor,
                        textColor = themeColorManager.folderTextColor,
                        buttonType = 1f,
                        onClick = { viewModel.onAction(CalculatorAction.Delete) },
                        modifier = Modifier
                            .weight(1f)
                    )
                    CalculatorButton(
                        symbol = "/",
                        buttonColor = themeColorManager.tttButtonColor,
                        textColor = themeColorManager.folderTextColor,
                        buttonType = 1f,
                        onClick = { viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Divide)) },
                        modifier = Modifier
                            .weight(1f)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ) {
                    CalculatorButton(
                        symbol = "7",
                        buttonColor = themeColorManager.numberButtonColor,
                        textColor = themeColorManager.folderTextColor,
                        buttonType = 1f,
                        onClick = { viewModel.onAction(CalculatorAction.Number(7)) },
                        modifier = Modifier
                            .weight(1f)
                    )
                    CalculatorButton(
                        symbol = "8",
                        buttonColor = themeColorManager.numberButtonColor,
                        textColor = themeColorManager.folderTextColor,
                        buttonType = 1f,
                        onClick = { viewModel.onAction(CalculatorAction.Number(8)) },
                        modifier = Modifier
                            .weight(1f)
                    )
                    CalculatorButton(
                        symbol = "9",
                        buttonColor = themeColorManager.numberButtonColor,
                        textColor = themeColorManager.folderTextColor,
                        buttonType = 1f,
                        onClick = { viewModel.onAction(CalculatorAction.Number(9)) },
                        modifier = Modifier
                            .weight(1f)
                    )
                    CalculatorButton(
                        symbol = "x",
                        buttonColor = themeColorManager.tttButtonColor,
                        textColor = themeColorManager.folderTextColor,
                        buttonType = 1f,
                        onClick = { viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Multiply)) },
                        modifier = Modifier
                            .weight(1f)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ) {
                    CalculatorButton(
                        symbol = "4",
                        buttonColor = themeColorManager.numberButtonColor,
                        textColor = themeColorManager.folderTextColor,
                        buttonType = 1f,
                        onClick = { viewModel.onAction(CalculatorAction.Number(4)) },
                        modifier = Modifier
                            .weight(1f)
                    )
                    CalculatorButton(
                        symbol = "5",
                        buttonColor = themeColorManager.numberButtonColor,
                        textColor = themeColorManager.folderTextColor,
                        buttonType = 1f,
                        onClick = { viewModel.onAction(CalculatorAction.Number(5)) },
                        modifier = Modifier
                            .weight(1f)
                    )
                    CalculatorButton(
                        symbol = "6",
                        buttonColor = themeColorManager.numberButtonColor,
                        textColor = themeColorManager.folderTextColor,
                        buttonType = 1f,
                        onClick = { viewModel.onAction(CalculatorAction.Number(6)) },
                        modifier = Modifier
                            .weight(1f)
                    )
                    CalculatorButton(
                        symbol = "-",
                        buttonColor = themeColorManager.tttButtonColor,
                        textColor = themeColorManager.folderTextColor,
                        buttonType = 1f,
                        onClick = { viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Subtract)) },
                        modifier = Modifier
                            .weight(1f)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ) {
                    CalculatorButton(
                        symbol = "1",
                        buttonColor = themeColorManager.numberButtonColor,
                        textColor = themeColorManager.folderTextColor,
                        buttonType = 1f,
                        onClick = { viewModel.onAction(CalculatorAction.Number(1)) },
                        modifier = Modifier
                            .weight(1f)
                    )
                    CalculatorButton(
                        symbol = "2",
                        buttonColor = themeColorManager.numberButtonColor,
                        textColor = themeColorManager.folderTextColor,
                        buttonType = 1f,
                        onClick = { viewModel.onAction(CalculatorAction.Number(2)) },
                        modifier = Modifier
                            .weight(1f)
                    )
                    CalculatorButton(
                        symbol = "3",
                        buttonColor = themeColorManager.numberButtonColor,
                        textColor = themeColorManager.folderTextColor,
                        buttonType = 1f,
                        onClick = { viewModel.onAction(CalculatorAction.Number(3)) },
                        modifier = Modifier
                            .weight(1f)
                    )
                    CalculatorButton(
                        symbol = "+",
                        buttonColor = themeColorManager.tttButtonColor,
                        textColor = themeColorManager.folderTextColor,
                        buttonType = 1f,
                        onClick = { viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Add)) },
                        modifier = Modifier
                            .weight(1f)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ) {
                    CalculatorButton(
                        symbol = "0",
                        buttonColor = themeColorManager.numberButtonColor,
                        textColor = themeColorManager.folderTextColor,
                        buttonType = 2f,
                        onClick = { viewModel.onAction(CalculatorAction.Number(0)) },
                        modifier = Modifier
                            .weight(2f)
                    )
                    CalculatorButton(
                        symbol = ".",
                        buttonColor = themeColorManager.numberButtonColor,
                        textColor = themeColorManager.folderTextColor,
                        buttonType = 1f,
                        onClick = { viewModel.onAction(CalculatorAction.Decimal) },
                        modifier = Modifier
                            .weight(1f)
                    )
                    CalculatorButton(
                        symbol = "=",
                        buttonColor = themeColorManager.tttButtonColor,
                        textColor = themeColorManager.folderTextColor,
                        buttonType = 1f,
                        onClick = { viewModel.onAction(CalculatorAction.Calculate) },
                        modifier = Modifier
                            .weight(1f)
                    )
                }
            }
        }
    }
}