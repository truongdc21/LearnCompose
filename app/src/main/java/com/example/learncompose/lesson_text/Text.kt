package com.example.learncompose.lesson_text

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learncompose.R
import com.example.learncompose.ui.theme.LearnComposeTheme

class Text : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }
    }
}

@Composable
private fun HomeScreen() {
    Column(modifier = Modifier.padding(15.dp)) {
        CreateText()
        Spacer(modifier = Modifier.height(10.dp))
        CreateTextStringResource()
        Spacer(modifier = Modifier.height(10.dp))
        CreateTextSetColor()
        Spacer(modifier = Modifier.height(10.dp))
        CreateTextCustomMore()
        Spacer(modifier = Modifier.height(10.dp))
        CreateTextCustomStyle()
        Spacer(modifier = Modifier.height(10.dp))
        CreateTextMultipleStyle()
    }
}

@Composable
private fun CreateText() {
    Text(text = "Hello Everyone")
}

@Composable
private fun CreateTextStringResource() {
    Text(text = stringResource(id = R.string.app_name))
}

@Composable
private fun CreateTextSetColor() {
    Text(text = stringResource(id = R.string.app_name), color = Color.Red)
}

@Composable
private fun CreateTextCustomMore() {
    Text(
        text = stringResource(id = R.string.string_demo),
        color = Color.Blue,
        fontSize = 18.sp,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Justify,
        fontFamily = FontFamily.Serif,
        maxLines = 3,
        overflow = TextOverflow.Ellipsis
    )
}

val customTextStyle: androidx.compose.ui.text.TextStyle
    get() = androidx.compose.ui.text.TextStyle(
        color = Color.Red,
        fontSize = 16.sp,
        textAlign = TextAlign.End,
        textDecoration = TextDecoration.Underline,
    )

@Composable
private fun CreateTextCustomStyle() {
    Text(
        text = stringResource(id = R.string.string_demo),
        style = customTextStyle
    )
}

@Composable
private fun CreateTextMultipleStyle() {
    Text(text = buildAnnotatedString {
        withStyle( style = SpanStyle( 
            color = Color.Green,
        )) {
            append("H")
        }
        append("ello ")
        withStyle(style = SpanStyle(
            color = Color.Red,
            textDecoration = TextDecoration.LineThrough
        )) {
            append("Every")
        }
        append("one")
    })
}

@Composable
@Preview(
    showSystemUi = true,
    showBackground = true
)
private fun TextPreview() {
    LearnComposeTheme {
        HomeScreen()
    }
}

