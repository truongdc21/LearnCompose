package com.example.learncompose.lesson_layout.layout_column

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learncompose.lesson_layout.BoxItem
import com.example.learncompose.ui.theme.LearnComposeTheme

class DemoLayoutColumn2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
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
private fun HomeScreen() {
    Spacer(modifier = Modifier.height(10.dp))
    CreateDemoColumnLayoutTwo()
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
