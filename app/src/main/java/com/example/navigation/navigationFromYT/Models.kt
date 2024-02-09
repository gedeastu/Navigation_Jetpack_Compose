package com.example.navigation.navigationFromYT

data class Item(
    val id: Int,
    val name: String,
    val description: String
)
val itemList = listOf(
    Item(1, "Item 1", "Description for Item 1"),
    Item(2, "Item 2", "Description for Item 2"),
    Item(3, "Item 3", "Description for Item 3"),
    // Add more items as needed
)

data class Item2(
    val id: Int,
    val name: String,
    val description: String
)
val itemList2 = listOf(
    Item2(1, "Item Satu", "Description for Item 1"),
    Item2(2, "Item Dua", "Description for Item 2"),
    Item2(3, "Item Tiga", "Description for Item 3"),
    // Add more items as needed
)