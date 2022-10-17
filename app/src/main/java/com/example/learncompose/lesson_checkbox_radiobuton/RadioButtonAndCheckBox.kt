package com.example.learncompose.lesson_checkbox_radiobuton

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learncompose.ui.theme.LearnComposeTheme

class RadioButtonAndCheckBox : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }
    }
}


@Composable
private fun CreateSimpleRadioButton() {
    Row() {
        RadioButton(
            selected = true,
            onClick = {},
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Green,
                disabledColor = Color.Gray
            )
        )

        RadioButton(
            selected = false,
            onClick = {},
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Green,
                disabledColor = Color.Gray
            )
        )
        RadioButton(
            enabled = false,
            selected = false,
            onClick = {},
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Green,
                disabledColor = Color.Gray
            )
        )
    }

}

@Composable
private fun CreateRadioButtonTitle() {
    Row() {
        RadioButton(selected = true, onClick = {})
        Text(text = "RadioButton")
    }
}

@Composable
private fun CreateActionSelectedRadioButton() {
    var isSelected by remember {
        mutableStateOf(false)
    }
    Row(
        modifier = Modifier.selectable(
            selected = isSelected,
            onClick = { isSelected = !isSelected },
            role = Role.RadioButton
        )
    ) {
        RadioButton(
            selected = isSelected,
            onClick = null,
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Green,
                disabledColor = Color.Gray
            )
        )
    }
}

@Composable
private fun CreateCustomRadioButton() {
    var isSelected by remember {
        mutableStateOf(false)
    }
    Row(
        modifier = Modifier.selectable(
            selected = isSelected,
            onClick = { isSelected = !isSelected },
            role = Role.RadioButton
        )
    ) {
        val iconRadio = if (isSelected) Icons.Default.Check else Icons.Filled.CheckCircle
        Icon(iconRadio, contentDescription = null)
        Text(text = "RadioButton Custom", modifier = Modifier.padding(start = 10.dp))
    }
}

@Composable
private fun CreateSimpleCheckbox() {
    Column(modifier = Modifier.padding(10.dp)) {
        Checkbox(
            checked = true, onCheckedChange = {

            }, colors = CheckboxDefaults.colors(
                checkedColor = Color.Red,
                uncheckedColor = Color.Green
            )
        )
        Checkbox(
            checked = false, onCheckedChange = {

            }, colors = CheckboxDefaults.colors(
                checkedColor = Color.Red,
                uncheckedColor = Color.Green
            )
        )
    }
}

@Composable
private fun CreateCheckBoxWithTitle() {
    var isChecked by remember {
        mutableStateOf(false)
    }
    Row(
        modifier = Modifier.selectable(
            selected = isChecked,
            onClick = {
                isChecked = !isChecked
            },
            role = Role.Checkbox
        )
    ) {
        Checkbox(
            checked = isChecked, onCheckedChange = null,
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Red,
                uncheckedColor = Color.Green
            )
        )
        Text(text = "Pizza", modifier = Modifier.padding(start = 10.dp))
    }
}

@Composable
private fun CreateCustomCheckBox() {
    var isChecked by remember {
        mutableStateOf(false)
    }
    Row(
        modifier = Modifier.selectable(
            selected = isChecked,
            onClick = {
                isChecked = !isChecked
            },
            role = Role.Checkbox
        )
    ) {
        val icons = if (isChecked) Icons.Filled.Check else Icons.Filled.CheckCircle
        Icon(icons, contentDescription = null)
        Text(text = "Pasta", modifier = Modifier.padding(start = 10.dp))
    }
}

@Composable
private fun HomeScreen() {
    Column(modifier = Modifier.padding(15.dp)) {
        Spacer(modifier = Modifier.height(10.dp))
        CreateSimpleRadioButton()
        Spacer(modifier = Modifier.height(10.dp))
        CreateRadioButtonTitle()
        Spacer(modifier = Modifier.height(10.dp))
        CreateActionSelectedRadioButton()
        Spacer(modifier = Modifier.height(10.dp))
        CreateCustomRadioButton()
        Spacer(modifier = Modifier.height(10.dp))
        CreateSimpleCheckbox()
        Spacer(modifier = Modifier.height(10.dp))
        CreateCheckBoxWithTitle()
        Spacer(modifier = Modifier.height(10.dp))
        CreateCustomCheckBox()
    }
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
