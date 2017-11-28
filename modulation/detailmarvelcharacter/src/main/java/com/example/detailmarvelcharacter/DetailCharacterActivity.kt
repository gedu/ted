package com.example.detailmarvelcharacter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.detailmarvelcharacter.extension.load
import com.example.marvelpojo.MarvelCharacter

import kotlinx.android.synthetic.main.activity_detail_character.*

class DetailCharacterActivity : AppCompatActivity() {

    companion object {

        private val MARVEL_ITEM = "MARVEL_ITEM"

        @JvmStatic
        fun newInstance(context: Context, marvelCharacter: MarvelCharacter): Intent {
            val intent = Intent(context, DetailCharacterActivity::class.java)
            intent.putExtra(MARVEL_ITEM, marvelCharacter)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_character)

        val marvelCharacter = intent.getSerializableExtra(MARVEL_ITEM) as MarvelCharacter


        character_title.text = marvelCharacter.name
        character_description.text = marvelCharacter.description
        character_image.load(marvelCharacter.image.fullUrl)
    }
}
