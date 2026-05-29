package com.example.dependancyinjection_3

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material.icons.outlined.ThumbUp
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
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun ProfileUI(navController: NavController, viewModel: UserViewModel = hiltViewModel(), userId : Int) {

    val endpoint = viewModel.endpoint.collectAsState()
    val user = endpoint.value.firstOrNull { it.userId == userId }

    LaunchedEffect(userId) {
        viewModel.fetchEndpoint(userId)
    }

    Scaffold(topBar = {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color(0xFF0D1B2A)
            ),
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
            containerColor = Color(0xFF0D1B2A)
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
                .fillMaxWidth()
                .padding(paddingValues)
                .background(Color(0xFF0D1B2A))
        ) {

            Spacer(Modifier.height(50.dp))

            LazyColumn() {
                item {
                    ProfileList(user)
                }
            }
        }
    }
}

@Composable
fun ProfileList(user: Endpoint?) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(14.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(6.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF273248)),
            shape = RoundedCornerShape(14.dp)
        ) {

            Column(modifier = Modifier.padding(12.dp)) {

                Text(
                    "Post Details",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 46.sp,
                    style = TextStyle(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Color(0xFFEAFBFF),
                                Color(0xFF8BE9FF)
                            )
                        )
                    )
                )

                Spacer(Modifier.height(20.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Row(
                        modifier = Modifier,
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            Icons.Default.AddCircle, contentDescription = "",
                            tint = Color.White
                        )

                        Spacer(Modifier.width(12.dp))

                        Text(
                            "2\nmins\nago",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            lineHeight = 16.sp
                        )
                    }

                    Row(
                        modifier = Modifier,
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            Icons.Default.MailOutline, contentDescription = "",
                            tint = Color.White
                        )

                        Spacer(Modifier.width(12.dp))

                        Text(
                            "14\nComments",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            lineHeight = 16.sp
                        )
                    }

                    Row(
                        modifier = Modifier,
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            Icons.Default.Share, contentDescription = "",
                            tint = Color.White
                        )

                        Spacer(Modifier.width(12.dp))

                        Text(
                            "Share",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }

                Spacer(Modifier.height(30.dp))

                Text(
                    user?.title ?: "",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )


                Spacer(Modifier.height(10.dp))

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(),
                    elevation = CardDefaults.cardElevation(6.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF233554)),
                    shape = RoundedCornerShape(14.dp)
                ) {
                    Row(modifier = Modifier.fillMaxWidth()) {

                        VerticalDivider(
                            modifier = Modifier.height(150.dp),
                            thickness = 4.dp,
                            color = Color.White
                        )

                        Text(
                            "\"${user?.body ?: ""}\"",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            fontStyle = FontStyle.Italic,
                            color = Color.White,
                            modifier = Modifier.padding(16.dp)
                        )

                    }
                }

                Spacer(Modifier.height(20.dp))

                Text(
                    "User ID: ${user?.userId ?: ""}  |  Post ID: ${user?.id ?: ""}",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray
                )

                Spacer(Modifier.height(30.dp))

                Row(
                    modifier = Modifier
                ) {
                    Text(
                        "#Interdimentional",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.White,
                        modifier = Modifier
                            .border(1.dp, Color.Gray, shape = RoundedCornerShape(14.dp))
                            .padding(8.dp)
                    )


                    Spacer(Modifier.width(16.dp))

                    Text(
                        "#TechFeed",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFFD8B4FE),
                        modifier = Modifier
                            .border(1.dp, Color.Gray, shape = RoundedCornerShape(14.dp))
                            .padding(8.dp)
                    )
                }

                Spacer(Modifier.height(12.dp))
                Text(
                    "#PortalLogs",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFFFFF9C4),
                    modifier = Modifier
                        .border(1.dp, Color.Gray, shape = RoundedCornerShape(14.dp))
                        .padding(8.dp)
                )
            }
        }

        Spacer(Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Button(
                onClick = {},
                modifier = Modifier,
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {

                Box(
                    modifier = Modifier
                        .background(
                            brush = Brush.horizontalGradient
                                (
                                colors = listOf(
                                    Color(0xFFEFFFFF),
                                    Color(0xFFD7FDFC)
                                )
                            ),
                            shape = RoundedCornerShape(12.dp)
                        )
                        .padding(8.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    Row() {
                        Icon(
                            Icons.Outlined.ThumbUp, contentDescription = "",
                            tint = Color.Black
                        )

                        Spacer(Modifier.width(12.dp))

                        Text(
                            "BOOST POST",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }
                }
            }


            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                modifier = Modifier
                    .border(
                        width = 1.dp,
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Color(0xFFEFFFFF),
                                Color(0xFFD7FDFC)
                            )
                        ),
                        shape = RoundedCornerShape(12.dp)
                    )
            )
            {
                Row() {
                    Icon(
                        Icons.Outlined.Place, contentDescription = "",
                        tint = Color.Transparent,
                        modifier = Modifier
                            .drawWithCache {
                                val brush = Brush.horizontalGradient(
                                    colors = listOf(
                                        Color(0xFFEFFFFF),
                                        Color(0xFFD7FDFC)
                                    )
                                )

                                onDrawBehind {
                                    drawRoundRect(brush = brush)
                                }
                            }
                    )

                    Spacer(Modifier.width(12.dp))

                    Text(
                        "Save Date",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(
                            brush = Brush.horizontalGradient(
                                colors = listOf(
                                    Color(0xFFEFFFFF),
                                    Color(0xFFD7FDFC)
                                )
                            )
                        )
                    )
                }
            }

        }


        Spacer(modifier = Modifier.height(30.dp))

        Text(
            "Intercepted Comms",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(10.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(6.dp),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF273248)),

        ) {

            Column(modifier = Modifier.padding(16.dp)) {

                Row(Modifier,
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically) {

                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_foreground),
                        contentDescription = "",
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(Color.Gray)
                            .size(40.dp),
                        colorFilter = ColorFilter.tint(color = Color.White)
                    )

                    Spacer(Modifier.width(14.dp))

                    Text(
                        "Jay_Data",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }

                Spacer(Modifier.height(6.dp))

                Text("The syntax here is fascinating. Looks like an ancient protocol.",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray
                )
            }

        }

    }
}

