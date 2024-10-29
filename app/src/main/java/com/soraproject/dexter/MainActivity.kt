package com.soraproject.dexter

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        //Menambahkan data karakter ke dalam daftar
        val character = listOf(
            Character("Dexter Morgan", R.drawable.dexter_morgan),
            Character("Debra Morgan", R.drawable.debra_morgan),
            Character("Vincent Masuka", R.drawable.vincent_masuka),
            Character("Angel Batista", R.drawable.angel_batista),
            Character("James Doakes", R.drawable.james_doakes)
        )

        val adapter = CharacterAdapter(character)
        recyclerView.adapter = adapter
    }
}