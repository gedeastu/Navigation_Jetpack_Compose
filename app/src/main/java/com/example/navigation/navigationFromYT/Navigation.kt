package com.example.navigation.navigationFromYT

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(){
    val navController = rememberNavController()
    //val context = LocalContext.current
    NavHost(
        navController = navController,
        startDestination = Screen.LoginScreen.route
    ){
        composable(route = Screen.LoginScreen.route){
            LoginScreen(navController = navController)
        }
        composable(
            route = Screen.HomeScreen.route,
//            arguments = listOf(
//                navArgument("name"){
//                    type = NavType.StringType
//                    defaultValue = "name"
//                    nullable = true
//                }
//            )
        ){
            //entry ->
            HomeScreen(
                //name = entry.arguments?.getString("name"),
                itemList = itemList,
                onItemClick = { item ->
                    navController.navigate("${Screen.ItemDetailScreen.route}/${item.id}")
            })
        }
        composable("item_detail_screen/{itemId}") { backStackEntry ->
            val itemId = backStackEntry.arguments?.getString("itemId")?.toIntOrNull()
            if (itemId != null) {
                val item = itemList.find { it.id == itemId }
                if (item != null) {
                    ItemDetailScreen(item = item, itemList2 = itemList2 ,onItemClick = {item2 ->
                        navController.navigate("${Screen.ItemDetailScreenPart2.route}/${item2.id}")
                    })
                } else {
                    // Handle invalid itemId
                }
            } else {
                // Handle missing or invalid itemId or itemName
            }
        }
        composable("item_detail_part2_screen/{itemId}") { backStackEntry ->
            val itemId = backStackEntry.arguments?.getString("itemId")?.toIntOrNull()
            if (itemId != null) {
                val item2 = itemList2.find { it.id == itemId }
                if (item2 != null) {
                    ItemDetailScreenPart2(item2 = item2)
                } else {
                    // Handle invalid itemId
                }
            } else {
                // Handle missing or invalid itemId or itemName
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController){
    var nameInputField by remember {
        mutableStateOf("")
    }
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp)
    ) {
        TextField(
            value = nameInputField,
            onValueChange = {
            nameInputField = it
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
                    navController.navigate(Screen.HomeScreen.route)
            //navController.navigate(Screen.HomeScreen.withArgs(nameInputField))
        }, modifier = Modifier.align(Alignment.End)) {
            Text(text = "Goes to Home")
        }
    }
}

@Composable
fun HomeScreen(itemList: List<Item>,onItemClick:(Item) -> Unit){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Hello Astu")
        LazyColumn(content = {
            items(itemList){ item ->
                Text(
                    text = item.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onItemClick(item) }
                        .padding(16.dp))
            }
        })
    }
}

@Composable
fun ItemDetailScreen(item: Item,itemList2: List<Item2>,onItemClick: (Item2) -> Unit) {
    println(itemList2)
    Column {
        Text(text = "Item: ${item.name}\nDescription: ${item.description}")
        LazyColumn(content = {
            items(itemList2){ item2 ->
                println(item2)
                Text(
                    text = item2.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onItemClick(item2) }
                        .padding(16.dp))
            }
        })
    }
    // Display item details here
}

@Composable
fun ItemDetailScreenPart2(item2: Item2) {
    // Display item details here
    Text(text = "Item: ${item2.name}\nDescription: ${item2.description}")
}