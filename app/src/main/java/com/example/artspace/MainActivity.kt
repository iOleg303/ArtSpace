package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                ArtSpacePreview()
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.TopCenter)
            .verticalScroll(rememberScrollState())
    ) {
        var ind by remember { mutableStateOf(1) }

        val imageResource = when(ind){
            1 -> R.drawable.photo_1
            2 -> R.drawable.photo_2
            3 -> R.drawable.photo_3
            else -> R.drawable.photo_4
        }
        val nameResource = when(ind){
            1 -> R.string.name_1
            2 -> R.string.name_2
            3 -> R.string.name_3
            else -> R.string.name_4
        }
        val descResource = when(ind){
            1 -> R.string.desc_1
            2 -> R.string.desc_2
            3 -> R.string.desc_3
            else -> R.string.desc_4
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = "",
                modifier = Modifier.padding(10.dp)
            )

            Text(text = stringResource(nameResource), fontSize = 50.sp, fontWeight = FontWeight.Bold)
            Text(text = stringResource(descResource),fontSize = 18.sp)

            Row (
                modifier = Modifier.padding(10.dp)
            ){
                Button(onClick = {
                    if(ind > 1) ind-- else ind = 4
                },
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth()
                        .weight(1F)
                ) { Text(stringResource(R.string.prev), fontSize = 20.sp) }
                Button(onClick = {
                    if(ind < 4) ind++ else ind = 1
                },
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth()
                        .weight(1F)
                ) { Text(stringResource(R.string.next), fontSize = 20.sp) }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}