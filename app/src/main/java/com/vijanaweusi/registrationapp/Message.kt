package com.vijanaweusi.registrationapp

import java.io.Serializable

class Message(

    val contactName: String,
    val phoneNumber: String,
    val emailAddress: String,
    val createUsername: String,
    val createPassword: String,
    val spinnerSuffix: String?,
): Serializable