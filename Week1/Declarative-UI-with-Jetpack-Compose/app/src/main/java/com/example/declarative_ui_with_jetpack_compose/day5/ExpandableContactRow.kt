package com.example.declarative_ui_with_jetpack_compose.day5

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.declarative_ui_with_jetpack_compose.day3.Contact
import com.example.declarative_ui_with_jetpack_compose.day3.ContactRow
import com.example.declarative_ui_with_jetpack_compose.ui.theme.DeclarativeUIwithJetpackComposeTheme

// Tap a row to reveal extra details.
// AnimatedVisibility animates the details in/out (fade + expand by default);
// animateContentSize smooths the row's own height change as the content appears.
@Composable
fun ExpandableContactRow(contact: Contact, modifier: Modifier = Modifier) {
    // rememberSaveable keeps the expanded state across rotation (and scrolling off-screen with keys).
    var expanded by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .animateContentSize()
            .clickable { expanded = !expanded },
    ) {
        ContactRow(contact)
        AnimatedVisibility(visible = expanded) {
            Column(modifier = Modifier.padding(start = 56.dp, bottom = 8.dp)) {
                Text("Email: ${contact.name.substringBefore(' ').lowercase()}@chaiprep.dev", style = MaterialTheme.typography.bodySmall)
                Text("Last chai together: yesterday", style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}

// Crossfade swaps between two UI states, keyed by the target state value.
@Composable
fun ContactsCrossfade(
    isEmpty: Boolean,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Crossfade(targetState = isEmpty, modifier = modifier, label = "contacts-empty-crossfade") { empty ->
        if (empty) {
            Column(
                modifier = Modifier.fillMaxWidth().padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text("No contacts yet", style = MaterialTheme.typography.titleMedium)
                Text("Tap Add contact to brew some.", style = MaterialTheme.typography.bodySmall)
            }
        } else {
            content()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ExpandableContactRowPreview() {
    DeclarativeUIwithJetpackComposeTheme {
        ExpandableContactRow(Contact(1, "Diya 1", "+91 9800000000"))
    }
}
