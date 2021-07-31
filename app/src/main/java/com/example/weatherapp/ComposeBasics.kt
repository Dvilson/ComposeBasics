package com.example.weatherapp

import android.content.Context
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@ExperimentalAnimationApi
@Composable
fun MyScreenContent(names: List<String> = listOf("Android", "There")) {
    var scaffoldState =
        rememberScaffoldState(rememberDrawerState(initialValue = DrawerValue.Closed))
    var scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text("Compose basics") },
                navigationIcon = {
                    Icon(

                        Icons.Filled.Menu, null,
                        modifier = Modifier.clickable {
                            scope.launch {
                                scaffoldState.drawerState.open()
                            }
                        }
                    )
                },
                elevation = 8.dp
            )
        },
        drawerShape = RoundedCornerShape(topEnd = 25.dp, bottomEnd = 25.dp),
        drawerContent = { Text("Bonjour le monde") },

        content = {

            Form()
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
fun Form() {


    Box(
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Bienvenue chez IIIIDAYS GROUP TECH",
            style = MaterialTheme.typography.h1,
            modifier = Modifier

        )
    }

    Column(
        horizontalAlignment =  Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var userNameState by remember { mutableStateOf(TextFieldValue()) }
        var passwordState by remember { mutableStateOf(TextFieldValue()) }
        var passwordVisibility by remember { mutableStateOf(false) }
        val context = LocalContext.current


        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = userNameState,
                onValueChange = { userNameState = it },
                placeholder = { Text("Nom d'utilisateur") },
                label = { Text("Nom d'utilisateur") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            TextField(
                value = passwordState,
                onValueChange = { passwordState = it },
                placeholder = { Text("Mot de passe") },
                label = { Text("Mot de passe") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),


                )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = {
                    showToast(context = context, userNameState.text)
                },

                ) {
                Text("Connexion")
            }
        }

    }
}

fun showToast(context: Context, text: String) {
    if (text.isEmpty()) {
        Toast.makeText(context, "Please enter something", Toast.LENGTH_SHORT).show()
    } else {
        Toast.makeText(context, "le contenu de votre champ ${text}", Toast.LENGTH_SHORT).show()
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
        var expanded by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier.clickable { expanded = !expanded }
        ) {
            Image(
                painter = painterResource(id = R.drawable.jetpack_compose_logo),
                contentDescription = "weights",
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