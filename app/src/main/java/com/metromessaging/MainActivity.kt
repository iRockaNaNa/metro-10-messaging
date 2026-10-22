package com.metromessaging

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Metro Messaging — a Windows 10 Mobile-style SMS app for Android.
 *
 * Scaffold state: the conversation list renders sample data in the
 * Windows 10 Mobile Messaging layout (big lowercase title, square contact
 * initial tiles, accent-colored unread states). Real threads arrive with
 * the Telephony provider milestone on the roadmap.
 */

// The classic Windows 10 Mobile accent. Will sync with the Metro Launcher
// accent palette once the two apps share settings.
private val MetroAccent = Color(0xFF0078D7)
private val MetroBackground = Color(0xFF000000)
private val MetroText = Color(0xFFFFFFFF)
private val MetroMutedText = Color(0xFF9E9E9E)
private val MetroReadTile = Color(0xFF3B3B3B)

private data class SampleConversation(
    val contact: String,
    val snippet: String,
    val time: String,
    val unread: Boolean
)

private val SampleConversations = listOf(
    SampleConversation("Maria", "See you at dinner on Friday!", "9:41 AM", true),
    SampleConversation("Dad", "Call me when you get this", "Yesterday", true),
    SampleConversation("Xbox", "Your code is ready to redeem", "Yesterday", false),
    SampleConversation("Best Buy", "Your order has shipped", "Tue", false)
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(colorScheme = darkColorScheme(primary = MetroAccent)) {
                ConversationList()
            }
        }
    }
}

@Composable
private fun ConversationList() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MetroBackground)
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "messaging",
            color = MetroText,
            fontSize = 42.sp,
            fontWeight = FontWeight.Light,
            modifier = Modifier.padding(top = 24.dp, bottom = 16.dp)
        )
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(SampleConversations) { conversation ->
                ConversationRow(conversation)
            }
        }
    }
}

@Composable
private fun ConversationRow(conversation: SampleConversation) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Square contact-initial tile, Windows Phone People style.
        Box(
            modifier = Modifier
                .size(52.dp)
                .background(if (conversation.unread) MetroAccent else MetroReadTile),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = conversation.contact.first().toString(),
                color = MetroText,
                fontSize = 22.sp,
                fontWeight = FontWeight.Light
            )
        }
        Spacer(modifier = Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = conversation.contact,
                color = MetroText,
                fontSize = 17.sp,
                fontWeight = if (conversation.unread) FontWeight.SemiBold else FontWeight.Normal,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = conversation.snippet,
                color = MetroMutedText,
                fontSize = 14.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        Text(
            text = conversation.time,
            color = if (conversation.unread) MetroAccent else MetroMutedText,
            fontSize = 12.sp,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}
