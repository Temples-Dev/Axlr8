package temples.dev.data


data class UserProfileModel(
    val name: String,
    val email: String,
    val profilePictureUrl: String,
    val interests: List<String>,
    val attendedEvents: List<Event>
)

data class Event(
    val eventName: String,
    val eventDate: String,
    val eventLocation: String
)

val profileSample = listOf(
    UserProfileModel(
        name = "Shelemiah",
        email = "sheley@gmail.com",
        profilePictureUrl = "R.Resource",
        interests = listOf("coding,android"),
        attendedEvents = listOf()
    ),
    UserProfileModel(
        name = "Shelemiah",
        email = "sheley@gmail.com",
        profilePictureUrl = "R.Resource",
        interests = listOf("coding,android"),
        attendedEvents = listOf()
    ),
    UserProfileModel(
        name = "Shelemiah",
        email = "sheley@gmail.com",
        profilePictureUrl = "R.Resource",
        interests = listOf("coding,android"),
        attendedEvents = listOf()
    )
)
