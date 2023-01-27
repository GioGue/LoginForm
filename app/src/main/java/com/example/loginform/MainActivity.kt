package com.example.loginform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginform.ui.theme.LoginFormTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginFormTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginForm()
                }
            }
        }
    }
}

@Composable
fun LoginForm() {
    var username: String by remember { mutableStateOf("") }
    var password: String by remember { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    Column(
        modifier = Modifier.padding(8.dp)
    ){
        Text(
            text = stringResource(R.string.login),
            color = MaterialTheme.colors.primary,
            fontSize = 48.sp,
            textAlign = TextAlign.Left,
            modifier =Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = username,
            onValueChange = {username = it},
            trailingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "Email icon") },
            label = {Text(text= stringResource(R.string.username))},
            placeholder = { Text(text = "Type your username") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
        )
        Text(
            text = "",
            fontSize = 6.sp,
        )
        OutlinedTextField(
            value = password,
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            onValueChange = {password = it},
            trailingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "Lock icon") },
            label = {Text(text= stringResource(R.string.password))},
            placeholder = { Text(text = "Type your password") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        )
        Text(
            text = "",
            fontSize = 12.sp,
        )
        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth(),

        ){ //button composable contains an other composable
            Text(
                text = "Submit",
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                modifier =Modifier.fillMaxWidth()
                )
        }
    }

}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoginFormTheme {
        LoginForm()
    }
}