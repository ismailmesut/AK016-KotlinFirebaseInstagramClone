package com.ismailmesutmujde.kotlinfirebaseinstagramclone

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.ismailmesutmujde.kotlinfirebaseinstagramclone.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var bindingMainActivity : ActivityMainBinding
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMainActivity = ActivityMainBinding.inflate(layoutInflater)
        val view = bindingMainActivity.root
        setContentView(view)

        // initialize
        auth = FirebaseAuth.getInstance()
        auth = Firebase.auth
    }

    fun signUpClicked(view : View) {

        val email = bindingMainActivity.emailText.text.toString()
        val password = bindingMainActivity.passwordText.text.toString()

        if(email.equals("") || password.equals("")) {
            Toast.makeText(this,"Enter email and password!", Toast.LENGTH_LONG).show()
        } else {
            auth.createUserWithEmailAndPassword(email, password).addOnSuccessListener {
                // success
                val intent = Intent(this@MainActivity, FeedActivity::class.java)
                startActivity(intent)
                finish()
            }.addOnFailureListener {
                // failure
                Toast.makeText(this@MainActivity, it.localizedMessage, Toast.LENGTH_LONG).show()
            }

        }


    }

    fun signInClicked(view : View) {

    }


}