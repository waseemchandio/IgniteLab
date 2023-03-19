package com.example.ignetilabtest.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ignetilabtest.MainActivity
import com.example.ignetilabtest.R
import com.example.ignetilabtest.databinding.ActivityLoginBinding
import com.example.ignetilabtest.signup.SignUpActivity
import com.example.ignetilabtest.utils.AppSettings

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.tvSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }


        binding.loginButton.setOnClickListener {
            var prefNumber = AppSettings.sharedInstance(this)!!.getString(AppSettings.PHONE_NUMBER)
            var prefPassword = AppSettings.sharedInstance(this)!!.getString(AppSettings.PASSWORD)
            var phone = binding.edtPhone.text.toString()
            var password = binding.edtPassword.text.toString()


            if (phone.isEmpty()) {
                binding.edtPhone.setError("please enter phone number")
            } else if (password.isEmpty()) {
                binding.edtPassword.setError("please enter password")
            } else if (phone.equals(prefNumber) && password.equals(prefPassword)) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "credentials error", Toast.LENGTH_SHORT).show()
            }


        }

    }//class
}