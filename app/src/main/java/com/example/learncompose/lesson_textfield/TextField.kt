package com.example.learncompose.lesson_textfield

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learncompose.ui.theme.LearnComposeTheme

class TextField : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }
    }
}

@Composable
private fun CreateSimpleTextField() {
    TextField(value = "", onValueChange = {})
}

@Composable
private fun CreateDemoSimpleTextField() {
    var firstName by remember {
        mutableStateOf("")
    }
    TextField(
        value = firstName,
        onValueChange = { newValue ->
            firstName = newValue
        }, textStyle = TextStyle(
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        ),  // label = ,
        placeholder = {
            Text(text = "Enter your name!")
        },
        leadingIcon = {
            Icon(Icons.Default.Person, contentDescription = null)
        },
        trailingIcon = {
            IconButton(onClick = {
                firstName = ""
            }) {
                Icon(Icons.Default.Close, contentDescription = null)
            }

        }, colors = TextFieldDefaults.textFieldColors(
            cursorColor = Color.Black,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            trailingIconColor = Color.Magenta,
            leadingIconColor = Color.Magenta
        )
    )
}

@Composable
private fun CreateRadiusTextFiled() {
    var firstName by remember {
        mutableStateOf("")
    }
    TextField(
        value = firstName,
        onValueChange = { newValue ->
            firstName = newValue
        },
        textStyle = TextStyle(
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        ),  // label = ,
        placeholder = {
            Text(text = "Enter your name!")
        },
        leadingIcon = {
            Icon(Icons.Default.Person, contentDescription = null)
        },
        trailingIcon = {
            IconButton(onClick = {
                firstName = ""
            }) {
                Icon(Icons.Default.Close, contentDescription = null)
            }

        },
        colors = TextFieldDefaults.textFieldColors(
            cursorColor = Color.Black,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            trailingIconColor = Color.Magenta,
            leadingIconColor = Color.Magenta
        ),
        shape = RoundedCornerShape(16.dp),
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun CreateTextFiledKeyBoardAction() {
    var numberPhone by remember {
        mutableStateOf("")
    }
    val keyboardController = LocalSoftwareKeyboardController.current

    TextField(
        value = numberPhone,
        onValueChange = { newValue ->
            numberPhone = newValue
        }, textStyle = TextStyle(
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        ),  // label = ,
        placeholder = {
            Text(text = "Enter your phone!")
        },
        leadingIcon = {
            Icon(Icons.Default.Person, contentDescription = null)
        },
        trailingIcon = {
            IconButton(onClick = {
                numberPhone = ""
            }) {
                Icon(Icons.Default.Close, contentDescription = null)
            }

        }, colors = TextFieldDefaults.textFieldColors(
            cursorColor = Color.Black,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            trailingIconColor = Color.Magenta,
            leadingIconColor = Color.Magenta
        ),
        shape = RoundedCornerShape(16.dp),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Phone,
            // capitalization =
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
            }
        )
    )
}

@Composable
private fun CreateOutlineTextFiled() {
    var email by remember {
        mutableStateOf("")
    }
    OutlinedTextField(value = email, onValueChange = { newValue ->
        email = newValue
    },
        placeholder = {
            Text(text = "Email")
        },
        label = {
            Text(text = "Email")
        },
        leadingIcon = {
            Icon(Icons.Default.Email, contentDescription = null)
        }
    )
}

@Composable
private fun CreateTextFiledPassword() {
    var password by remember {
        mutableStateOf("")
    }

    var isShowPassword by remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        value = password, onValueChange = { newValue ->
            password = newValue
        },
        placeholder = {
            Text(text = "Enter your password!")
        },
        label = {
            Text(text = "Password")
        },
        leadingIcon = {
            Icon(Icons.Default.Lock, contentDescription = null)
        },
        trailingIcon = {
            IconButton(onClick = {
                isShowPassword = !isShowPassword
            }) {
                Icon(
                    if (isShowPassword) Icons.Filled.Face
                    else Icons.Filled.CheckCircle,
                    contentDescription = null
                )
            }
        },
        visualTransformation =
        if (isShowPassword) VisualTransformation.None
        else PasswordVisualTransformation()
    )

}

@Composable
private fun HomeScreen() {
    Column(modifier = Modifier.padding(15.dp)) {
        Spacer(modifier = Modifier.height(10.dp))
        CreateSimpleTextField()
        Spacer(modifier = Modifier.height(10.dp))
        CreateDemoSimpleTextField()
        Spacer(modifier = Modifier.height(10.dp))
        CreateRadiusTextFiled()
        Spacer(modifier = Modifier.height(10.dp))
        CreateTextFiledKeyBoardAction()
        Spacer(modifier = Modifier.height(10.dp))
        CreateOutlineTextFiled()
        Spacer(modifier = Modifier.height(10.dp))
        CreateTextFiledPassword()
        Spacer(modifier = Modifier.height(10.dp))
    }
}

@Composable
@Preview(
    showSystemUi = true,
    showBackground = true
)
private fun TextFieldPreview() {
    LearnComposeTheme {
        HomeScreen()
    }
}
