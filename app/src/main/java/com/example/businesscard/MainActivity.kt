package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    BusinessCard(
                        name = "Phuong Nguyen",
                        title = "Professor at CSULB",
                        phoneNumber = "111-111-1111",
                        email = "test@email.com",
                        social = "@YoMama"
                    )
                }
            }
        }
    }
}

// Full Business Card
@Composable
fun BusinessCard(
    name: String,
    title: String,
    phoneNumber: String,
    email: String,
    social: String,
    modifier: Modifier = Modifier
) {
    // Background image with opacity
    Box(modifier) {
        Image(
            painter = painterResource(R.drawable.pyramid_bg),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        // Set white opacity
        Surface(
            color = Color.White.copy(alpha = 0.65f),
            modifier = Modifier.fillMaxSize()
        ) {
            // Arrange Composable into columns
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                BusinessPhoto()
                Spacer(modifier = Modifier.padding(10.dp))
                BusinessInfo(name = name, title = title)
                Spacer(modifier = Modifier.padding(70.dp))
                BusinessBottom(phoneNumber = phoneNumber, email = email, social = social)
                Spacer(modifier = Modifier.padding(30.dp))
            }
        }
    }
}

// Profile image
@Composable
fun BusinessPhoto() {
    Image(
        painter = painterResource(R.drawable.phuong),
        contentDescription = "Profile image",
        modifier = Modifier
            .size(240.dp)
            .clip(CircleShape)
    )
}

// Business Card information
@Composable
fun BusinessInfo(name: String, title: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // full name parameter
        Text(
            name,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.padding(5.dp))
        // title parameter
        Text(
            title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )
    }
}

// Contact information
@Composable
fun BusinessBottom(
    phoneNumber: String,
    email: String,
    social: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.Start
    ) {
        // Phone Number
        Row {
            Icon(
                painter = painterResource(id = R.drawable.phone_icon),
                contentDescription = "phone number",
                modifier = Modifier.size(30.dp)
            )
            Spacer(modifier = Modifier.padding(horizontal = 5.dp))
            Text(
                text = phoneNumber,
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
        Spacer(modifier = Modifier.padding(5.dp))
        // Email
        Row {
            Icon(
                painter = painterResource(id = R.drawable.email_icon),
                contentDescription = "email",
                modifier = Modifier.size(30.dp)
            )
            Spacer(modifier = Modifier.padding(horizontal = 5.dp))
            Text(
                text = email,
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
        Spacer(modifier = Modifier.padding(5.dp))
        // LinkedIn
        Row {
            Icon(
                painter = painterResource(id = R.drawable.linkedin_icon),
                contentDescription = "linkedin",
                modifier = Modifier.size(30.dp)
            )
            Spacer(modifier = Modifier.padding(horizontal = 5.dp))
            Text(
                text = social,
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessInfoPreview() {
    BusinessCard(
        name = "Phuong Nguyen",
        title = "Professor of CSULB",
        phoneNumber = "111-111-1111",
        email = "test@email.com",
        social = "@YoMama"
    )
}

