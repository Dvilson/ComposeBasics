package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.ui.theme.WeatherAppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MyScreenContent()
            }

        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {

    WeatherAppTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }

}


@ExperimentalAnimationApi
@Composable
fun MyScreenContent(names: List<String> = listOf("Android", "There")) {
    var scaffoldState = rememberScaffoldState(rememberDrawerState(initialValue = DrawerValue.Closed))
    var scope  = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text("Compose basics") },
                navigationIcon = {
                    Icon(
                        Icons.Filled.Menu, null,
                        modifier = Modifier.clickable {scope.launch {
                            scaffoldState.drawerState.open()
                        }}
                    )
                },
                elevation = 8.dp
            )
        },
        drawerShape = RoundedCornerShape(topEnd = 25.dp,bottomEnd = 25.dp),
        drawerContent = { Text("Bonjour le monde") },

        content = {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                for (name in names) {
                    Greeting(name = name)
                    Divider()
                }
                Spacer(modifier = Modifier.padding(8.dp))
                Counter()
                Spacer(modifier = Modifier.padding(4.dp))
                for (i in 1..10){
                    UiCard()
                    Spacer(modifier = Modifier.padding(4.dp))
                }

            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { }) {
                Icon(Icons.Filled.Menu, null, Modifier.background(Color.White))
            }
        }
    )

}

@Composable
fun Counter() {
    var counter by remember { mutableStateOf(0) }
    Button(onClick = { counter++ }) {
        Text(text = "Vous avez cliqué $counter")
    }
}


@Composable
fun Greeting(name: String) {

    Text(
        text = "Hello $name!",
        style = MaterialTheme.typography.h2
    )
}

@Composable
fun LongList() {
    LazyColumn {

    }

}

@ExperimentalAnimationApi
@Composable
fun UiCard() {
    Card(
        shape = RoundedCornerShape(4.dp),
        elevation = 3.dp,
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        var expanded by remember { mutableStateOf(false)}
        Column(
            modifier = Modifier.clickable { expanded = !expanded }
        ) {
            Image(
                painter = painterResource(id = R.drawable.jetpack_compose_logo), contentDescription = "weights",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp),
                contentScale = ContentScale.Crop

            )
            AnimatedVisibility(visible = expanded) {
                Text(
                    text = "Je suis entrain de tester  jetpack compose",
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier.padding(16.dp)
                )

            }

        }

    }
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    MyApp {
//        MyScreenContent()
//    }
//}