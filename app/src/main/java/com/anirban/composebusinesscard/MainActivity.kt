package com.anirban.composebusinesscard

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anirban.composebusinesscard.ui.theme.ComposeBusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BuildImage()
                }
            }
        }
    }
}

// This function draws the Android Logo in the Center of the Screen and called the later Functions
@Composable
fun BuildImage() {

    // This column is Centered horizontally and vertically and it keep the Android Logo and my name heading
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
            ) {

        // Android Image Logo
        Image(
            modifier = Modifier
                .height(150.dp)
                .width(150.dp),
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = null ,
            contentScale = ContentScale.Fit
        )

        // My name Heading
        Text(
            text = stringResource(R.string.name),
            fontSize = 36.sp
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Android developer Work related Heading
        Text(
            text = stringResource(R.string.android_developer),
            color = MaterialTheme.colors.secondary
        )
    }

    // Calling the Build Cards function which draws the remaining card UI
    BuildCards()
}

// This Function draws all the Cards which will be show the various details of the business card
@Composable
fun BuildCards(){

    // Making a column to arrange the details vertically
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 54.dp)
            .wrapContentHeight(align = Alignment.Bottom)
            ){

        // Calling each function to draw each row with the passes drawable and string Resource
        SingleCardRow(text = stringResource(R.string.ph_number) , drawable = R.drawable.baseline_local_phone_24)
        SingleCardRow(text = stringResource(R.string.work), drawable = R.drawable.baseline_share_24)
        SingleCardRow(text = stringResource(R.string.email), drawable = R.drawable.baseline_mail_24)
    }
}

// This function draws single card row according to the Passes UI elements
@Composable
fun SingleCardRow(text : String , drawable : Int){

    // A divider given at the Start of the Row to separate the different cards
    Divider(modifier = Modifier
        .fillMaxWidth(),
        color = MaterialTheme.colors.secondary ,
        thickness = .5.dp
    )

    // Space between the Divider and the actual Card Row
    Spacer(
        modifier = Modifier.height(4.dp)
    )

    // The rows contain the Icon and the details
    Row (
        modifier = Modifier
            .padding(start = 54.dp , end = 54.dp)
            ){

        // Icon drawn which is passes in the function body
        Icon(
            painterResource(id = drawable),
            tint = MaterialTheme.colors.secondary,
            contentDescription = null
        )

        // Space between the Icon and the Text details
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = text)
    }
    Spacer(modifier = Modifier.height(16.dp))
}

// This is the Preview Function which previews the UI
@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
fun DefaultPreview() {
    ComposeBusinessCardTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            BuildImage()
        }
    }
}