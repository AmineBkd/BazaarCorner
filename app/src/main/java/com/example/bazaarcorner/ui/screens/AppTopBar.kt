package com.example.bazaarcorner.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.bazaarcorner.ui.theme.contentBlack
import com.example.bazaarcorner.ui.theme.white

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