package com.example.etudiants.binding_adapter

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.etudiants.pojo.EtuItem

object BindingAdapter {
    @BindingAdapter("arItemToString")
    @JvmStatic
    fun arItemToStringBis(textView: TextView, arItems: ArrayList<EtuItem>) {
        var stringBuilder = StringBuilder()
        arItems?.forEach {(item) ->
            stringBuilder.append("-> $item\n")
        }
        textView.text = stringBuilder.toString()
    }
}