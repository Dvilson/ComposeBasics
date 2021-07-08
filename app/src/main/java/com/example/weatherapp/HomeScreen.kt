package com.example.weatherapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.weatherapp.ui.theme.*

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxWidth()
    ) {
        Column {
            GreetingSection()
            ChipSection(chips = listOf("Camara","Kissi","Mohamed") )


        }
    }
}

@Composable
fun GreetingSection(
    name: String = "Mohamed Kissi"
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Good morning $name",
                style = MaterialTheme.typography.h2
            )

            Text(
                text = "Passez une excellente journée",
                style = MaterialTheme.typography.h4
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Search",
                tint = Color.White,
                modifier = Modifier.size(24.dp)

            )

        }

    }
}

@Composable
fun ChipSection(chips: List<String>) {

    var selectedChipIndex by remember {
        mutableStateOf(0)
    }
    LazyRow {
        items(chips.size) {
            Box(
                contentAlignment= Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectedChipIndex = it
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedChipIndex == it) ButtonBlue
                        else DarkerButtonBlue
                    )
                    .padding(15.dp)
            ) {
                Text(text = chips[it], color = TextWhite)

            }

        }
    }


}

@Composable
fun CurrentMeditation(
    color:Color = LightRed
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,

        horizontalArrangement = Arrangement.SpaceBetween,
    modifier = Modifier
        .padding(15.dp)
        .clip(RoundedCornerShape(10.dp))
        .background(color)
        .fillMaxWidth()) {

        Column {
            Text(
                text  = "Daily thought",
                style  =MaterialTheme.typography.h2)
            Text(
                text = "Meditation 3-10 min ",
                style = MaterialTheme.typography.body1,
                color = TextWhite
            )
        }
        Box(
            contentAlignment= Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background()
                .padding()
        )
    }

}


