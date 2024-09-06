package com.ismailmesutmujde.kotlinfirebaseinstagramclone.view

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.ismailmesutmujde.kotlinfirebaseinstagramclone.R
import com.ismailmesutmujde.kotlinfirebaseinstagramclone.databinding.ActivityFeedBinding
import com.ismailmesutmujde.kotlinfirebaseinstagramclone.model.Post


class FeedActivity : AppCompatActivity() {

    private lateinit var bindingFeedActivity: ActivityFeedBinding
    private lateinit var auth : FirebaseAuth
    private lateinit var db : FirebaseFirestore
    private lateinit var postArrayList : ArrayList<Post>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingFeedActivity = ActivityFeedBinding.inflate(layoutInflater)
        val view = bindingFeedActivity.root
        setContentView(view)

        auth = Firebase.auth
        db = Firebase.firestore

        postArrayList = ArrayList<Post>()

        getData()
    }

    private fun getData() {

        db.collection("Posts").addSnapshotListener { value, error ->
            if (error != null) {
                Toast.makeText(this, error.localizedMessage, Toast.LENGTH_LONG).show()
            } else {
                if(value != null) {
                    if (!value.isEmpty) {

                        val documents = value.documents
                        for (document in documents) {
                            // casting
                            val comment = document.get("comment") as String
                            val userEmeail = document.get("userEmail") as String
                            val downloadUrl = document.get("downloadUrl") as String

                            println(comment)

                            val post = Post(userEmeail, comment, downloadUrl)
                            postArrayList.add(post)
                        }
                    }
                }
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.instagram_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.add_post) {
            val intent = Intent(this, UploadActivity::class.java)
            startActivity(intent)
        } else if (item.itemId == R.id.sign_out) {
            auth.signOut()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}