package com.example.bazaarcorner.ui.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bazaarcorner.ui.component.home.HomePagerComponent
import com.example.bazaarcorner.ui.component.home.SearchTextFieldComponent
import com.example.bazaarcorner.ui.screens.navigation.BottomNavigationBar
import com.example.bazaarcorner.ui.screens.HomeScreenTopAppBar
import com.example.bazaarcorner.ui.theme.backgroundHome
import com.example.bazaarcorner.ui.theme.white

@Composable
fun HomeScreen(navController: NavController) {
    Surface(Modifier.fillMaxSize()) {
        Scaffold(
            topBar = { HomeScreenTopAppBar() },
            bottomBar = { BottomNavigationBar(navController = navController) },
        ) { innerPadding ->
            Column(Modifier.padding(innerPadding)) {
                HomeScreenContent()
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreenContent() {
    val pagerState = rememberPagerState(pageCount = {
        5
    })

    Column(
        Modifier
            .background(backgroundHome)
            .fillMaxSize()
    ) {
        HomeScreenContentHeader()
        HomeScreenContentBody(pagerState = pagerState)
    }
}

@Composable
fun HomeScreenContentHeader() {
    val bottomRoundedCornerShapeValue = 12.dp

    Column(
        Modifier
            .shadow(6.dp)
            .fillMaxWidth()
            .background(
                white, shape = RoundedCornerShape(
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreenContentBody(pagerState: PagerState) {
    Column(Modifier.verticalScroll(rememberScrollState())) {
        HomePagerComponent(Modifier.padding(top = 20.dp, start = 23.dp, end = 23.dp), pagerState)
    }
}