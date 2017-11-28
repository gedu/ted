package com.example.detailmarvelcharacter.extension

import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by eduardo.graciano on 11/17/17.
 */

fun ImageView.load(url: String) {
    Picasso.with(context).load(url).placeholder(android.R.color.darker_gray).into(this)
}