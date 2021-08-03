package com.example.weatherapp

import android.content.Context
import android.graphics.fonts.Font
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@ExperimentalAnimationApi
@Composable
fun MyScreenContent(names: List<String> = listOf("Android", "There")) {
    var scaffoldState =
        rememberScaffoldState(rememberDrawerState(initialValue = DrawerValue.Closed))
    var scope = rememberCoroutineScope()
    val showDialog =  remember { mutableStateOf(false)}
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
            if(showDialog.value){
                Dialog(showDialog = showDialog.value,
                onDismiss = {showDialog.value= false })

            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showDialog.value = true },
                contentColor = Color.White,
                backgroundColor = Color.Blue
            ) {
                Icon(Icons.Filled.Add, null,)
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
        style = MaterialTheme.typography.h2,

    )
}

@Composable
fun Form() {

    var scrollState = rememberScrollState()


    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier
            .fillMaxSize(1f)
            .padding(8.dp)

    ) {
        Text(
            text = " IIIIDAYS GROUP TECH",
            style = MaterialTheme.typography.h4
            )
    }

    Column(
        horizontalAlignment =  Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
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

@Composable
fun Dialog(
    showDialog:Boolean,
    onDismiss:()->Unit
) {
   if(showDialog){
       AlertDialog(
           onDismissRequest = onDismiss,
           confirmButton = {
               TextButton(onClick = { }) {
                   Text(text = "Oui")

               }
           },
           dismissButton = {
               TextButton(onClick = { /*TODO*/ }) {
                   Text("Non")

               }
           },
           title = {
               Text("Test des alerDialog dans Compose")

           },
           text = {
               Text("Bonjour Mr. Camara vous etes entrain de tester  les AlertDialog dans compose")
           }

       )
   }
}

