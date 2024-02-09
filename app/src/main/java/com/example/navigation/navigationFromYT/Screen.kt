package com.example.navigation.navigationFromYT

sealed class Screen(
    var route: String
){
    object LoginScreen : Screen("login_screen")
    object HomeScreen : Screen("home_screen")

    object ItemDetailScreen : Screen("item_detail_screen")

    object  ItemDetailScreenPart2 : Screen("item_detail_part2_screen")

//    fun withArgs(vararg args:String):String{
//        return buildString {
//            append(route)
//            args.forEach { arg ->
//                append("/$arg")
//            }
//        }
//    }
}