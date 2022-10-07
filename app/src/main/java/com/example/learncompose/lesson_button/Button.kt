package com.example.learncompose.lesson_button

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learncompose.R
import com.example.learncompose.ui.theme.LearnComposeTheme

class Button : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { 
            LearnComposeTheme() {
                
            }
        }
    }
}

@Composable
private fun CreateSimpleButton() {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Red,
            contentColor = Color.White
        )
    ) {
        Text(text = "Click Here")
    }
}

@Composable
private fun CreateDisableSimpleButton() {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            disabledBackgroundColor = Color.Gray,
            disabledContentColor = Color.White,
            backgroundColor = Color.Red,
            contentColor = Color.White
        ),
        enabled = false
    ) {
        Text(text = "Disable Button")
    }
}

@Composable
private fun CreateIconHorizontalButton() {
    Button(
        onClick = {},
    ) {
        Icon(Icons.Default.ShoppingCart, contentDescription = null )
        Text(text = "Horizontal Icon Button")
    }
}

@Composable
private fun CreateIconVerticalButton() {
    Button(
        onClick = {},
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(Icons.Default.ShoppingCart, contentDescription = null )
            Text(text = "Vertical Icon Button")
        }
    }
}

@Composable
private fun CreateRoundedCornerButton() {
    Button(
        onClick = {},
        /** shape = RoundedCornerShape(12.dp) **/
        shape = RoundedCornerShape(topEnd = 12.dp, bottomEnd = 12.dp)
    ) {
        Text(text = "Rounded corner button")
    }
}

@Composable
private fun CreateBorderSimpleButton() {
    Button(
        onClick = {},
        border = BorderStroke(width = 2.dp, color = Color.Red),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White
        ),
        shape = RoundedCornerShape(24.dp)
    ) {
        Text(text = "Border Button", color = Color.Red)
    }
}

@Composable
private fun CreateOutlineButton() {
    OutlinedButton(
        onClick = {}
    ) {
        Text(text = "Outline button")
    }
}

@Composable
private fun CreateTextButton() {
    TextButton(
        onClick = {}
    ) {
        Text(text = "Text Button")
    }
}

@Composable
private fun CreateIconButton() {
    IconButton(
        onClick = {}
    ) {
        Icon(imageVector = Icons.Default.Phone, contentDescription = null )
    }
}

@Composable
private fun CreateShadowSimpleButton() {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White
        ),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 10.dp,
            pressedElevation = 15.dp,
            disabledElevation = 0.dp
        )
    ) {
        Text(text = "Shadow Button")
    }
}

@Composable
private fun CreateOnClickButton() {
    val count = remember {
        mutableStateOf(0)
    }

    Column() {
        Text(text = "Click Count = ${count.value}")
        Button(
            onClick = {
                count.value++
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Red,
                contentColor = Color.White
            )
        ) {
            Text(text = "Click On Here")
        }
    }
}

@Composable
private fun CreateDemoClickable() {
    Column(
        modifier = Modifier
            .width(100.dp)
            .clickable {

            }) {
        Image(
            painter = painterResource(
                id = R.drawable.ic_launcher_background
            ),
            contentDescription = null,
            modifier = Modifier
                .height(50.dp)
                .width(50.dp)
        )
        Text(text = "Product Name")
        Text(text = "20 0$")
    }
}

@Composable
private fun CreateDemoDetectTapGestures() {
    val textContent = remember {
        mutableStateOf("")
    }
    Column() {
        Text(text = "Value = " + textContent.value)
        Text(
            text = "Click Here",
            modifier = Modifier.pointerInput(Unit) {
                detectTapGestures(
                    onDoubleTap = { textContent.value = "Double Click" },
                    onLongPress = { textContent.value = "Long Press" },
                    onPress = { textContent.value = "Press" }
                )
            }
        )
    }
}

@Composable
private fun HomeScreen() {
    Column(
        modifier = Modifier.padding(15.dp)
    ) {
        Spacer(modifier = Modifier.height(5.dp))
        CreateSimpleButton()
        Spacer(modifier = Modifier.height(5.dp))
        CreateDisableSimpleButton()
        Spacer(modifier = Modifier.height(5.dp))
        CreateIconHorizontalButton()
        Spacer(modifier = Modifier.height(5.dp))
        CreateIconVerticalButton()
        Spacer(modifier = Modifier.height(5.dp))
        CreateRoundedCornerButton()
        Spacer(modifier = Modifier.height(5.dp))
        CreateBorderSimpleButton()
        Spacer(modifier = Modifier.height(5.dp))
        CreateOutlineButton()
        Spacer(modifier = Modifier.height(5.dp))
        CreateTextButton()
        Spacer(modifier = Modifier.height(5.dp))
        CreateIconButton()
        Spacer(modifier = Modifier.height(5.dp))
        CreateShadowSimpleButton()
        Spacer(modifier = Modifier.height(5.dp))
        CreateOnClickButton()
        Spacer(modifier = Modifier.height(5.dp))
        CreateDemoDetectTapGestures()
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
private fun ButtonPreview() {
    LearnComposeTheme {
        HomeScreen()
    }
}
