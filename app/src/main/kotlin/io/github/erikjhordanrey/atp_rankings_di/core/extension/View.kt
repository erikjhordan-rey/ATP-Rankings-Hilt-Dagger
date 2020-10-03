package io.github.erikjhordanrey.atp_rankings_di.core.extension

import android.view.View

fun View.hideOrShow(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}
