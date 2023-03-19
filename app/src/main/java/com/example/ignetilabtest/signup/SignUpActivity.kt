package com.example.ignetilabtest.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ignetilabtest.MainActivity
import com.example.ignetilabtest.R
import com.example.ignetilabtest.databinding.ActivitySignUpActiviityBinding
import com.example.ignetilabtest.login.LoginActivity
import com.example.ignetilabtest.utils.AppSettings
import java.util.regex.Pattern

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignUpActiviityBinding
    val EMAIL_ADDRESS_PATTERN = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpActiviityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.signUpButton.setOnClickListener {
            var name = binding.edtName.text.toString()
            var phone = binding.edtPhone.text.toString()
            var email = binding.edtEmail.text.toString()
            var password = binding.edtPassword.text.toString()

            if (name.isEmpty()) {
                binding.edtName.setError("please enter name")
            } else if (phone.isEmpty()) {
                binding.edtPhone.setError("please enter phone number")
            } else if (phone.length < 11 || phone.length > 11 || !phone.startsWith("03")) {
                binding.edtPhone.setError("please enter valid phone number and must start with 03")
            } else if (email.isEmpty()) {
                binding.edtEmail.setError("please enter email")
            } else if (!isValidString(email)) {
                binding.edtEmail.setError("please enter correct email")
            } else if (password.isEmpty()) {
                binding.edtPassword.setError("please enter password")
            } else {

                AppSettings.sharedInstance(this)!!.saveString(AppSettings.USERNAME, name)
                AppSettings.sharedInstance(this)!!.saveString(AppSettings.PHONE_NUMBER, phone)
                AppSettings.sharedInstance(this)!!.saveString(AppSettings.USEREMAIL, email)
                AppSettings.sharedInstance(this)!!.saveString(AppSettings.PASSWORD, password)

                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
                Toast.makeText(this, "account created", Toast.LENGTH_SHORT).show()
            }

        }


    }//class

    fun isValidString(str: String): Boolean {
        return EMAIL_ADDRESS_PATTERN.matcher(str).matches()
    }
}