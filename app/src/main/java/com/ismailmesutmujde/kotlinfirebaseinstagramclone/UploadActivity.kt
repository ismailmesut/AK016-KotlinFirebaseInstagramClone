package com.ismailmesutmujde.kotlinfirebaseinstagramclone

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ismailmesutmujde.kotlinfirebaseinstagramclone.databinding.ActivityUploadBinding


class UploadActivity : AppCompatActivity() {

    private lateinit var bindingUploadActivity : ActivityUploadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingUploadActivity = ActivityUploadBinding.inflate(layoutInflater)
        val view = bindingUploadActivity.root
        setContentView(view)

    }

    fun selectImageClicked(view : View) {

    }

    fun uploadClicked(view : View) {

    }
}