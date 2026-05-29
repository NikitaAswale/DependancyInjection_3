package com.example.dependancyinjection_3

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostUI(
    viewModel: UserViewModel = hiltViewModel(),
    navController: NavHostController,
) {

    val user = viewModel.users.collectAsState()

    LaunchedEffect(20) {
        viewModel.fetchUsers()

    }

    Scaffold(topBar = {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF0A1020)),
            title = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
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
            containerColor = Color(0xFF0A1020)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column(
                    modifier = Modifier,
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
                    modifier = Modifier
                        .clip(RoundedCornerShape(30.dp))
                        .background(Color(0xFF6200EE))
                        .padding(horizontal = 18.dp, vertical = 8.dp),
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
                .background(Color(0xFF050B1A))
        ) {


            Spacer(Modifier.height(10.dp))

            Text(
                "COMMUNITY FEED",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(start = 14.dp)
            )

            Row(
                modifier = Modifier.padding(start = 14.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Transmitting from Dimension C-137",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray
                )

                Spacer(Modifier.weight(1f))

                Text(
                    "3 NEW POSTS",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color(0xFF6200EE))
                        .padding(horizontal = 16.dp, vertical = 2.dp)
                )
            }

            Spacer(Modifier.height(10.dp))
        }

            LazyColumn(modifier = Modifier.padding(paddingValues)) {

            items(user.value){ post ->
                UserPost(post = post, navController)

            }

        }
    }
}

@Composable
fun UserPost(post: Posts, navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF050B1A))
    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            elevation = CardDefaults.cardElevation(4.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF0B132B)),
            shape = RoundedCornerShape(14.dp)
        ) {

            Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp)) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_foreground),
                        contentDescription = "",
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .background(color = Color.Gray)
                            .size(40.dp)
                            .clickable{navController.navigate("Screen3/${post.userId}")}
                    )

                    Column(
                        modifier = Modifier.padding(start = 4.dp),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {

                        Row() {
                            Text(
                                "User ID: ",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )

                            Text(
                                "${post.userId}",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }

                        Row() {
                            Text(
                                "ID: ",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Gray
                            )

                            Text(
                                "${post.id}",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Gray
                            )
                        }
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {

                        Text(
                            "PRIORITY",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Gray,
                            modifier = Modifier
                                .clip(shape = RectangleShape)
                                .border(1.dp, color = Color.Gray)
                                .padding(6.dp)
                        )
                    }

                }

                Spacer(Modifier.height(20.dp))

                Text(
                    post.body,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Start
                )

                Spacer(Modifier.height(12.dp))
                Text(
                    post.title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray,
                    textAlign = TextAlign.Start
                )

                Spacer(Modifier.height(30.dp))

                Row() {

                    Icon(
                        Icons.Outlined.FavoriteBorder, contentDescription = "",
                        tint = Color.Gray
                    )

                    Spacer(Modifier.width(4.dp))

                    Text(
                        "124",
                        fontSize = 16.sp,
                        color = Color.Gray
                    )

                    Spacer(Modifier.width(20.dp))

                    Icon(
                        Icons.Outlined.MailOutline, contentDescription = "",
                        tint = Color.Gray
                    )

                    Spacer(Modifier.width(4.dp))

                    Text(
                        "42",
                        fontSize = 16.sp,
                        color = Color.Gray
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Icon(
                            Icons.Outlined.Share, contentDescription = "",
                            tint = Color.Gray,
                        )
                    }

                }
            }
        }
    }
}

