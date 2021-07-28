package com.example.weatherapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NewsScreen() {


}

@Preview
@Composable
fun HeadlineSection() {

    Card(
        shape = RoundedCornerShape(4.dp),
        elevation = 4.dp,
        modifier = Modifier
            .padding(16.dp)
    ){


        Box(
            contentAlignment =  Alignment.Center
        ){

            Image(
                painter = painterResource(id = R.drawable.jetpack_compose_logo),
                contentDescription = "logo",
                contentScale = ContentScale.Crop
            )
            Box(

            ){
                Text("Chantier")
            }
        }
    }
}