package com.maya.contactsapplication.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Contact(@DrawableRes val img: Int, @StringRes val name:Int, @StringRes val phone:Int)
