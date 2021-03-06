package io.github.erikjhordanrey.atp_rankings_di.core.extension

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.setUrl(url: String) {
    Glide.with(context).load(url).into(this)
}
