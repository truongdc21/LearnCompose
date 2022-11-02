package com.example.learncompose.lesson_layout.row

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learncompose.lesson_layout.BoxItem
import com.example.learncompose.ui.theme.LearnComposeTheme

class DemoLayoutBox2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }
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
            horizontalArrangement = Arrangement.SpaceAround
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
private fun HomeScreen() {
    Spacer(modifier = Modifier.height(10.dp))
    CreateDemoRowLayoutTwo()
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
