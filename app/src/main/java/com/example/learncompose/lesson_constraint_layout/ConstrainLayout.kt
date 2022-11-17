package com.example.learncompose.lesson_constraint_layout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.learncompose.R
import com.example.learncompose.ui.theme.LearnComposeTheme

class TextField : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }
    }
}

@Composable()
private fun Ingredient(
    @DrawableRes icon: Int,
    value: Int,
    unit: String?,
    name: String,
    modifier: Modifier = Modifier
) {
    val backgroundColor = Color(0xFFFAF6B5)
    val borderColor = Color(0xFFFB8E97).copy(alpha = 0.7f)

    ConstraintLayout(
        modifier = modifier
            .background(color = backgroundColor, shape = CircleShape)
            .border(BorderStroke(width = 1.dp, color = borderColor))
    ) {
        val horizontalGuideLine50 = createGuidelineFromTop(0.5f)
        val imgIcon = createRef()
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.constrainAs(imgIcon) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(horizontalGuideLine50)
                height = Dimension.fillToConstraints
            },
            contentScale = ContentScale.FillHeight
        )
        val (tvValue, tvUnit, tvName) = createRefs()
        val verticalGuideLine50 = createGuidelineFromStart(0.5f)
        val valueTextColor = Color(0xFFFB7D8A)
        Text(
            text = value.toString(),
            style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontSize = 36.sp,
                lineHeight = 14.sp,
                color = valueTextColor
            ),
            modifier = Modifier.constrainAs(tvValue) {
                top.linkTo(horizontalGuideLine50, margin = 2.dp)
                end.linkTo(verticalGuideLine50, margin = 2.dp)
            }
        )
        unit?.let {
            Text(
                text = unit.toString(),
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 8.sp,
                    lineHeight = 14.sp,
                    color = valueTextColor
                ),
                modifier = Modifier.constrainAs(tvUnit) {
                    top.linkTo(tvValue.bottom, margin = 2.dp)
                    end.linkTo(tvValue.end, margin = 2.dp)
                }
            )
        }

        Text(
            text = name,
            style = TextStyle(
                color = Color(0xFF1E2742),
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                lineHeight = 14.sp
            ),
            modifier = Modifier.constrainAs(tvName) {
                top.linkTo(horizontalGuideLine50)
                start.linkTo(verticalGuideLine50)
                if (unit != null) {
                    bottom.linkTo(tvUnit.bottom)
                } else {
                    bottom.linkTo(tvValue.bottom)
                }
                width = Dimension.fillToConstraints
            },
            maxLines = 2,
            textAlign = TextAlign.Start,

            )
    }
}


@Composable
@Preview(
    showBackground = true
)
private fun IngredientPreview() {
    Row {
        Ingredient(
            icon = R.drawable.leaves,
            value = 30,
            unit = "TEST",
            name = "Leaves juice",
            modifier = Modifier.size(150.dp)
        )
    }
}

@Composable
private fun HomeScreen() {
    ConstraintLayout {
        val configuration = LocalConfiguration.current
        val screenWidth = configuration.screenWidthDp.dp
        val itemWidth = screenWidth / 4

        val (tvIngredients, imgArrow) = createRefs()
        Text(
            text = "Ingredients",
            style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontSize = 28.sp,
                lineHeight = 14.sp,
                color = Color(0xFF000000),
            ),
            modifier = Modifier.constrainAs(tvIngredients) {
                top.linkTo(parent.top, margin = 20.dp)
                start.linkTo(parent.start, margin = 15.dp)
            }
        )

        Icon(
            imageVector = Icons.Outlined.KeyboardArrowRight,
            contentDescription = null,
            tint = Color(0xffFB7D8A),
            modifier = Modifier
                .size(30.dp)
                .constrainAs(imgArrow) {
                    start.linkTo(tvIngredients.end, margin = 15.dp)
                    top.linkTo(tvIngredients.top)
                    bottom.linkTo(tvIngredients.bottom)
                }
        )

        val (lineOne, lineTwo) = createRefs()
        ConstraintLayout(modifier = Modifier
            .fillMaxWidth()
            .constrainAs(lineOne) {
                top.linkTo(tvIngredients.bottom, margin = 20.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }) {
            val (ingredient1, ingredient2, ingredient3) = createRefs()

            val lineOneChain = createHorizontalChain(
                ingredient1,
                ingredient2,
                ingredient3,
                /**
                 * with { ChainStyle.Spread }
                 */
                chainStyle = ChainStyle.Spread
            )

            Ingredient(
                icon = R.drawable.leaves,
                value = 8,
                unit = null,
                name = "Mint \nLeaves",
                modifier = Modifier
                    .size(itemWidth)
                    .constrainAs(ingredient1) { lineOneChain }
            )
            Ingredient(
                icon = R.drawable.lemone,
                value = 8,
                unit = null,
                name = "Lemon \nWedges",
                modifier = Modifier
                    .size(itemWidth)
                    .constrainAs(ingredient2) { lineOneChain }
            )
            Ingredient(
                icon = R.drawable.juice,
                value = 8,
                unit = "ml",
                name = "Lemon \nJuice",
                modifier = Modifier
                    .size(itemWidth)
                    .constrainAs(ingredient3) { lineOneChain }
            )
        }

        ConstraintLayout(modifier = Modifier
            .fillMaxWidth()
            .constrainAs(lineTwo) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(lineOne.bottom, margin = 20.dp)
            }) {
            val (ingredient1, ingredient2, ingredient3) = createRefs()

            val lineOneChain = createHorizontalChain(
                ingredient1,
                ingredient2,
                ingredient3,
                /**
                 * with { ChainStyle.SpreadInside }
                 */
                chainStyle = ChainStyle.SpreadInside
            )

            Ingredient(
                icon = R.drawable.leaves,
                value = 8,
                unit = null,
                name = "Mint \n Leaves",
                modifier = Modifier
                    .size(itemWidth)
                    .constrainAs(ingredient1) { lineOneChain }
            )
            Ingredient(
                icon = R.drawable.leaves,
                value = 8,
                unit = null,
                name = "Mint \n Leaves",
                modifier = Modifier
                    .size(itemWidth)
                    .constrainAs(ingredient2) { lineOneChain }
            )
            Ingredient(
                icon = R.drawable.leaves,
                value = 8,
                unit = null,
                name = "Mint \n Leaves",
                modifier = Modifier
                    .size(itemWidth)
                    .constrainAs(ingredient3) { lineOneChain }
            )
        }
    }
}

@Composable
@Preview(
    showSystemUi = true,
    showBackground = true
)
private fun Preview() {
    LearnComposeTheme {
        HomeScreen()
    }
}
