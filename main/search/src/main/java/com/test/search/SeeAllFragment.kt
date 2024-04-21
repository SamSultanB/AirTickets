package com.test.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.test.search.databinding.FragmentSeeAllBinding

class SeeAllFragment : Fragment(R.layout.fragment_see_all) {

    private val binding by viewBinding<FragmentSeeAllBinding>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}