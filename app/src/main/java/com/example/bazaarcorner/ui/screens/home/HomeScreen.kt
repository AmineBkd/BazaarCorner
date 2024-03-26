package com.example.bazaarcorner.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.bazaarcorner.ui.component.home.SearchTextFieldComponent
import com.example.bazaarcorner.ui.theme.backgroundHome
import com.example.bazaarcorner.ui.theme.contentBlack
import com.example.bazaarcorner.ui.theme.white

@Composable
fun HomeScreen() {
    Surface(Modifier.fillMaxSize()) {
        Scaffold(
            topBar = { HomeScreenTopAppBar() },
            bottomBar = { HomeScreenBottomNavigationBar() },
        ) { innerPadding ->
            Column(Modifier.padding(innerPadding)) {
                HomeScreenContent()
            }
        }
    }
}

//Properly Put both Top Bar, and Bottom Bar in their respective component file
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenTopAppBar() {
    TopAppBar(colors = TopAppBarDefaults.topAppBarColors(
        containerColor = white,
        titleContentColor = contentBlack,
    ), title = {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                Text(
                    text = "Bazaar Corner",
                    fontWeight = FontWeight(400),
                    modifier = Modifier.padding(end = 10.dp)
                )
            }
        }

        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.End) {
            Row {
                Icon(
                    Icons.Rounded.ShoppingCart,
                    contentDescription = "Shopping Icons",
                    Modifier.padding(end = 30.dp, top = 4.dp)
                )
            }
        }
    })
}

@Composable
fun HomeScreenBottomNavigationBar() {
    var selectedItemIndex by rememberSaveable { mutableIntStateOf(0) }
    val items = listOf(
        BottomNavigationItem("Home", Icons.Filled.Home, Icons.Outlined.Home, false),
        BottomNavigationItem("Chat", Icons.Filled.Email, Icons.Outlined.Email, false),
        BottomNavigationItem("Settings", Icons.Filled.Settings, Icons.Outlined.Settings, false)
    )
    NavigationBar(containerColor = white) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                label = { Text(item.title) },
                selected = selectedItemIndex == index,
                onClick = {
                    selectedItemIndex = index
                    //add navController Here
                },
                icon = {

                    when (selectedItemIndex) {
                        index -> Icon(item.selectedIcon, item.title)
                        else -> Icon(item.unselectedIcon, item.title)
                    }
                })
        }

    }
}

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean
)

@Composable
fun HomeScreenContent() {
    val bottomRoundedCornerShapeValue = 12.dp

    Column(
        Modifier
            .background(backgroundHome)
            .fillMaxSize()
    ) {

        Column(
            Modifier
                .shadow(4.dp)
                .fillMaxWidth()
                .background(
                    white,
                    shape = RoundedCornerShape(
                        bottomEnd = bottomRoundedCornerShapeValue,
                        bottomStart = bottomRoundedCornerShapeValue
                    )
                )
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier.padding(bottom = 20.dp)
            ) {
                SearchTextFieldComponent(
                    Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp)
                )
            }
        }
    }
}