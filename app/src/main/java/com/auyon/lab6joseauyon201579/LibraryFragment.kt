package com.auyon.lab6joseauyon201579

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment


class LibraryFragment : Fragment(R.layout.fragment_library) {

    private lateinit var buttonCount:Button
    private var count: Int = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonCount = view.findViewById(R.id.addButton)

        setListeners()
    }
    private fun setListeners(){
        var tv= view?.findViewById<TextView>(R.id.songsText)
        buttonCount.setOnClickListener{
            count++
            tv?.text = "$count songs"

        }
    }
}


