package com.example.bookstore

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.bookstore.databinding.FragmentRootBinding

class RootFragment : Fragment(R.layout.fragment_root) {

    private lateinit var binding: FragmentRootBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRootBinding.bind(view)

        binding.openYellowBoxButton.setOnClickListener {
            openBox(Color.rgb(255, 255, 200), "Yellow")
        }
        binding.openGreenBoxButton.setOnClickListener {
            openBox(Color.rgb(200, 255, 200), "Green")
        }

        val liveData =
            findNavController().currentBackStackEntry?.savedStateHandle // savedStateHandle сущность которая сохраняет своё состояние
                ?.getLiveData<Int>(
                    BoxFragment.EXTRA_RANDOM_NUMBER
                )
        liveData?.observe(viewLifecycleOwner) { randomNumber ->
            if (randomNumber != null)// for cancel duplicate random number after turning screen
                Toast.makeText(
                    requireContext(),
                    getString(R.string.generated_number, randomNumber),
                    Toast.LENGTH_SHORT
                ).show()
            liveData.value = null
        }
    }

    private fun openBox(color: Int, colorName: String) {
        val direction = RootFragmentDirections.actionRootFragmentToBoxFragment(colorName, color)

        findNavController().navigate(
            direction
        )
    }
}