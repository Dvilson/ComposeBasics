package com.example.weatherapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.ui.theme.typography


@Composable
fun HeadlineSection(
    navcontroller: NavController
) {
    Card(
        shape = RoundedCornerShape(4.dp),
        elevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(16.dp)
            .clickable(onClick = { navcontroller.navigate("form") })
    ) {


        Box(
            contentAlignment = Alignment.Center,

            ) {

            Image(
                painter = painterResource(id = R.drawable.jetpack_compose_logo),
                contentDescription = "logo",
                contentScale = ContentScale.Crop
            )
            Box(
                contentAlignment = Alignment.BottomCenter,
                modifier = Modifier
                    .fillMaxSize()

            ) {
                Text("Chantier")
            }
        }
    }
}

@Composable
fun LatestNewsSection() {

   Card(
       shape = RoundedCornerShape(4.dp),
       elevation = 4.dp,
       modifier = Modifier
           .fillMaxWidth()
           .height(150.dp)
           .padding(16.dp)
   ){

       Row(
           horizontalArrangement = Arrangement.Start,
           verticalAlignment = Alignment.CenterVertically,
           modifier = Modifier.fillMaxWidth()
       ) {

           Image(
               painter = painterResource(id = R.drawable.header),
               contentDescription = null,
               contentScale = ContentScale.Crop,
               modifier = Modifier
                   .padding(16.dp)
                   .clip(CircleShape)
                   .size(64.dp)


           )

           Column() {

               Text(
                   text = "CAN 2021: la Guinée sera face au Senegal, Zimbabwe et Malawi dans le groupe B",
                   style = typography.h6,
                   maxLines = 3,


                   )
               Spacer(modifier = Modifier.height(8.dp))
               Text(
                   text = "01 auout 2021",
                   style = typography.body2,
                   textAlign = TextAlign.Right
               )

           }

       }

   }

}

@Preview(showBackground = true)
@Composable
fun HealineSectionPreviewLayout() {
    //HeadlineSection(navcontroller = rememberNavController())
    LatestNewsSection()

}