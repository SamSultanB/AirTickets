package com.test.search.offers.presentation

import android.app.DatePickerDialog
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
import com.test.search.offers.presentation.uimodel.Destinations
import com.test.search.databinding.FragmentChooseCountryBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class OffersFragment : Fragment(R.layout.fragment_choose_country) {

    private val binding by viewBinding<FragmentChooseCountryBinding>()

    private val viewModel by viewModel<OffersViewModel>()

    private val adapter by lazy {
        AppAdapter.Builder()
            .add(TicketOffersAdapterDelegate())
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
        binding.allTicketsBtn.setOnClickListener {
            try {
                viewModel.nextFragment()
            }catch (e: Exception){
                Log.e("nav", e.message ?: "Something")
            }
        }
        binding.tab.turnBackDateBtn.setOnClickListener {
            openDatePickerDialog(1)
        }
        binding.tab.flightDateBtn.setOnClickListener {
            openDatePickerDialog(2)
        }
    }

    private fun observeTickets(){
        viewModel.ticketsResponse.observe(viewLifecycleOwner, Observer{ status ->
            when(status){
                is NetworkStatus.Success -> adapter.submitList(status.data)
                is NetworkStatus.Error -> Toast.makeText(requireContext(), status.message, Toast.LENGTH_SHORT).show()
                else -> {}
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

    private fun openDatePickerDialog(type: Int) {
        // Get current date to set as default in the dialog
        val currentDate = Calendar.getInstance()
        val year = currentDate.get(Calendar.YEAR)
        val month = currentDate.get(Calendar.MONTH)
        val day = currentDate.get(Calendar.DAY_OF_MONTH)

        // Create a DatePickerDialog
        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { _, selectedYear, selectedMonth, selectedDay ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(selectedYear, selectedMonth, selectedDay)
                val formattedDate = formatRussianDate(selectedDate.time)
                if (type == 1){
                    binding.tab.turnBackDateTxt.text = formattedDate
                }else{
                    binding.tab.flightDateTxt.text = formattedDate
                }
            },
            year,
            month,
            day
        )
        datePickerDialog.show()
    }

    private fun formatRussianDate(date: Date): String {
        val dateFormat = SimpleDateFormat("d MMM, E", Locale("ru"))
        return dateFormat.format(date)
    }

}