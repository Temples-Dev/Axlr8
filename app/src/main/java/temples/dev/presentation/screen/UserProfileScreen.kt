package temples.dev.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import temples.dev.R
import temples.dev.ui.theme.Axlr8Theme
import java.time.LocalDate


data class UserProfileDetails(
    val name: String,
    val mobile: String,
    val email: String,
    val dob: LocalDate,
    val address: String,
    val username: String,
    val divisionName: String,
)

val userDetail = UserProfileDetails(
    "test-name", "", "test@gmail.com",
    LocalDate.of(2023, 4, 4), "Ala ye", "codeGod", "SoCode"
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserProfileScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {
        val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = { Text("User Profile") }, scrollBehavior = scrollBehavior
                )
            },
            floatingActionButton = {
                IconButton(
                    onClick = { /*TODO*/ },

                    colors = IconButtonDefaults.filledIconButtonColors(
                        containerColor = MaterialTheme.colorScheme.secondaryContainer,
                        contentColor = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                ) {
                    Image(imageVector = Icons.Default.Edit, contentDescription = null)
                }
            },
            modifier = Modifier
                .fillMaxSize()
                .nestedScroll(scrollBehavior.nestedScrollConnection)
        ) { innerPadding ->
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {

                UserDetails(userProfileDetails = userDetail)

            }

        }
    }
}


@Composable
fun UserDetails(userProfileDetails: UserProfileDetails) {

    ImageComposable(
        imgResource = R.drawable.axlr8,
        userProfileDetails = userProfileDetails,
    )


    Column {
        Text(
            text = "Account Information",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp, modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        )
        UserProfileCard(
            icon = Icons.Default.Person,
            title = "Name",
            content = userProfileDetails.name
        )
        UserProfileCard(
            icon = Icons.Default.Call,
            title = "Mobile",
            content = userProfileDetails.mobile
        )
        UserProfileCard(
            icon = Icons.Default.Email,
            title = "Email",
            content = userProfileDetails.email
        )
        UserProfileCard(
            icon = Icons.Default.Home,
            title = "Address",
            content = userProfileDetails.address
        )
        UserProfileCard(
            icon = Icons.Default.DateRange,
            title = "D.O.B",
            content = userProfileDetails.dob.toString()
        )
    }

}


@Composable
fun UserProfileCard(icon: ImageVector, title: String, content: String) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),

        ) {
        Row(
            modifier = Modifier.padding(4.dp), horizontalArrangement = Arrangement.Center
        ) {
            Image(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .size(40.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,

                    )
                Text(
                    text = content,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(top = 8.dp),
                )
            }
        }

    }
    Divider(modifier = Modifier.padding(4.dp))

}

@Composable
fun ImageComposable(
    imgResource: Int,
    userProfileDetails: UserProfileDetails,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(bottom = 8.dp)
            .fillMaxWidth()
            .fillMaxHeight(.15f)
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = BackgroundSquareShapeWithLeftBottomCurved(85f)
            )

    ) {
        Image(
            painter = painterResource(id = imgResource),
            contentDescription = null,
            modifier = Modifier
                .size(70.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(16.dp))
        UserDetailSummary(userProfileDetails.username, userProfileDetails.divisionName)
    }
}

@Composable
fun UserDetailSummary(userName: String, divisionName: String) {
    Column {
        Text(
            text = userName,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onPrimary
        )

        Text(
            text = divisionName,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    Axlr8Theme {
        UserProfileScreen()
    }
}