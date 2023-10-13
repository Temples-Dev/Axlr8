package temples.dev.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import temples.dev.R
import temples.dev.ui.theme.Axlr8Theme

@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Banner()
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            CustomTextFields(placeholder = "Username", leadingIcon = Icons.Filled.Person)
            Spacer(modifier = Modifier.height(20.dp))
            CustomTextFields(placeholder = "Password", leadingIcon = Icons.Filled.Lock)
        }

        ActionButton()


    }
}


@Composable
private fun Banner() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(.35f), Alignment.TopEnd

    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = BackgroundSquareShapeWithLeftBottomCurved(200f)
                )

                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.axlr8),
                contentDescription = "Logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                text = "Welcome Back!",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimary
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Login to continue",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    }

}





@Composable
private fun ActionButton() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextButton(
            onClick = { /*TODO*/ },
            shape = MaterialTheme.shapes.extraLarge,
            colors = ButtonDefaults.buttonColors(),
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .width(280.dp)

        ) {
            Text(text = "Login")
        }
        Spacer(modifier = Modifier.height(60.dp))
        Column(
            modifier = Modifier.padding(horizontal = 40.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Don't have an account?")

            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Register")
            }
        }
        Spacer(modifier = Modifier.height(5.dp))
    }

}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    Axlr8Theme {
        LoginScreen()
    }
}