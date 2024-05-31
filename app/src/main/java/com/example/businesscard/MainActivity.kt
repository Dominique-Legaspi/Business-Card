package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface (){

                }
            }
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
            Text(title,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun BusinessInfoPreview() {
        BusinessInfo("Dominique Legaspi", "Software Engineer")
    }

}
