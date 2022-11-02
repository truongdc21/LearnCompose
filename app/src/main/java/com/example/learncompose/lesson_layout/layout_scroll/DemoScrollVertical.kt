package com.example.learncompose.lesson_layout.layout_scroll

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learncompose.lesson_layout.BoxItem
import com.example.learncompose.ui.theme.LearnComposeTheme

class DemoScrollVertical : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
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
    CreateVerticalScrollLayoutScroll()
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
