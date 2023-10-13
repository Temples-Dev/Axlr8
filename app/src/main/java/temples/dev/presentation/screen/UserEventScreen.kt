package temples.dev.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import temples.dev.R
import temples.dev.ui.theme.Axlr8Theme


data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector,
    val hasMessage: Boolean,
    val badgeCount: Int? = null
)

val bottomItems = listOf(
    BottomNavigationItem(
        title = "Home",
        selectedIcon = Icons.Filled.Home,
        unSelectedIcon = Icons.Outlined.Home,
        hasMessage = false
    ),
    BottomNavigationItem(
        title = "Notification",
        selectedIcon = Icons.Filled.Notifications,
        unSelectedIcon = Icons.Outlined.Notifications,
        hasMessage = false,
        badgeCount = 10
    ),
    BottomNavigationItem(
        title = "Profile",
        selectedIcon = Icons.Filled.Person,
        unSelectedIcon = Icons.Outlined.Person,
        hasMessage = false
    ),
)


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun UserEventScreen() {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
        var selectedItemIndex: Int by rememberSaveable {
            mutableStateOf(0)
        }
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = { Text("Upcoming Events") },
                    actions = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = null
                            )
                        }
                    },
                    scrollBehavior = scrollBehavior
                )
            },
            bottomBar = {
                NavigationBar {
                    bottomItems.forEachIndexed { index, navigationItem ->
                        NavigationBarItem(
                            selected = selectedItemIndex == index,
                            onClick = {
                                selectedItemIndex = index
                            },
                            icon = {
                                BadgedBox(badge = {
                                    if (navigationItem.badgeCount != null) {
                                        Badge {
                                            Text(text = navigationItem.badgeCount.toString())
                                        }
                                    } else if (navigationItem.hasMessage) {
                                        Badge()
                                    }
                                }) {
                                    Icon(
                                        imageVector = if (index == selectedItemIndex) {
                                            navigationItem.selectedIcon
                                        } else {
                                            navigationItem.unSelectedIcon
                                        }, contentDescription = navigationItem.title
                                    )
                                }
                            },
                            label = {
                                Text(text = navigationItem.title)
                            },
                            alwaysShowLabel = false,

                            )
                    }
                }
            },
            modifier = Modifier
                .fillMaxSize()
                .nestedScroll(scrollBehavior.nestedScrollConnection)
        ) { innerPadding ->

            LazyColumn(
                Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                items(10) {

                    EventCard(
                        name = "New Recruit",
                        host = "SoCode",
                        date = "2023-09-15",
                        venue = "Octagon Main",
                        imageUrl = R.drawable.axlr8
                    )
                }
            }

        }
    }

}


@Composable
private fun EventCard(
    name: String,
    host: String,
    date: String,
    venue: String,
    imageUrl: Int,
    onLearnMoreClick: () -> Unit = {},
    onLearnRsvpClick: () -> Unit = {}
) {
    Card(
        modifier = Modifier
            .height(400.dp)
            .fillMaxWidth(.9f)
            .padding(10.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Top
        ) {
            Image(
                painter = painterResource(id = imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxHeight(0.45f)
                    .fillMaxWidth()
                    .clip(BackgroundSquareShapeWithLeftBottomCurved(100f)),
                contentScale = ContentScale.FillBounds

            )
            Column(
                modifier = Modifier.padding(
                    10.dp
                )
            ) {
                Text(
                    text = "Name: $name", style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.padding(4.dp))

                Text(
                    text = "Host: $host", style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.padding(4.dp))
                Text(
                    text = "Date: $date", style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.padding(4.dp))
                Text(
                    text = "Venue: $venue", style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    OutlinedButton(
                        onClick = onLearnMoreClick,
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 8.dp)
                    ) {
                        Text(text = "Learn More")
                    }

                    Button(
                        onClick = onLearnRsvpClick,
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 8.dp)
                    ) {
                        Text(text = "RSVP")
                    }
                }
            }

        }


    }
}


@Preview(showBackground = true)
@Composable
fun UserPreview() {
    Axlr8Theme {
        UserEventScreen()
    }
}