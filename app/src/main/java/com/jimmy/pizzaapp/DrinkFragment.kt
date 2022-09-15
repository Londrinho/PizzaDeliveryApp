package com.jimmy.pizzaapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.jimmy.pizzaapp.databinding.FragmentDrinkBinding
import com.jimmy.pizzaapp.model.OrderViewModel


class DrinkFragment : Fragment() {

    private val sharedViewModel: OrderViewModel by activityViewModels()

    private lateinit var binding: FragmentDrinkBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_drink, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            viewModel = sharedViewModel

            nextButton.setOnClickListener { goToOrderScreen()  }

            lifecycleOwner = viewLifecycleOwner

            cancelButton.setOnClickListener { cancelOrder() }
        }



    }

    fun goToOrderScreen(){
        findNavController().navigate(R.id.action_drinkFragment_to_summaryFragment)
    }

    fun cancelOrder(){

        sharedViewModel.resetOrder()

        findNavController().navigate(R.id.action_drinkFragment_to_titleFragment)
    }


}