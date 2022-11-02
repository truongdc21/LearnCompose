package com.example.learncompose.lesson_layout.layout_column

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
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

class DemoLayoutColumn3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
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
private fun HomeScreen() {
    Spacer(modifier = Modifier.height(10.dp))
    CreateDemoColumnLayoutThree()
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
