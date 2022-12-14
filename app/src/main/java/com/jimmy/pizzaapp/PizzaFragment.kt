package com.jimmy.pizzaapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.jimmy.pizzaapp.databinding.FragmentPizzaBinding
import com.jimmy.pizzaapp.model.OrderViewModel


class PizzaFragment : Fragment() {

    private val sharedViewModel: OrderViewModel by activityViewModels()

    private lateinit var binding: FragmentPizzaBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_pizza, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            viewModel = sharedViewModel
            nextButton.setOnClickListener { goToDrinksScreen() }

            lifecycleOwner = viewLifecycleOwner

            cancelButton.setOnClickListener { cancelOrder() }

        }



    }
    fun goToDrinksScreen(){
        findNavController().navigate(R.id.action_pizzaFragment_to_drinkFragment)
    }

    fun cancelOrder(){
        sharedViewModel.resetOrder()

        findNavController().navigate(R.id.action_pizzaFragment_to_titleFragment)
    }

}