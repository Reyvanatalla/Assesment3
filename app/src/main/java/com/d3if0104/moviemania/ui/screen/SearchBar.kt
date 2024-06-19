package com.d3if0104.moviemania.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.d3if0104.moviemania.ui.screen.component.SmallText
import com.d3if0104.moviemania.ui.theme.GreyCard
import com.d3if0104.moviemania.ui.theme.GreyText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    value: String,
    onSearchAction: (String) -> Unit,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onSearchAction,
        modifier = modifier.fillMaxWidth(),
        shape = CircleShape,
        maxLines = 1,
        singleLine = true,
        placeholder = {
            SmallText(text = "Cari disini...", color = GreyText)
        },
        trailingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = "Search", tint = GreyText)
        },
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = GreyCard,
            focusedContainerColor = GreyCard,
            unfocusedBorderColor = Color.Transparent,
            focusedBorderColor = Color.Transparent
        ),
        textStyle = TextStyle(
            fontSize = 14.sp
        ),
    )
}

@Preview
@Composable
private fun SearchBarPrev() {
    SearchBar(
        value = "",
        onSearchAction = {

        },
    )
}