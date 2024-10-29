package com.soraproject.dexter

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import java.io.InputStreamReader
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var characterAdapter: CharacterAdapter
    private val characterList = mutableListOf<Character>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Dexter"
        
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        loadCharacterData()

        // Set up the adapter
        characterAdapter = CharacterAdapter(characterList)
        recyclerView.adapter = characterAdapter
    }

    private fun loadCharacterData() {
        val inputStream = assets.open("characters.json")
        val reader = InputStreamReader(inputStream)
        val gson = Gson()
        val characterListType = object : TypeToken<List<Character>>() {}.type
        val characters = gson.fromJson<List<Character>>(reader, characterListType)

        characterList.addAll(characters)
    }
}