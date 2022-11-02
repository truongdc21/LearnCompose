package com.example.learncompose.lesson_layout.layout_box

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learncompose.ui.theme.LearnComposeTheme

class DemoLayoutBox1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }
    }
}


@Composable
private fun CreateDemoBoxOne() {
    Box() {
        com.example.learncompose.lesson_layout.BoxItem(color = Color.Blue, size = 200.dp)
        com.example.learncompose.lesson_layout.BoxItem(color = Color.Red, size = 150.dp)
        com.example.learncompose.lesson_layout.BoxItem(color = Color.Yellow)
    }
}


@Composable
private fun HomeScreen() {
    Spacer(modifier = Modifier.height(10.dp))
    CreateDemoBoxOne()
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
