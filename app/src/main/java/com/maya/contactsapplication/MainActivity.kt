package com.maya.contactsapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import com.maya.contactsapplication.data.DataSource
import com.maya.contactsapplication.model.Contact
import com.maya.contactsapplication.ui.theme.ContactsApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContactsApplicationTheme {
                ContactsApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactsApp() {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Contacts App",
                    )
                },
                actions = {
                    IconButton(onClick = {
                        val i = Intent(Intent.ACTION_DIAL, "tel:+201014557754".toUri())
                        context.startActivity(i)
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_home),
                            contentDescription = "Home icon"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color.DarkGray
                ),
            )
        },
    ) { innerPadding ->
        ContactsList(DataSource().getContactList(),modifier = Modifier.padding(innerPadding))
    }
}


@Composable
fun ContactsList(contacts: List<Contact>,modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp),
        modifier = modifier.padding(),
    ) {
        items(contacts.size) { position ->
            ContactListItem(contact = contacts[position])
        }
    }
}


@Composable
fun ContactListItem(contact: Contact) {
    val context = LocalContext.current
    val phone = stringResource(id = contact.phone)
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.LightGray),
        shape = RoundedCornerShape(0.dp),
        onClick = {
            val i = Intent(Intent.ACTION_DIAL, "tel:$phone".toUri())
            context.startActivity(i)
        }
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = contact.img),
                modifier = Modifier.height(150.dp),
                contentScale = ContentScale.Crop,
                contentDescription = "Contact image",

            )
            Text(
                text = stringResource(id = contact.name),
                modifier = Modifier.padding(top = 8.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
            SelectionContainer {
                Text(
                    text = stringResource(id = contact.phone),
                    modifier = Modifier.padding(vertical = 4.dp),
                    fontSize = 12.sp,
                    color = Color.DarkGray,
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun ContactsAppPreview() {
    ContactsApplicationTheme {
        ContactsApp()
    }
}