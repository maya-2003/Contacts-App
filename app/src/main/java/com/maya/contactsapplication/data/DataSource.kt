package com.maya.contactsapplication.data

import com.maya.contactsapplication.R
import com.maya.contactsapplication.model.Contact

class DataSource {
    fun getContactList(): List<Contact> {
        val contacts = mutableListOf<Contact>()
        contacts.add(
            Contact(
                img = R.drawable.auntie,
                name = R.string.auntie,
                phone = R.string.auntie_phone
            )
        )
        contacts.add(
            Contact(
                img = R.drawable.brother,
                name = R.string.brother,
                phone = R.string.brother_phone
            )
        )
        contacts.add(
            Contact(
                img = R.drawable.daughter,
                name = R.string.daughter,
                phone = R.string.daughter_phone
            )
        )
        contacts.add(
            Contact(
                img = R.drawable.friend_1,
                name = R.string.friend_1,
                phone = R.string.friend_1_phone
            )
        )
        contacts.add(
            Contact(
                img = R.drawable.friend_2,
                name = R.string.friend_2,
                phone = R.string.friend_2_phone
            )
        )
        contacts.add(
            Contact(
                img = R.drawable.grandfather,
                name = R.string.grandfather,
                phone = R.string.grandfather_phone
            )
        )
        contacts.add(
            Contact(
                img = R.drawable.granny,
                name = R.string.granny,
                phone = R.string.granny_phone
            )
        )
        contacts.add(
            Contact(
                img = R.drawable.neigbour,
                name = R.string.neighbour,
                phone = R.string.neighbour_phone
            )
        )
        contacts.add(
            Contact(
                img = R.drawable.sister,
                name = R.string.sister,
                phone = R.string.sister_phone
            )
        )
        contacts.add(
            Contact(
                img = R.drawable.son,
                name = R.string.son,
                phone = R.string.son_phone
            )
        )
        contacts.add(
            Contact(
                img = R.drawable.uncle,
                name = R.string.uncle,
                phone = R.string.uncle_phone
            )
        )
        return contacts

    }
}