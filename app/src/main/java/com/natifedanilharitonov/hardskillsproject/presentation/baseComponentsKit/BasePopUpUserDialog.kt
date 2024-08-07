package com.natifedanilharitonov.hardskillsproject.presentation.baseComponentsKit

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasePopUpUserDialog(
    modifier: Modifier = Modifier,
    state: Boolean,
    text: String,
    buttonText: String,
    onConfirm: () -> Unit,
) {
    if (state) {
        BasicAlertDialog(
            onDismissRequest = onConfirm,
            modifier = modifier,
        ) {
            Box(
                modifier =
                    Modifier
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(20.dp),
                        ).border(
                            color = Color.DarkGray,
                            width = 1.dp,
                            shape = RoundedCornerShape(20.dp),
                        ).padding(20.dp),
                contentAlignment = Alignment.Center,
            ) {
                Column {
                    Text(text = text)
                    Spacer(modifier = Modifier.padding(10.dp))
                    Button(
                        modifier = Modifier.testTag("Button tag"),
                        onClick = onConfirm,
                        colors =
                            ButtonDefaults.buttonColors(
                                containerColor = Color.DarkGray,
                            ),
                    ) {
                        Text(text = buttonText)
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewPopUp() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        BasePopUpUserDialog(
            modifier = Modifier.padding(30.dp),
            state = true,
            text = "Pop up here",
            buttonText = "Ok",
            onConfirm = {},
        )
    }
}
