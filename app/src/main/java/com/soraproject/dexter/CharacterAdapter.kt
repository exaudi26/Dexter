package com.soraproject.dexter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CharacterAdapter(private val characterList: List<Character>) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>(){

    inner class CharacterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val characterImage: ImageView = view.findViewById(R.id.characterImage)
        val characterName: TextView = view.findViewById(R.id.characterName)

        init {
            view.setOnClickListener {
                val character = characterList[adapterPosition]
                val context = view.context
                val intent = Intent(context, CharacterProfileActivity::class.java)

                // Pass all character attributes
                intent.putExtra("CHARACTER_NAME", character.name)
                intent.putExtra("CHARACTER_IMAGE", character.image)
                intent.putExtra("CHARACTER_QUOTE", character.quote)
                intent.putExtra("CHARACTER_ACTOR", character.actor)
                intent.putExtra("CHARACTER_BIRTHDAY", character.birthday)
                intent.putExtra("CHARACTER_GENDER", character.gender)
                intent.putExtra("CHARACTER_STATUS", character.status)
                intent.putExtra("CHARACTER_AFFILIATION", character.affiliation)

                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_character, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characterList[position]
        holder.characterName.text = character.name

        // Dynamically load image by name
        val context = holder.itemView.context
        val imageResId = context.resources.getIdentifier(character.image, "drawable", context.packageName)
        holder.characterImage.setImageResource(imageResId)
    }

    override fun getItemCount(): Int = characterList.size
}