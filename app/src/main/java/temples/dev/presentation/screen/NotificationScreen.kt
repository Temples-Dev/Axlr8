package temples.dev.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import temples.dev.ui.theme.Axlr8Theme

data class Notification(
    val title: String,
    val content: String
)

val notifications = listOf(
    Notification(
        "Notification 1",
        "This is the content of notification 1 This is the content of notification 1"
    ),
    Notification("Notification 2", "This is the content of notification 2"),
    Notification("Notification 3", "This is the content of notification 3"),
    Notification("Notification 4", "This is the content of notification  4"),
    Notification("Notification 5", "This is the content of notification  5"),
    Notification("Notification 6", "This is the content of notification  6"),
    Notification("Notification 7", "This is the content of notification  7"),
    Notification("Notification 8", "This is the content of notification  8"),
    Notification("Notification 9", "This is the content of notification  9"),
    Notification("Notification 10", "This is the content of notification 10 "),
)

@Composable
fun NotificationScreen() {

    NotificationList(notifications = notifications)

}

@Composable
fun NotificationList(notifications: List<Notification>) {

    LazyColumn {
        items(notifications) { notification ->
            NotificationItem(notification = notification)
        }
    }


}


@Composable
fun NotificationItem(notification: Notification) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = notification.title,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,

                )
            Text(
                text = notification.content,
                fontSize = 14.sp,
                modifier = Modifier.padding(top = 8.dp),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
            Spacer(modifier = Modifier.padding(4.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotificationPreview() {
    Axlr8Theme {
        NotificationScreen()
    }

}