package com.test.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.test.search.databinding.FragmentChooseCountryBinding

class ChooseCountryFragment : Fragment(R.layout.fragment_choose_country) {

    private val binding by viewBinding<FragmentChooseCountryBinding>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}