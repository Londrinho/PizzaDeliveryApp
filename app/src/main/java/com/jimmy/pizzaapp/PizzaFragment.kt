package com.jimmy.pizzaapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.jimmy.pizzaapp.databinding.FragmentPizzaBinding


class PizzaFragment : Fragment() {

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

        binding.nextButton.setOnClickListener { goToDrinksScreen() }

    }
    fun goToDrinksScreen(){
        findNavController().navigate(R.id.action_pizzaFragment_to_drinkFragment)
    }

}