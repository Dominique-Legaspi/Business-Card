package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
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
                        name = "Dominique Legaspi",
                        title = "Software Engineer",
                        phoneNumber = "111-111-1111",
                        email = "test@email.com",
                        social = "@YoMama"
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(name: String, title: String, phoneNumber: String, email: String, social: String, modifier: Modifier = Modifier) {
    Column (modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally){
            BusinessInfo(name = name, title = title)
            Spacer(modifier = Modifier.padding(100.dp))
            BusinessBottom(phoneNumber = phoneNumber, email = email, social = social)
            Spacer(modifier = Modifier.padding(30.dp))
    }

}

@Composable
fun BusinessInfo(name: String, title: String, modifier: Modifier = Modifier) {
    Column (modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        // Image()
        Text(name,
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.padding(5.dp))
        Text(title,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
@Composable
fun BusinessBottom(phoneNumber: String, email: String, social: String, modifier: Modifier = Modifier){
    Column (modifier = modifier,
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.Start) {
            Text(text = phoneNumber)
            Spacer(modifier = Modifier.padding(5.dp))
            Text(text = email)
            Spacer(modifier = Modifier.padding(5.dp))
            Text(text = social)
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessInfoPreview() {
    BusinessCard(
        name = "Dominique Legaspi",
        title = "Software Engineer",
        phoneNumber = "111-111-1111",
        email = "test@email.com",
        social = "@YoMama"
    )
}

