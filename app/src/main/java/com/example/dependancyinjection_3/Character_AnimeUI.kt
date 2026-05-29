@file:Suppress("INFERRED_TYPE_VARIABLE_INTO_EMPTY_INTERSECTION_WARNING",
    "TYPE_INTERSECTION_AS_REIFIED_WARNING"
)

package com.example.dependancyinjection_3

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Character_AnimeUI(viewModel: UserViewModel = hiltViewModel(), navController: NavHostController) {

    val character = viewModel.character.collectAsLazyPagingItems()


    Scaffold(topBar = {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Black
            ),
            title = {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.Black),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        Icons.Default.List, contentDescription = "",
                        tint = Color.White
                    )

                    Spacer(modifier = Modifier.width(12.dp))

                    Text(
                        "PORTAL",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.End
                    ) {

                        Image(
                            painter = painterResource(R.drawable.ic_launcher_foreground),
                            contentDescription = "",
                            modifier = Modifier
                                .clip(CircleShape)
                                .background(color = Color.Gray)
                        )
                    }
                }
            }
        )
    }, bottomBar = {
        BottomAppBar(
            containerColor = Color.Black
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(30.dp))
                        .background(Color(0xFF6200EE))
                        .padding(horizontal = 18.dp, vertical = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Icon(
                        Icons.Outlined.AddCircle, contentDescription = "",
                        tint = Color.White
                    )

                    Text(
                        "Characters",
                        fontSize = 14.sp,
                        color = Color.White
                    )
                }

                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Icon(
                        Icons.Outlined.MailOutline, contentDescription = "",
                        tint = Color.White
                    )

                    Text(
                        "Posts",
                        fontSize = 14.sp,
                        color = Color.White
                    )
                }

                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Icon(
                        Icons.Outlined.AccountCircle, contentDescription = "",
                        tint = Color.White
                    )

                    Text(
                        "Profile",
                        fontSize = 14.sp,
                        color = Color.White
                    )
                }
            }
        }
    }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(paddingValues)
        ) {

            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                // Header section as the first item
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Spacer(Modifier.height(30.dp))

                        Text(
                            "Character \nArchive",
                            fontSize = 50.sp,
                            fontWeight = FontWeight.Bold,
                            lineHeight = 46.sp,
                            style = TextStyle(brush = Brush.horizontalGradient(
                                colors = listOf(
                                    Color(0xFFEAFBFF),
                                    Color(0xFF8BE9FF)
                                )
                            ))
                        )

                        Spacer(Modifier.height(2.dp))

                        Text(
                            "Accessing interdimensional Intelligence.\nBrowsing current sentient life-forms across the multiverse.",
                            fontSize = 18.sp,
                            color = Color.Gray
                        )

                        Spacer(Modifier.height(25.dp))

                        Button(
                            onClick = {
                                navController.navigate("Screen2")
                            },
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00D9FF)),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(12.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    "POSTS",
                                    fontSize = 18.sp,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold
                                )

                                Spacer(Modifier.width(12.dp))

                                Icon(
                                    Icons.Outlined.MailOutline, contentDescription = "",
                                    tint = Color.Black
                                )
                            }
                        }

                        Spacer(Modifier.height(20.dp))
                    }
                }

                // List of characters
                items(character.itemCount) { index ->
                    character[index]?.let {
                        CharacterCard(character = it, navController = navController)
                    }
                }
            }
        }
    }
}

@Composable
fun CharacterCard(character: Result, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            AsyncImage(
                model = character.image,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .background(Color.LightGray),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF0A192F))
                    .padding(10.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        "ID: ",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray
                    )

                    Text(
                        "${character.id}",
                        fontSize = 16.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Icon(
                            Icons.Default.Add, contentDescription = "",
                            tint = Color(0xFF00D9FF)
                        )
                    }
                }

                Spacer(Modifier.height(10.dp))

                Text(
                    character.name,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.clickable {
                        // Click action if any

                    }
                )

                Spacer(Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Column(
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text(
                            "GENDER",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Gray
                        )

                        Text(
                            character.gender,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }

                    Spacer(Modifier.width(20.dp))

                    Column(
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text(
                            "TYPE",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Gray
                        )

                        Text(
                            character.type.ifEmpty { "Unknown" },
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}

