package com.example.learncompose.lesson_layout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.learncompose.ui.theme.LearnComposeTheme

/**
 * Box -> like FrameLayout of Xml
 * Row -> is show Horizontal
 * Colum -> is show Vertical
 */

class Layout : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }
    }
}

@Composable
fun BoxItem(modifier: Modifier = Modifier, color: Color, size: Dp = 100.dp) {
    Box(
        modifier = modifier
            .size(size)
            .background(color = color)
    )
}

@Composable
private fun CreateDemoBoxOne() {
    Box() {
        BoxItem(color = Color.Blue, size = 200.dp)
        BoxItem(color = Color.Red, size = 150.dp)
        BoxItem(color = Color.Yellow)
    }
}

@Composable
private fun CreateDemoBoxTwo() {
    Box() {
        BoxItem(
            color = Color.Blue, size = 200.dp, modifier = Modifier
                .matchParentSize()
                .align(Alignment.TopStart)
        )
        BoxItem(color = Color.Red, size = 150.dp, modifier = Modifier.align(Alignment.TopEnd))
        BoxItem(color = Color.Yellow, modifier = Modifier.align(Alignment.BottomStart))
        BoxItem(color = Color.Magenta, modifier = Modifier.align(Alignment.BottomEnd))
        BoxItem(color = Color.Black, modifier = Modifier.align(Alignment.Center))
    }
}

@Composable
private fun CreateDemoRowLayout() {
    Row() {
        BoxItem(color = Color.Blue)
        BoxItem(color = Color.Red)
        BoxItem(color = Color.Yellow)
    }
}

@Composable
private fun CreateDemoRowLayoutTwo() {
    Box() {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .size(400.dp, 300.dp)
                .background(color = Color.Black),
            horizontalArrangement = Arrangement.Center
            /**
             * Y can choice any an Arrangement
             * 1. Equal Weight
             * 2. Space Between
             * 3. Space Around
             * 4. Space Evenly
             * 5. End (LTR)
             * 6. Center
             * 7. Start (LTR)
             */
        ) {
            BoxItem(color = Color.Blue)
            BoxItem(color = Color.Red)
            BoxItem(color = Color.Yellow)
        }
    }
}

@Composable
private fun CreateDemoRowLayoutThree() {
    Box() {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(value = "", onValueChange = {}, modifier = Modifier.weight(2f))
            Icon(Icons.Default.Send, contentDescription = null, Modifier.weight(1f))
        }
    }
}

@Composable
private fun CreateDemoColumnLayout() {
    Box() {
        Column(
        ) {
            BoxItem(color = Color.Blue)
            BoxItem(color = Color.Red)
            BoxItem(color = Color.Yellow)
        }
    }
}

@Composable
private fun CreateDemoColumnLayoutTwo() {
    Box() {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .size(300.dp, 700.dp)
                .background(color = Color.Black),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            BoxItem(color = Color.Blue)
            BoxItem(color = Color.Red)
            BoxItem(color = Color.Yellow)
        }
    }
}

@Composable
private fun CreateDemoColumnLayoutThree() {
    Box() {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)
        ) {
            Text(text = "Code has been send to 999")
            Spacer(modifier = Modifier.height(36.dp))
            OutlinedTextField(value = "", onValueChange = {})
            Spacer(modifier = Modifier.height(36.dp))
            Text(text = "Resend code in  53s")
        }
    }
}

@Composable
private fun CreateHorizontalScrollLayoutScroll() {
    Box() {
        Row(
            modifier = Modifier
                .horizontalScroll(
                    rememberScrollState()
                )
        ) {
            BoxItem(color = Color.Blue)
            BoxItem(color = Color.Red)
            BoxItem(color = Color.Yellow)
            BoxItem(color = Color.Blue)
            BoxItem(color = Color.Red)
            BoxItem(color = Color.Yellow)
        }
    }
}

@Composable
private fun CreateVerticalScrollLayoutScroll() {
    Box() {
        Column(
            modifier = Modifier
                .size(300.dp, 400.dp)
                .background(color = Color.Black)
                .verticalScroll(
                    rememberScrollState()
                )
        ) {
            BoxItem(color = Color.Blue)
            BoxItem(color = Color.Red)
            BoxItem(color = Color.Yellow)
            BoxItem(color = Color.Blue)
            BoxItem(color = Color.Red)
            BoxItem(color = Color.Yellow)
        }
    }
}

@Composable
private fun HomeScreen() {
    Spacer(modifier = Modifier.height(10.dp))
    CreateHorizontalScrollLayoutScroll()
}

@Composable
@Preview(
    showSystemUi = true,
    showBackground = true
)
private fun LayoutPreview() {
    LearnComposeTheme {
        HomeScreen()
    }
}
