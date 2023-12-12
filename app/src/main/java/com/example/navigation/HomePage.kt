package com.example.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    Button(
                        //popBackStack() kembali ke page yang sebelumnya
                        onClick = { navController.popBackStack() },
                        modifier = Modifier,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent
                        ),
                    ) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Share")
                    }
                },
                title = { Text(text = "This your Act nigga", color = Color.White, fontSize = 20.sp) },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = colorResource(id = R.color.purple_500)
                ),
                actions = {

//                    Button(
//                        onClick = { /*TODO*/ },
//                        modifier = Modifier,
//                        colors = ButtonDefaults.buttonColors(
//                            containerColor = Color.Transparent
//                        ),
//                        ) {
//                        Icon(Icons.Filled.Share, contentDescription = "Share",)
//                    }

                    Button(
                        onClick = { navController.navigate("LoginPage"){
                            popUpTo("HomePage"){inclusive = true}
                        } },
                        colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                        ),
                        )
                    {
                        Icon(Icons.Filled.ExitToApp, contentDescription = "Log Out")
                        Text(text = "Logout")
                    }
                }
            )
        },
        content = { paddingValues->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Text(text = "Hello and What's Up ")

            }
        }
    )
}
