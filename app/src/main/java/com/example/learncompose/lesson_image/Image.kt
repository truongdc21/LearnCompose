package com.example.learncompose.lesson_image

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.learncompose.R
import com.example.learncompose.ui.theme.LearnComposeTheme

class Image : ComponentActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { 
            LearnComposeTheme {
                CreateImageLoadFromUrl()
            }
        }
    }
}

@Composable
private fun HomeScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        CreateImage()
        Spacer(modifier = Modifier.height(10.dp))
        CreateVectorImage()
        Spacer(modifier = Modifier.height(10.dp))
        CreateCustomPainterImage()
        Spacer(modifier = Modifier.height(10.dp))
        CreateCircleAvatar()
        Spacer(modifier = Modifier.height(10.dp))
        CreateShadowRadiusImage()
    }
}

@Composable
private fun CreateImage() {
    Image(
        painterResource(
            id = R.drawable.ic_launcher_background
        ),
        contentDescription = null,
        modifier = Modifier
            .height(100.dp)
            .width(100.dp)
    )
}

@Composable
private fun CreateVectorImage() {
    Image(
        imageVector = Icons.Filled.Menu,
        contentDescription = null,
        modifier = Modifier
            .height(100.dp)
            .width(100.dp)
    )
}

@Composable
private fun CreateCustomPainterImage() {
    Image(
        ColorPainter(Color.Cyan),
        contentDescription = null,
        modifier = Modifier
            .height(100.dp)
            .width(100.dp)
    )
}

@Composable
private fun CreateCircleAvatar() {
    Surface(
        modifier = Modifier
            .height(100.dp)
            .width(100.dp)
            .border(
                BorderStroke(2.dp, color = Color.Gray),
                shape = CircleShape
            )
            .clip(shape = CircleShape)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
private fun CreateShadowRadiusImage() {
    Image(
        painter = painterResource(
            id = R.drawable.ic_launcher_background
        ),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .height(150.dp)
            .fillMaxHeight()
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(size = 20.dp)
            )
            .aspectRatio(2f)
    )
}

@Composable
private fun CreateImageLoadFromUrl() {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data("https://images.pexels.com/photos/719396/pexels-photo-719396.jpeg?cs=srgb&dl=pexels-gabriel-peter-719396.jpg")
            .crossfade(true)
            .build(),
        placeholder = painterResource(R.drawable.ic_launcher_foreground),
        contentDescription = null,
        contentScale = ContentScale.Inside,
        modifier = Modifier
            .fillMaxSize()
    )
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable()
private fun ImagePreview() {
    LearnComposeTheme {
        HomeScreen()
    }
}
