package com.test.search.chooseCountry.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.test.common.network.NetworkStatus
import com.test.core.adapterDelegate.AppAdapter
import com.test.search.R
import com.test.search.chooseCountry.presentation.uimodel.Destinations
import com.test.search.databinding.FragmentChooseCountryBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChooseCountryFragment : Fragment(R.layout.fragment_choose_country) {

    private val binding by viewBinding<FragmentChooseCountryBinding>()

    private val viewModel by viewModel<ChooseCountryViewModel>()

    private val adapter by lazy {
        AppAdapter.Builder()
            .add(TicketsAdapterDelegate())
            .build()
    }

    private lateinit var destinations: Destinations

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adaptersSetUp()
        viewModel.getTickets()
        observeTickets()
        destinations = viewModel.getDestinations()
        clickListeners()
    }

    private fun observeTickets(){
        viewModel.ticketsResponse.observe(viewLifecycleOwner, Observer{ status ->
            when(status){
                is NetworkStatus.Success -> adapter.submitList(status.data)
                is NetworkStatus.Error -> Toast.makeText(requireContext(), status.message, Toast.LENGTH_SHORT).show()
                is NetworkStatus.Loading -> {}
            }
        })
    }

    private fun clickListeners(){
        binding.replaceBtn.setOnClickListener {
            if(binding.fromEditTxt.text.toString() == destinations.start
                && binding.toEditTxt.text.toString() == destinations.destination){
                binding.fromEditTxt.setText(destinations.destination)
                binding.toEditTxt.setText(destinations.start)
            }else{
                binding.fromEditTxt.setText(destinations.start)
                binding.toEditTxt.setText(destinations.destination)
            }
        }
    }

    private fun adaptersSetUp(){
        binding.ticketsRv.layoutManager = LinearLayoutManager(requireContext())
        binding.ticketsRv.adapter = adapter
    }

}