package com.example.bazaarcorner.ui.component.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.bazaarcorner.R
import com.example.bazaarcorner.ui.theme.transparent
import com.example.bazaarcorner.ui.theme.white

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomePagerComponent(modifier: Modifier = Modifier, pagerState: PagerState) {
    Column(Modifier.background(transparent)) {
        Row(modifier) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .shadow(10.dp, RoundedCornerShape(8.dp))
                    .background(
                        white, shape = RoundedCornerShape(
                            8.dp
                        )
                    ), contentAlignment = Alignment.Center
            ) {
                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier.fillMaxSize()
                ) { page ->
                    //Image holders
                    when(page) {
                        0->Image(painter = painterResource(id = R.drawable.iphone_x_gold_3d_leaked_wallpaper), contentDescription = "", Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
                        1->Image(painter = painterResource(id = R.drawable._1375), contentDescription = "", Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
                        2->Image(painter = painterResource(id = R.drawable.desktop_wallpaper_cosmetics_products), contentDescription = "", Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
                        3->Image(painter = painterResource(id = R.drawable.hd_wallpaper_apple_products_on_table), contentDescription = "", Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
                        4->Image(painter = painterResource(id = R.drawable.wp3079202), contentDescription = "", Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
                    }

                }
            }
        }
    }

    Box {
        Row(
            Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(top = 8.dp, bottom = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pagerState.pageCount) { iteration ->
                val color =
                    if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(8.dp)
                )
            }
        }
    }
}