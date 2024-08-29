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
        ContactsList(modifier = Modifier.padding(innerPadding))
    }
}


@Composable
fun ContactsList(modifier: Modifier = Modifier) {
    val contacts = listOf(
        Contact(
            img = R.drawable.auntie,
            name = R.string.auntie,
            phone = R.string.auntie_phone
        ),
        Contact(
            img = R.drawable.brother,
            name = R.string.brother,
            phone = R.string.brother_phone
        ),
        Contact(
            img = R.drawable.daughter,
            name = R.string.daughter,
            phone = R.string.daughter_phone
        ),
        Contact(
            img = R.drawable.friend_1,
            name = R.string.friend_1,
            phone = R.string.friend_1_phone
        ),
        Contact(
            img = R.drawable.friend_2,
            name = R.string.friend_2,
            phone = R.string.friend_2_phone
        ),
        Contact(
            img = R.drawable.grandfather,
            name = R.string.grandfather,
            phone = R.string.grandfather_phone
        ),
        Contact(
            img = R.drawable.granny,
            name = R.string.granny,
            phone = R.string.granny_phone
        ),
        Contact(
            img = R.drawable.neigbour,
            name = R.string.neighbour,
            phone = R.string.neighbour_phone
        ),
        Contact(
            img = R.drawable.sister,
            name = R.string.sister,
            phone = R.string.sister_phone
        ),
        Contact(
            img = R.drawable.son,
            name = R.string.son,
            phone = R.string.son_phone
        ),
        Contact(
            img = R.drawable.uncle,
            name = R.string.uncle,
            phone = R.string.uncle_phone
        )
    )
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
                contentDescription = stringResource(id = contact.name),

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