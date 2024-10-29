package com.soraproject.dexter

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CharacterProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_profile)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Back to Main"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val characterImage: ImageView = findViewById(R.id.characterProfileImage)
        val characterName: TextView = findViewById(R.id.characterProfileName)
        val characterQuote: TextView = findViewById(R.id.characterProfileQuote)
        val characterActor: TextView = findViewById(R.id.characterProfileActor)
        val characterBirthday: TextView = findViewById(R.id.characterProfileBirthday)
        val characterGender: TextView = findViewById(R.id.characterProfileGender)
        val characterStatus: TextView = findViewById(R.id.characterProfileStatus)
        val characterAffiliation: TextView = findViewById(R.id.characterProfileAffiliation)

        // Retrieve data passed from the adapter
        characterName.text = intent.getStringExtra("CHARACTER_NAME")
        characterQuote.text = intent.getStringExtra("CHARACTER_QUOTE")
        characterActor.text = "Played by: ${intent.getStringExtra("CHARACTER_ACTOR")}"
        characterBirthday.text = "Birthday: ${intent.getStringExtra("CHARACTER_BIRTHDAY")}"
        characterGender.text = "Gender: ${intent.getStringExtra("CHARACTER_GENDER")}"
        characterStatus.text = "Professional Status: ${intent.getStringExtra("CHARACTER_STATUS")}"
        characterAffiliation.text = "Affiliation: ${intent.getStringExtra("CHARACTER_AFFILIATION")}"

        // Set image resource dynamically
        val image = intent.getStringExtra("CHARACTER_IMAGE")
        val imageResId = resources.getIdentifier(image, "drawable", packageName)
        characterImage.setImageResource(imageResId)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish() // Go back to MainActivity
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}