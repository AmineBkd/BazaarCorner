package com.example.bazaarcorner.ui.component.home

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bazaarcorner.ui.theme.searchTextFieldContainerColor
import com.example.bazaarcorner.ui.theme.searchTextFieldPlaceHolderContent


@Composable
fun SearchTextFieldComponent(
    modifier: Modifier = Modifier,
    placeHolderText: String = "Search for products"
) {
    var text by remember { mutableStateOf("") }
    val textSize = 18.sp

    OutlinedTextField(
        maxLines = 1,
        leadingIcon = {
            Icon(
                Icons.Rounded.Search,
                contentDescription = null,
                Modifier
                    .padding(start = 20.dp, end = 10.dp)
                    .size(28.dp),
                tint = searchTextFieldPlaceHolderContent
            )
        },
        modifier = modifier,
        value = text,
        onValueChange = { text = it },
        shape = RoundedCornerShape(20.dp),
        placeholder = {
            Row {
                Text(
                    placeHolderText,
                    fontSize = textSize,
                    color = searchTextFieldPlaceHolderContent
                )
            }
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = searchTextFieldContainerColor,
            unfocusedBorderColor = searchTextFieldContainerColor,
            focusedContainerColor = searchTextFieldContainerColor,
            unfocusedContainerColor = searchTextFieldContainerColor,
            disabledContainerColor = searchTextFieldContainerColor,

            ),
        textStyle = TextStyle.Default.copy(fontSize = textSize)
    )
}