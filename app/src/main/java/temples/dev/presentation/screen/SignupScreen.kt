package temples.dev.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material.icons.filled.Email
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
fun SignupScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,

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
            CustomTextFields(placeholder = "Email", leadingIcon = Icons.Filled.Email)
            Spacer(modifier = Modifier.height(20.dp))
            CustomTextFields(placeholder = "Password", leadingIcon = Icons.Filled.Lock)
            Spacer(modifier = Modifier.height(20.dp))
            CustomTextFields(placeholder = "Confirm Password", leadingIcon = Icons.Filled.Lock)

        }

        // Spacer(modifier = Modifier.height(10.dp))
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
                text = "Create Account",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimary,
                fontWeight = FontWeight.Bold

            )

        }
    }

}

@Composable
private fun ActionButton() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextButton(
            onClick = { /*TODO*/ },
            shape = MaterialTheme.shapes.extraLarge,
            colors = ButtonDefaults.buttonColors(),
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth(.85f)

        ) {
            Text(text = "Register")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Already a member?")

            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Login")
            }
        }
        Spacer(modifier = Modifier.height(4.dp))
    }

}

@Preview(showBackground = true)
@Composable
fun SignupScreenPreview() {
    Axlr8Theme {
        SignupScreen()
    }
}