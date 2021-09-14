package com.vijanaweusi.registrationapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.isEmpty
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        showHideBtn.setOnClickListener {
            if (showHideBtn.text.toString().equals("Show")) {
                edit_text_create_password.transformationMethod =
                    HideReturnsTransformationMethod.getInstance()
                showHideBtn.text = "Hide"
            } else {
                edit_text_create_password.transformationMethod =
                    PasswordTransformationMethod.getInstance()
                showHideBtn.text = "Show"
            }
        }


        button_register.setOnClickListener {
           if (edit_text_contact_name.text.toString().isEmpty()) {
               Toast.makeText(this, "Please fill out form completely", Toast.LENGTH_SHORT).show()

               if (edit_text_email.text.toString().isEmpty())
                   Toast.makeText(this, "Please fill out form completely", Toast.LENGTH_SHORT).show()

               if (edit_text_phone_number.text.toString().isEmpty())
                   Toast.makeText(this, "Please fill out form completely", Toast.LENGTH_SHORT).show()

               if (edit_text_create_username.text.toString().isEmpty())
                   Toast.makeText(this, "Please fill out form completely", Toast.LENGTH_SHORT).show()

               if (edit_text_create_password.text.toString().isEmpty())
                   Toast.makeText(this, "Please fill out form completely", Toast.LENGTH_SHORT).show()

           }else{
               onPreviewClicked()
           }

        }

        val spinnerValues: Array<String> = arrayOf("","Jr.", "Sr.", "II", "III", "IV")
        val spinnerAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerValues)
        spinner_suffix.adapter = spinnerAdapter

    }
        private fun onPreviewClicked () {

        val message = Message(

            edit_text_contact_name.text.toString(),
            edit_text_phone_number.text.toString(),
            edit_text_email.text.toString(),
            edit_text_create_username.text.toString(),
            edit_text_create_password.text.toString(),
            spinner_suffix.selectedItem?.toString()
        )

        val previewActivityIntent = Intent(this, PreviewActivity::class.java)
        previewActivityIntent.putExtra("Message", message)

        startActivity(previewActivityIntent)

    }
}
