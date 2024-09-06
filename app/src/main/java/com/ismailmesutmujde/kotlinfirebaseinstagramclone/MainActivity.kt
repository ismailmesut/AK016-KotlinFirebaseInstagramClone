package com.ismailmesutmujde.kotlinfirebaseinstagramclone

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ismailmesutmujde.kotlinfirebaseinstagramclone.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var bindingMainActivity : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMainActivity = ActivityMainBinding.inflate(layoutInflater)
        val view = bindingMainActivity.root
        setContentView(view)


    }

    fun signUpClicked(view : View) {

    }

    fun signInClicked(view : View) {

    }


}