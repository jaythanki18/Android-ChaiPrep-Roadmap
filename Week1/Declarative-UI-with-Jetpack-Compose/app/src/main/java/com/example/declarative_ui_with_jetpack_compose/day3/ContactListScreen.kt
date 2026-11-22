package com.example.declarative_ui_with_jetpack_compose.day3

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.declarative_ui_with_jetpack_compose.day2.ChaiButton
import com.example.declarative_ui_with_jetpack_compose.ui.theme.DeclarativeUIwithJetpackComposeTheme

data class Contact(val id: Int, val name: String, val phone: String)

private val sampleNames = listOf("Aarav", "Diya", "Kabir", "Meera", "Rohan", "Isha", "Vikram", "Anaya")

private fun sampleContact(id: Int) = Contact(
    id = id,
    name = "${sampleNames[id % sampleNames.size]} $id",
    phone = "+91 98${(10000000 + id * 7919).toString().takeLast(8)}",
)

@Composable
fun ContactListScreen(modifier: Modifier = Modifier) {
    // Observable list: add/remove triggers recomposition of only the affected rows.
    val contacts = remember { mutableStateListOf<Contact>().apply { addAll((1..30).map(::sampleContact)) } }
    val nextId =remember { intArrayOf(31) }

    Column(modifier = modifier.fillMaxSize()) {
        Text("Favourites", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(16.dp, 8.dp))
        FavouritesRow(contacts.take(8))

        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            ChaiButton(text = "Add contact", onClick = { contacts.add(0, sampleContact(nextId[0]++)) })
            ChaiButton(
                text = "Remove first",
                onClick = { if (contacts.isNotEmpty()) contacts.removeAt(0) },
            )
        }

        LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)) {
            // key keeps each row's identity stable when items are inserted or removed,
            // so Compose reuses the right row instead of recomposing everything below.
            items(items = contacts, key = { it.id }) { contact ->
                ContactRow(contact)
            }
        }
    }
}

@Composable
private fun FavouritesRow(contacts: List<Contact>) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(items = contacts, key = { it.id }) { contact ->
            Avatar(contact.name)
        }
    }
}

@Composable
fun ContactRow(contact: Contact, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth().padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Avatar(contact.name)
        Column {
            Text(contact.name, style = MaterialTheme.typography.bodyLarge)
            Text(contact.phone, style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Composable
private fun Avatar(name: String) {
    Box(
        modifier = Modifier.size(44.dp).clip(CircleShape).background(MaterialTheme.colorScheme.primaryContainer),
        contentAlignment = Alignment.Center,
    ) {
        Text(name.first().toString(), color = MaterialTheme.colorScheme.onPrimaryContainer)
    }
}

@Preview(showBackground = true)
@Composable
private fun ContactListScreenPreview() {
    DeclarativeUIwithJetpackComposeTheme { ContactListScreen() }
}
