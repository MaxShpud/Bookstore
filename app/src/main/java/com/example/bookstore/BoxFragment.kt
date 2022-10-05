package com.example.bookstore

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.bookstore.databinding.FragmentBoxBinding

class BoxFragment: Fragment(R.layout.fragment_box) {

    private lateinit var binding: FragmentBoxBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBoxBinding.bind(view)

        val color = requireArguments().getInt(ARG_COLOR)
        binding.root.setBackgroundColor(color)
    }

    companion object {
        const val ARG_COLOR = "color"
    }

}