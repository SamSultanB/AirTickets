package com.test.main.presentation

import android.os.Bundle
import android.util.LayoutDirection
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.test.core.adapterDelegate.AppAdapter
import com.test.main.R
import com.test.main.databinding.BottomSheetItemBinding
import com.test.main.databinding.FragmentMainBinding
import com.test.main.presentation.uimodel.Offer
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding by viewBinding<FragmentMainBinding>()

    private val viewModel by viewModel<MainViewModel>()

    private val adapter by lazy {
        AppAdapter.Builder()
            .add(OfferAdapterDelegate())
            .build()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.searchIc.setOnClickListener {
            viewModel.nextScreen()
        }

        adapter.submitList(listOf(Offer(1, "Die Antwoord", "Будапешт", "",
            "от 22 264 ₽")))

        binding.suggestionsRv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.suggestionsRv.adapter = adapter

        binding.toEditTxt.setOnFocusChangeListener { view, focus ->
            if (focus){
                showModalScreen()
            }
        }
    }

    private fun showModalScreen(){

        val dialog = BottomSheetDialog(requireContext())

        val view = BottomSheetItemBinding.inflate(layoutInflater)

        dialog.setContentView(view.root)

        dialog.show()
    }

}