package com.vijanaweusi.registrationapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_preview.*

class PreviewActivity : AppCompatActivity() {

    private lateinit var message: Message
    private lateinit var messagePreviewText: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)
        displayMessage()
        setUpButton()
    }

    private fun displayMessage() {

        message = intent.getSerializableExtra("Message") as Message
        messagePreviewText = """
            
            ${message.contactName} ${message.spinnerSuffix}
            
            ${message.emailAddress}
            
            ${message.phoneNumber}
            
            ${message.createUsername}
            
            ${message.createPassword}
            
        """.trimIndent()

        text_view_preview_message.text = messagePreviewText

    }

    private fun setUpButton() {

        button_submit.setOnClickListener() {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("smsto: ${message.phoneNumber}")
                putExtra("sms_body", messagePreviewText)
            }
            startActivity(intent)

        }


    }
}