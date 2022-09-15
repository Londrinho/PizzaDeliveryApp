package com.jimmy.pizzaapp

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.Intents.Insert.ACTION
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.jimmy.pizzaapp.databinding.FragmentSummaryBinding
import com.jimmy.pizzaapp.model.OrderViewModel


class SummaryFragment : Fragment() {

    private lateinit var binding: FragmentSummaryBinding

    private val sharedViewModel: OrderViewModel by activityViewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_summary, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel

        }

        binding.sendOrderBtn.setOnClickListener { sendOrder() }

        binding.cancelBtn.setOnClickListener { cancelOrder() }
    }

    fun sendOrder(){
        val orderSummary = getString(
            R.string.order_details,
            sharedViewModel.crust.value.toString(),
            sharedViewModel.pizza.value.toString(),
            sharedViewModel.drinks.toString(),
            sharedViewModel.price.value.toString()
        )

        val intent = Intent(Intent.ACTION_SEND)
            .setType("text/plain")
            .putExtra(Intent.EXTRA_SUBJECT, getString(R.string.new_pizza_order))
            .putExtra(Intent.EXTRA_TEXT, orderSummary)

        if (activity?.packageManager?.resolveActivity(intent, 0) != null) {
            startActivity(intent)
        }
    }

    fun cancelOrder(){
        sharedViewModel.resetOrder()

        findNavController().navigate(R.id.action_summaryFragment_to_titleFragment)
    }


}