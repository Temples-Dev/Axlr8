package temples.dev.presentation.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextFields(
    modifier: Modifier = Modifier,
    value: String = "",
    onValueChange: (String) -> Unit = {},
    placeholder: String = "",
    leadingIcon: ImageVector,
    singleLine: Boolean = true,
    shape: Shape = MaterialTheme.shapes.large,
) {
    TextField(
        value = value, onValueChange = onValueChange,
        shape = shape,
        singleLine = singleLine,
        leadingIcon =
        { Icon(imageVector = leadingIcon, contentDescription = null) },
        placeholder = {
            Text(text = placeholder)
        },
        modifier = modifier.fillMaxWidth(.85f).padding(4.dp),

        colors = TextFieldDefaults.textFieldColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )

    )
}