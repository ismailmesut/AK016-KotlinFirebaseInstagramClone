package com.ismailmesutmujde.kotlinfirebaseinstagramclone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ismailmesutmujde.kotlinfirebaseinstagramclone.databinding.ActivityFeedBinding


class FeedActivity : AppCompatActivity() {

    private lateinit var bindingFeedActivity: ActivityFeedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingFeedActivity = ActivityFeedBinding.inflate(layoutInflater)
        val view = bindingFeedActivity.root
        setContentView(view)


    }
}