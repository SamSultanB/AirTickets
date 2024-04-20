package com.test.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.test.main.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {

    private val viewBinding by viewBinding<FragmentMainBinding>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}