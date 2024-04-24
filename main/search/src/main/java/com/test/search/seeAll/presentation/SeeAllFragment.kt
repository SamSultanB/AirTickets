package com.test.search.seeAll.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.test.common.network.NetworkStatus
import com.test.core.adapterDelegate.AppAdapter
import com.test.search.R
import com.test.search.databinding.FragmentSeeAllBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SeeAllFragment : Fragment(R.layout.fragment_see_all) {

    private val binding by viewBinding<FragmentSeeAllBinding>()

    private val viewModel by viewModel<SeeAllViewModel>()

    private val adapter by lazy {
        AppAdapter.Builder()
            .add(TicketsAdapterDelegate())
            .build()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adaptersSetUp()
        viewModel.getTickets()
        observeTickets()
        binding.arrowBackBtn.setOnClickListener {
            viewModel.navigateBack()
        }
    }

    private fun adaptersSetUp(){
        binding.flightsRv.layoutManager = LinearLayoutManager(requireContext())
        binding.flightsRv.adapter = adapter
    }

    private fun observeTickets(){
        viewModel.ticketsResponse.observe(viewLifecycleOwner, Observer{ status ->
            when(status){
                is NetworkStatus.Success -> adapter.submitList(status.data)
                is NetworkStatus.Error -> Toast.makeText(requireContext(), status.message, Toast.LENGTH_SHORT).show()
                is NetworkStatus.Loading -> {}
                else -> {}
            }
        })
    }

}