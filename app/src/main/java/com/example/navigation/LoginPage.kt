package com.example.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(navController: NavController) {
    val emailFieldValue = remember {
        mutableStateOf("")
    }
    val passwordFieldValue = remember {
        mutableStateOf("")
    }
//    val placeholderEmailTextField = remember {
//        mutableStateOf("Email")
//    }
    Scaffold(

        topBar = {
            TopAppBar(
                title = { Text(text = "Welcome Bitch", color = Color.White, fontSize = 20.sp) },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = colorResource(id = R.color.purple_500)
                )
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                TextField(
                    value = emailFieldValue.value,
                    onValueChange = {emailFieldValue.value = it},
                    label = { Text(text = "Enter your E-mail")},
                    modifier = Modifier.width(300.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = colorResource(id = R.color.black),
                        focusedLabelColor = colorResource(id = R.color.teal_700),
                        unfocusedLabelColor = colorResource(id = R.color.teal_200),
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    ),
                    textStyle = TextStyle.Default.copy(fontWeight = FontWeight.Medium),
                    maxLines = 1,
                    shape = RoundedCornerShape(10.dp)
                )
                
                Spacer(modifier = Modifier.height(20.dp))
                
                TextField(
                    value = passwordFieldValue.value,
                    onValueChange = { passwordFieldValue.value = it },
                    label = {
                        Text(text = "Enter your Password")
                    },
                    modifier = Modifier.width(300.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = colorResource(id = R.color.black),
                        focusedLabelColor = colorResource(id = R.color.teal_700),
                        unfocusedLabelColor = colorResource(id = R.color.teal_200),
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    ),
                    textStyle = TextStyle.Default.copy(fontWeight = FontWeight.Medium),
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    visualTransformation = PasswordVisualTransformation(),
                    shape = RoundedCornerShape(10.dp),
                    //singleLine = true
                    )
                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    onClick = {
                              //navigate() berpindah page dengan menggunakan route ( route bersifat absolute )
                              navController.navigate("HomePage"){
                                  //inclusive = true, if we're goes to second page from first page, the first page is destroyed and when we go back again it will closed the app
                                  popUpTo("LoginPage"){inclusive = true}
                              }
                    },
                    modifier = Modifier.height(40.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.teal_700)
                    ),
                    shape = RoundedCornerShape(5.dp)
                    ) {
                    Text(text = "Go to Home Page")
                }
            }
        }
    )
}
